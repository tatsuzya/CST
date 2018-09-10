#define _GNU_SOURCE
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <sys/mman.h>
#include <sys/wait.h>
#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <string.h>

int main(void){
    char *message;
    pid_t pid;

    message = mmap(0, sizeof(int), PROT_READ | PROT_WRITE ,MAP_SHARED | MAP_ANON, -1, 0);  // memory mapping with shared object

    if(message == MAP_FAILED){    //error checking
        perror("mmap");
        return 1;
    }

    pid = fork();

    if(pid == -1){
        perror("fork");
        return 1;
    }else if(pid == 0){
        strcpy(message , "hello world");
    }else{
        wait(NULL);
        printf("%s\n", message);
    }
    return 0;
}
