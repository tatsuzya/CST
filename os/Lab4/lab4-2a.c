#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#define BUFSIZE 1024

void *printf1 (){
    int fd;
    char arr[BUFSIZE];
    char *fifo = "fifo1";
    ssize_t nbytes;

    fd = open(fifo, O_RDONLY);
    if(fd < 0){
        printf("unable to locate fifo1");
        exit(1);
    }

    while((nbytes = read(fd, arr, BUFSIZE)) > 0){
        write(1, arr, nbytes);
    }

    close(fd);
    return 0; // required if joining thread
}
void *printf2 (){
    int fd;
    char arr[BUFSIZE];
    char * fifo = "fifo2";
    ssize_t nbytes;

    fd = open(fifo,O_RDONLY);
    if(fd < 0){
        printf("unable to locate fifo2");
    }

    while((nbytes = read(fd, arr, BUFSIZE)) > 0){
        write(1, arr, nbytes);
    }
    close(fd);
    return 0;  // required if joining thread
}
int main(){
    pthread_t thread1, thread2;

    pthread_create( &thread1, NULL, printf1, NULL);
    pthread_create( &thread2, NULL, printf2, NULL);

    pthread_join( thread1, NULL);
    pthread_join( thread2, NULL);

    return 0;
}
