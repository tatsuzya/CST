#define _GNU_SOURCE
#include <unistd.h>
#include <sys/types.h>
#include <signal.h>
#include <stdlib.h>
#include <stdio.h>
#define BUFSIZE 1024

volatile sig_atomic_t flag = 4;

void handler(){
    --flag;
    if(flag == 0){
        printf("no input entered. program will now exit\n");
        sleep(15);
        exit(2);
    }

    printf("Please enter a message?\n");
    alarm(10);
}

int main(void){
    char message[1024];
    struct sigaction action;

    action.sa_handler = handler;
    action.sa_flags = 0;
    action.sa_flags |= SA_RESTART;
    if(sigaction(SIGALRM, &action, NULL) == -1){
        perror("sigaction");
        return 1;
    }

    alarm(10);

    printf("Please enter a message?\n");

    if(fgets(message, BUFSIZE, stdin) != NULL){
        alarm(0);
        printf("%s\n", message);
        sleep(15);
        exit(1);
    }
    return 0;
}
