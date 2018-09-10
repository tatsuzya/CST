#include <phread.h>
#include <stdio.h>

void *square(void *arg){
  long x = (long) arg;
  return (void*)(x*x);
}

int main(void){

  phread_t tid;
  void *result;

  phtread_create(&tid, 0, square, (void*) 3);

  pthread_join(tid, &result);

  printf("%d\n",(long)result);

  return 0;
}
