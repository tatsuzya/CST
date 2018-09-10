#include <phread.h>
#include <stdio.h>

struct arg{
  int x, y;
  int result;
};

void *product(void *arg){
  struct arg *x = arg;
  x -> result = x -> x * x -> y;
  return 0;
}

int main(void){

  phread_t tid;
  struct arg arg = { 2, 3, 0};

  phtread_create(&tid, 0, product, (void*) &arg);

  pthread_join(tid, 0); // not interested in returned value

  printf("%d\n",arg.result);

  return 0;
}
