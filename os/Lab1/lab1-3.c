#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#define BUFSIZE 1024

int main(int argc, char* argv[]){

    char buffer[BUFSIZE];
    ssize_t nbytes;

    // exit the program is command prompt argument is not the correct format
    if(argc != 3){
        write(1, "invalid command line arguments\n", 32);
        return 1;
    }

    // open()
    // return -1 , new file descriptor
    // -1 - failutre (throw errno if set properly)
    // file descriptor - success
    int src = open(argv[1], O_RDONLY);
    if(src < 0){
        write(1, "file does not exist\n", 21);
        return 1;
    }

    // creat()
    // 0660 - enable user and group permission to read and write to file
    int des = creat(argv[2],0660);

    while((nbytes = read(src,buffer,BUFSIZE))>0){
        write(des,buffer,nbytes);
    }
    close(src);
    close(des);

    return 0;
}
