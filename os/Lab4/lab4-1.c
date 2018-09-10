#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>

void *print (void *ptr);

int main(void){
    pthread_t thread1, thread2;
    char *message1 = "hello";
    char *message2 = "world";

    pthread_create(&thread1, NULL, print, (void *) message1);
    pthread_create(&thread2, NULL, print, (void *) message2);

    pthread_join(thread1, NULL);
    pthread_join(thread2, NULL);

    return 0;
}

void *print(void *ptr){
    char *message;
    message = (char*) ptr;
    for(int i = 0; i < 100000; i++){
        printf("%s \n", message);
    }
    return 0;
}
