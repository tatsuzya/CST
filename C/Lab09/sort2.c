#include  <stdio.h>
#include  <stdlib.h>
#include  <string.h>
#define NLINES 256
#define LINESIZE 128

int cmp(const void *a , const void *b)
{
    char * const *aa = a;
    char * const *bb = b;
    return strcmp(*aa,*bb);
}

int main(void)
{
    char line [NLINES][LINESIZE];
    char *a[NLINES];
    size_t i = 0, n = 0;
   
    for( i = 0 ; i < NLINES ; i++)
    {
        if(!fgets(line[i],LINESIZE,stdin))
        {
            clearerr(stdin);
            break;
        }

        a[i] = line[i];

        if(!strchr(line[i],'\n'))
        {
            while(fgetc(stdin)!='\n');
        }
    }
  
    qsort (a, i , sizeof(a[0]),cmp);
    
    for ( n = 0 ; n < i  ; n++)
    {
        printf("line[%lu] = %s",n,a[n]);
    }
    return 0;
}