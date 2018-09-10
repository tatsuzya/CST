typedef struct{
  pthread_mutex_t m;
  pthread_cond_t cv;
  int count;
}barrier;

void barrier_int(barrier *b, int value){
  pthread_mutex_int(&b -> m, 0);
  pthread_cond_init(&b -> cv, 0);
  b -> count = value;
}

void barrier_wait(barrier *b){
  pthread_mutex_lock(&b -> m);
  b -> count--;
  if(b -> count == 0){
    pthread_cond_broadcast(&b -> cv); // wake up all the thread
  }else{
    while(b -> count > 0){
      pthread_cond_wait(&b -> cv, &b -> m);
    }
  }
  pthread_mutex_unlock(&b -> m);
}
