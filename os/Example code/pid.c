#include <unistd.h>
#include <stdio.h>

int main(void){
    pid_t pid;

    pid = fork();

    if(pid == -1){
        perror("fork");
        return 1;
    }

    if(pid >0){  // parent
        printf("parent : PID %d \n", getpid());
        printf("fork return %d \n", pid);
    }else{ // child
        printf("child : PID %d \n", getpid());
        printf("fork return %d \n", pid);
        execlp("ls","ls","-l",(char*) 0);
    }
    return 0;
}
