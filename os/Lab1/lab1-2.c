#include <unistd.h>
#include <ctype.h>
#define BUFSIZE 1024

int main(void){
    char buffer[BUFSIZE];
    ssize_t nbytes;

    write(1, "please enter passage\n", 22);
    while((nbytes = read(0, buffer, BUFSIZE))>0){

        for(ssize_t i = 0; i < nbytes; i++){
            buffer[i] = toupper(buffer[i]); // touppser only accept 1 character at a time
        }

        write(1, buffer, nbytes);
        write(1, "please enter passage\n", 22);
    }
    return 0;
}
