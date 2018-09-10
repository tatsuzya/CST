#define _GNU_SOURCE
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/shm.h>
#include <sys/stat.h>
#include <sys/mman.h>
#include <semaphore.h>

int main(){
    int *map;
    int shm_fd;
    const char *mem = "/mem";
    const char *sema = "/sema";
    sem_t *sem;

    shm_fd = shm_open(mem, O_RDWR, 0660);   // open shared memory object
    if(shm_fd == -1){
        perror("shm_open");
        return 1;
    }

    sem = sem_open(sema, O_RDWR);   // open named semaphore
    if(sem == SEM_FAILED){
        perror("sem_open");
        return 1;
    }

    map = mmap(0, sizeof(int), PROT_READ, MAP_SHARED, shm_fd, 0);  // map memory to shared memory object
    if(map == MAP_FAILED){
        perror("map");
        return 1;
    }

    if(munmap(map, 4) == -1){   // unmap memory
        perror("munmap");
        return 1;
    }

    if(shm_unlink(mem) == -1){  // unlink shared memory object
        perror("shm_unlink");
        return 1;
    }

    if(sem_close(sem) < 0){    // close named semaphore
        perror("sem_close");
        return 1;
    }

    if(sem_unlink(sema) < 0){   // unlink shared semaphore
        perror("sem_unlink");
        return 1;
    }
    return 0;
}
