#include <pthread.h>

//pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;
int n = 0;

// increment variable and print out answer
void *inc(void *arg){
  while(1){
    //pthread_mutex_lock(&mutex);
    printf("%d\n", ++n);
    //pthread_mutex_unlock(&mutex);
  }
}

int main(void){
  pthread_t tid1, tid2;

  pthread_create(&tid1, 0, inc, 0);
  pthread_create(&tid2, 0, inc, 0);

  pthread_exit(0);
}
