#define _GNU_SOURCE
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <semaphore.h>
#include <fcntl.h>
#include <sys/mman.h>
#include <sys/shm.h>

int main(){
    unsigned int counter = 0;
    int *map;
    int shm_fd;
    const char *mem = "/mem";
    const char *sema = "/sema";
    sem_t *sem;

    shm_fd = shm_open(mem, O_CREAT | O_RDWR, 0660);   // create shared memory object

    if(shm_fd == -1){   // error checking
        perror("shm_open");
        return 1;
    }

    ftruncate(shm_fd, 4);  // set size of shared memory object

    sem = sem_open(sema, O_CREAT | O_EXCL, 0660, 1);   // create named semaphore
    if(sem == SEM_FAILED){
        perror("sem_open");
        return 1;
    }

    map = mmap(0, sizeof(int), PROT_WRITE, MAP_SHARED, shm_fd, 0);  // map to shared memory object
    if(map == MAP_FAILED){
        perror("mmap");
        return 1;
    }

    map[0] = counter;

    return 0;
}
