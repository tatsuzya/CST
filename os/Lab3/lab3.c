#define _GNU_SOURCE
#define MAXARGS 1024
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/wait.h>

int main(void){

    char *line = (char*) malloc(MAXARGS * sizeof(char));    // dynamic allocated array
    char *cmd[MAXARGS];    // array of fixed size ( used to copy content from line)
    int i;    // index
    size_t len = MAXARGS;    // length of the user input
    ssize_t nread;
    char *delim;    // deliminator

    if(line == NULL){    // malloc failed
        perror("unable to allocate buffer");
        return 1;
    }

    printf(">");
    while((nread = getline(&line, &len, stdin))!=-1){    // read from user input as a line

        pid_t pid = fork();

        if(pid == -1){    //fork failed
            perror("fork");
            return 1;
        }else if(pid == 0){    //child process
            delim = strtok(line, " \n");  // tokenlized line with character " " and \n
            i = 0;    // reset index to zero
            while(delim != NULL){
                cmd[i++] = delim;    // store token into array
                delim = strtok(NULL, " \n");   // no token to retrive
            }
            cmd[i] = (char*) 0;    // add \0 to end of array
            execvp(cmd[0],cmd);
        }else{    // parent process
            wait(NULL);    // wait for child process to complete
        }
        printf(">");
    }
    free(line);    // deallocate dynamic allocated array
    return 0;
}
