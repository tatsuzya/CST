#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <string.h>
#define BUFSIZE 1024

int main(int argc, char*argv[]){
    pid_t pid;
    pid = fork();  // forking process

    // ls - display content of current directory
    // ls -l - display long list of content of current directory
    // -- - end option (any argument after -- will be treated as directory rather than switches)
    char *ls_argv[BUFSIZE] = {"ls","-l","--",(char*) 0}; // initialize array with 3 commands

    if(pid == -1){  // fork failed
        perror("fork");
        return 1;
    }else if(pid == 0){   // child process
        for(int i = 1; i < argc; i++){   // index starts at 1 as 0 is reserved for a.out
            ls_argv[i + 2] = argv[i];    // index starts at 2 as ls -l -- exist in the array
        }
        ls_argv[argc + 2] = (char*) 0;  // add \0 to end of the array
        execvp(ls_argv[0],ls_argv);
    }else{ // parent process
        wait(0);
    }
    return 0;
}
