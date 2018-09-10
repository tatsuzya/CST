#include <unistd.h>
#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <semaphore.h>
#include <sys/types.h>
#include <fcntl.h>
#define NITEMS 100
#define NPRODUCERS 2
#define NCONSUMERS 2

sem_t empty, full, mutex;

struct{
    int nused; // number of used slot
    int next_writes; // next element to write
    int next_read;  // next element to read
    int data[NITEMS]; // buffer
}buf = { 0, 0, 0, {0}}; // buf inistialization

/* produce items and store it in buffer */
void *producer(void *ptr){
    int i;
    int id = *(int *)ptr;
    int item;

    while(1){
        sem_wait(&empty);   // wait for empty spaces in buffer
        sem_wait(&mutex);   // lock critical region

        /* insert items into buffer */
        i = buf.next_writes;
        item = buf.nused++;
        buf.data[i] = item;

        printf("P%d %d --> [%d]\n", id, buf.data[i],i);
        buf.next_writes = (buf.next_writes + 1) % NITEMS;

        sem_post(&mutex);  // unlock
        sem_post(&full);   // set status to full
    }
}

/* consume item from buffer */
void *consumer(void *ptr){
    int i;
    int id = *(int *)ptr;

    while(1){
        sem_wait(&full);  // wait for buffer to have at least 1 item
        sem_wait(&mutex); // lock critical region

        /* read item from buffer */
        i = buf.next_read;
        printf("C%d: %d <-- [%d]\n", id, buf.data[i], i);
        buf.next_read = (buf.next_read +1) % NITEMS;

        sem_post(&mutex);  // unlock critical region
        sem_post(&empty);  // set status to empty
    }
}

int main(void){
    pthread_t prod[NPRODUCERS], cons[NCONSUMERS]; // array of threads
    int id[2];

    /* semaphore initialization */
    sem_init(&empty, 0, NITEMS);
    sem_init(&full, 0, 0);
    sem_init(&mutex, 0, 1);

    /* create producer threads */
    for( int i = 0; i < NPRODUCERS; i++){
        id[i] = i;
        pthread_create(&prod[i], NULL, producer, (void *)&id[i]);
    }

    /* create consumer threads */
    for( int i = 0; i < NCONSUMERS; i++){
        id[i] = i;
        pthread_create(&cons[i], NULL, consumer, (void *)&id[i]);
    }

    sleep(1); // sleep for 1 second
    return 0;
}
