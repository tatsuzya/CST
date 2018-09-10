#define _GNU_SOURCE
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/shm.h>
#include <sys/stat.h>
#include <sys/mman.h>

int main(){
    int size = 101;
    const char *name = "/test";
    int shm_fd;
    int *map;

    shm_fd = shm_open(name, O_RDONLY, 0660);  // open shared memory object
    if(shm_fd == -1){   // error checking
        perror("shm_open");
        return 1;
    }

    map = mmap(0, size, PROT_READ, MAP_SHARED, shm_fd, 0);
    if(map == MAP_FAILED){    // error checking
        perror("mmap");
        return 1;
    }

    for(int i = 1; i < map[0] + 1; i++){
        printf("%d\n", map[i]);
    }

    if((shm_unlink(name))==-1){   // unlink shared memory object
        perror("smh_unlink");
        return 1;
    }

    return 0;
}
