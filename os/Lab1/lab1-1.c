#include <unistd.h>
#define BUFSIZE 1024

int main(void){
    char buffer[BUFSIZE];
    ssize_t nbytes;

    // read()
    // return 0, -1, positive value
    // 0 = EOF
    // -1 = fail
    // positive = success
    while((nbytes = read(0, buffer, BUFSIZE)) > 0){
        write(1 , buffer, nbytes);
    }
    return 0;
}
