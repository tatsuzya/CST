#include <unistd.h>
#include <pthread.h>
#include <stdlib.h>
#include <stdio.h>
#include <sys/types.h>
#include <fcntl.h>
#define NITEMS 100  // number of itmes 
#define NPRODUCERS 2  // number of producer threads
#define NCONSUMERS 2  // number of consumer threads

pthread_mutex_t m;  // lock
pthread_cond_t not_empty, not_full;  // condition variables

struct{
    int nused;  // number of spaces used
    int next_writes;  // next index to write
    int next_read;  // next index to read
    int data[NITEMS];  // buffer
}buf = { 0, 0, 0, {0}};  // variable initialization

void *producer(void *ptr){
    int i;
    int id = *(int*)ptr;
    int item;

    while(1){
        pthread_mutex_lock(&m);  // lock the critical region

        // wait until the buffer has spaces to allocate item
        while(buf.nused == NITEMS){
            pthread_cond_wait(&not_full, &m);
        }

        // create items
        i = buf.next_writes;
        item = buf.nused++;
        buf.data[i] = item;

        printf("P%d %d: --> [%d]\n", id, buf.data[i], i);
        buf.next_writes = (buf.next_writes +1) % NITEMS;

        pthread_cond_signal(&not_empty);  // wake up consumer
        pthread_mutex_unlock(&m);  // unlock critical region
    }
}

void *consumer(void *ptr){
    int i;
    int id = *(int *)ptr;

    while(1){
        pthread_mutex_lock(&m);  // lock critical region

        // wait until buffer has items to consume
        while(buf.nused == 0){
            pthread_cond_wait(&not_empty, &m);
        }

        // consume items
        i = buf.next_read;
        buf.nused--;
        printf("C%d: %d <-- [%d]\n", id, buf.data[i], i);
        buf.next_read = (buf.next_read + 1) % NITEMS;

        pthread_cond_signal(&not_full);  // wake up producer
        pthread_mutex_unlock(&m);  // unlock critcal region
    }
}

int main(){
    pthread_t prod[NPRODUCERS], cons[NCONSUMERS];
    int id[2];

    pthread_mutex_init(&m, 0);
    pthread_cond_init(&not_full, 0);   // condition variable initialization
    pthread_cond_init(&not_empty, 0);  // condition variable initialization

    // create prducer threads
    for(int i = 0; i < NPRODUCERS; i++){
        id[i] = i;
        pthread_create(&prod[i], NULL, producer, (void *)&id[i]);
    }

    // create consumer threads
    for(int i = 0; i < NCONSUMERS; i++){
        id[i] = i;
        pthread_create(&cons[i], NULL, consumer, (void *)&id[i]);
    }

    // sleep for 1 sec
    sleep(1);
    return 0;
}
