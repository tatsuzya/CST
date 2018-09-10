#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/mman.h>
#include <ctype.h>

int main(int argc, char *argv[])
{
    int i, j;
    int fd;
    char *map;

    if(argc != 3){
        perror("invalid input");
        return 1;
    }

    fd = open(argv[1], O_RDWR);  // open file for reading and writing
    if (fd == -1) {   // error checking
        perror("open");
        return 1;
    }

    struct stat st;   // file stat
    if(fstat(fd, &st)){
        perror("fstat");
        return 1;
    }
    off_t size = st.st_size;  // finding file size

    map = mmap(0, size, PROT_READ | PROT_WRITE, MAP_SHARED, fd, 0);   // memory mapping to read and write
    if (map == MAP_FAILED) {    // error checking
        close(fd);
        perror("mmap");
        return 1;
    }

    j = atoi(argv[2]);  // convert a string to int
    for(i = 0; i < j; i++){
        map[i] = toupper(map[i]);
    }

    if (munmap(map, size) == -1) {  // unmap
        close(fd);
        perror("munmap");
        return 1;
    }

    close(fd);  // close file
    return 0;
}
