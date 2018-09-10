#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#define BUFSIZE 1024

int main(int argc, char *argv[]){
    char buffer[BUFSIZE];
    ssize_t nbytes;

    if(argc != 3){
        write(1, "invlaid command line arguments\n" , 32);
        return 1;
    }

    int src = open(argv[1], O_RDONLY);
    if(src < 0){
        write (1, "file does not exist\n", 21);
        return 1;
    }

    // open file to test if it exists or not
    // if exist, perror and exit program
    // if not, create new file and write to file
    // 0660 - enable user and group permission to read and write
    int des = open(argv[2], O_WRONLY | O_CREAT | O_EXCL,0660);
    if(des < 0){
        write(1, "file exist in the directory\n",31);
        return 1;
    }else{
        write(1, "file is created\n", 18);
        while((nbytes = read(src, buffer, BUFSIZE)) > 0){
            write(des, buffer, nbytes);
        }
    }

    close(src);
    close(des);

    return 0;
}
