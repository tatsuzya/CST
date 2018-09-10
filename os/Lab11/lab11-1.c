#define _GNU_SOURCE
#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <sys/mman.h>
#include <sys/stat.h>
#include <sys/shm.h>
#include <fcntl.h>
#define BUFSIZE 1024

int main(){
    char *name = "/test";
    char buffer[BUFSIZE];
    int size = 101;
    int num;
    int *map;
    int shm_fd;
    int i = 1;

    shm_fd = shm_open(name , O_CREAT | O_RDWR, 0660);   // create a shared memory object with read & write perimission
    if(shm_fd == -1){   // error checking
        perror("shm_open");
        return 1;
    }

    ftruncate(shm_fd, size);  // set the size of the shared memory object

    map = mmap(0, size, PROT_WRITE, MAP_SHARED, shm_fd, 0);   // map to shared memory object
    if(map == MAP_FAILED){    // error checking
        perror("mmap");
        return 1;
    }

    printf("please enter integers up to 100 integers\n");

    while(i < size && (fgets(buffer, BUFSIZE, stdin)) != NULL){   //store string into map
        sscanf(buffer, "%d", &num);
        map[i++] = num;
    }

    printf("total of %d integer has been entered\n", i-1);

    map[0] = i - 1;  //set the first index as counter

    return 0;
}
