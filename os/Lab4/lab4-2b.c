#define _GNU_SOURCE
#include <unistd.h>
#include <stdio.h>
#include <poll.h>
#include <signal.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#define BUFSIZE 1024

int main(){
    struct pollfd fds[2];
    ssize_t nbytes;
    char arr[BUFSIZE];

    /* open fifo for reading */
    int fifo1 = open("fifo1", O_RDONLY);
    int fifo2 = open("fifo2", O_RDONLY);

    fds[0].fd = fifo1;
    fds[1].fd = fifo2;
    fds[0].events = POLLIN;
    fds[1].events = POLLIN;

    while(1){
        int ret = poll(fds, 2 , -1);

        if(ret < 0){
            perror("poll");
            return 1;
        }

        if(fds[0].revents & POLLIN){
            if((nbytes = read(fifo1, arr, BUFSIZE)) > 0){
                write(1, arr, nbytes);
            }
        }
        if(fds[1].revents & POLLIN) {
            if((nbytes = read(fifo2, arr, BUFSIZE)) > 0){
                write(1, arr, nbytes);
            }
        }
    }
    close(fifo1); // close fifo1
    close(fifo2); // close fifo2
    return 0;
}
