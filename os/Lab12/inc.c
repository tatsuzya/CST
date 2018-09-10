#define _GNU_SOURCE
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/shm.h>
#include <sys/stat.h>
#include <sys/mman.h>
#include <semaphore.h>
#define NITEMS 10

int main(){
    int *map;
    const char *mem = "/mem";
    const char *sema = "/sema";
    sem_t *sem;
    int shm_fd;

    shm_fd = shm_open(mem, O_RDWR, 0660);   // create shared memory object with read & write permission
    if(shm_fd == -1){   // error checking
        perror("shm_open");
        return 1;
    }

    sem = sem_open(sema, 0, 0660, 0);   // open named semaphore
    if(sem == SEM_FAILED){    // error checking
        perror("sem_open");
        return 1;
    }

    map = mmap(0, sizeof(int), PROT_READ | PROT_WRITE, MAP_SHARED, shm_fd , 0);
    if(map == MAP_FAILED){
        perror("mmap");
        return 1;
    }

    for(int i = 0; i < NITEMS; i++){  // mutual exclusion
        sem_wait(sem);
        printf("%d\n", map[0]);
        map[0] = map[0] + 1;
        sem_post(sem);
    }

    return 0;

}
