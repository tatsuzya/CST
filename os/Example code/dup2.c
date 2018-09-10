#include <unistd.h>
#include <stdio.h>
#include <fcntl.h>
#include <sys/types.h>
#define BUFSIZE 1024

int main(void){
  int fd;
  ssize_t nbytes;
  char buffer[BUFSIZE];

  if((fd = open("input", O_RDONLY)) == -1){
    perror("open");
    return 1;
  }
  if(dup2(fd, STDIN_FILENO) == -1){
    perror("dup2");
    return 2;
  }

  while((nbytes = read(STDIN_FILENO, buffer, BUFSIZE)) > 0){
    write(STDOUT_FILENO, buffer, nbytes);
  }

  close(fd); // there is still a file descriptor active even if the file is closed
  return 0;
}
