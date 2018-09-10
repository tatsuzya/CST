#define _BSD_SOURCE
#include <unistd.h>
#include <stdio.h>
#include <dirent.h>
#include <string.h>
#include <sys/stat.h>


void list(char *dir, int indent)
{
    DIR *dp;
    struct dirent *entry;
    struct stat statbuf;
    int spaces = indent *2;

    if((dp = opendir(dir)) == NULL) {
        perror("opendir");
        return;
    }

    chdir(dir);

    while((entry = readdir(dp)) != NULL) {

        lstat(entry->d_name,&statbuf);

        if(S_ISDIR(statbuf.st_mode)) {
            if(strcmp(".",entry->d_name) == 0 || strcmp("..",entry->d_name) == 0)
                continue;
            printf("%*s%s/\n",spaces,"",entry->d_name);

            list(entry->d_name,indent+1);
        }
        else{
            printf("%*s%s\n",spaces,"",entry->d_name);
        }
    }

    chdir("..");
    if(closedir(dp) == -1){
        perror("closedir");
        return;
    }
}


int main(int argc, char* argv[])
{
    char *dir, cmd[2] = ".";

    if(argc < 2){
        perror("invalud arguments");
        return 1;
    }
    if(argc != 2){
        dir = cmd;
    }
    else{
        dir = argv[1];
    }

    list(dir, 0);

    return 0;
}
