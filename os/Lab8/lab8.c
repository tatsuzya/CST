#define _GNU_SOURCE
#define MAXARGS 1024
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/wait.h>

int main(void){
    char *line;  // user input
    char *cmd1[MAXARGS], *cmd2[MAXARGS];  // cmd1 = first command , cmd2 = second command
    int fd[2];  // file descriptor
    int i, j, has_pipe;
    pid_t pid1, pid2, pid;
    char* delim;
    size_t len = MAXARGS;
    ssize_t nread;

    printf(">");
    while((nread = getline(&line, &len, stdin)) != -1){
        delim = strtok(line, " \n");

        /* resest */
        i = 0;
        j = 0;
        has_pipe = 0;

        while(delim != NULL){
            if(delim[0] == '|'){  // if pipe exist
                has_pipe = 1;  // change to true
            }else if(has_pipe == 0){
                cmd1[i++] = delim;
            }else{
                cmd2[j++] = delim;
            }
            delim = strtok(NULL, " \n");
        }

        cmd1[i] = (char*) 0;
        cmd2[j] = (char*) 0;

        if(has_pipe == 0){  // if no pipe exists
            pid = fork();

            if(pid < 0){
                perror("fork");
                return 1;
            }else if(pid == 0){
                execvp(cmd1[0], cmd1);
            }
            wait(NULL);
        }else{  // if pipe exists
            pipe(fd);  // create pipe

            pid1 = fork();

            if(pid1 < 0){
                perror("fork1");
                return 1;
            }else if(pid1 == 0){
                dup2(fd[1], STDOUT_FILENO);  // close writing end
                close(fd[0]);
                close(fd[1]);
                execvp(cmd1[0], cmd1);  // execute first command
            }

            pid2 = fork();

            if(pid2 < 0){
                perror("fork2");
                return 1;
            }else if(pid2 == 0){
                dup2(fd[0], STDIN_FILENO);  // close reading end
                close(fd[0]);
                close(fd[1]);
                execvp(cmd2[0], cmd2);  // execute second command
            }
            close(fd[0]);
            close(fd[1]);
            waitpid(pid1, NULL, 0);  // wait for child process to end. Note: do not wait during process as it may conflict with pipe
            waitpid(pid2, NULL, 0);  // wait for child process to end
        }
        printf(">");
    }
    return 0;
}
