#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>

int main(void){
    pid_t pid = fork();

    if(pid == -1){
      perror("fork");
      return 1;
    }

    if(pid > 0){
        sleep(15);
        wait(0);
    }
    return 0;
}
