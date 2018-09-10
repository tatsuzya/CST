#define _GNU_SOURCE
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <sys/stat.h>
#include <fcntl.h>
#define MAXARGS 1024  // maximum argument allowed for input

int main(void){
    char *line;  // user input
    char *cmd[MAXARGS];  // command line argument
    int i, in, out;  // in - < redirection , out - > redirection
    size_t len = MAXARGS;
    ssize_t nread;  // number of byte read
    char *delim;  // deliminator

    printf(">");

    while((nread = getline(&line, &len, stdin))!= -1){  // as long as theres is an input
        pid_t pid = fork(); // create new process

        if(pid == -1){
            perror("fork");
            return 1;
        }else if(pid == 0){  // child process
            delim = strtok(line, " \n");  // tokenize user input. in this case, it read until a space and \n is encountered

            for(i = 0; delim != NULL; i++){  // loop through the input
                if(delim[0] == '<'){  // if token contain < as first letter
                    in = open(&delim[1], O_RDONLY);  // open file for read only. Note: delim[1] is used as it start at 2nd element of the token which ignore < as the first letter
                    if(in == -1){
                        perror("open");
                        return 1;
                    }
                    dup2(in, STDIN_FILENO);  // duplicate input to stdin. Note: STDIN_FILENO is built-in macro which is set as 0
                    close(in);  // close file
                }else if(delim[0] == '>'){  // if token contain > as first letter
                    out = creat(&delim[1], 0660);  // create file with user/grup permission
                    if(out == -1){
                        perror("creat");
                        return 1;
                    }
                    dup2(out, STDOUT_FILENO);  // dplicate output to stdout. Note: STDOUT_FILENO is built-in macro which is set as 1
                    close(out);  // close output
                }else{
                    cmd[i] = delim;  // place token into the array
                }
                delim = strtok(NULL, " \n");  // end of the tokenization
            }
            cmd[i] = (char*) 0; // end of the array
            execvp(cmd[0], cmd);
        }else{  // parent process
            wait(NULL);  // must wait for child process to finish to avoid zombie process
        }
        printf(">");
    }
    return 0;
}
