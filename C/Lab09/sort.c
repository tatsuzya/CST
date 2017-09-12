#include  <stdio.h>
#include  <stdlib.h>
#include  <string.h>
#define NLINES 256
#define LINESIZE 128

int cmp(const void *a , const void *b)
{
    char const *aa = a;
    char const *bb = b;
    return strcmp(aa,bb);
}

int main(void)
{
    char line [NLINES][LINESIZE];
    size_t i = 0, n = 0;
    
    while (n < NLINES && fgets(line[n], LINESIZE, stdin )!=NULL)
    {
        n++;
        if (strchr(line[i++], '\n') == NULL)
        {
            while(fgetc(stdin) != '\n' );
            clearerr(stdin);
        }
    }

    qsort (line, n , sizeof(line[0]),cmp);
    
    for ( i = 0 ; i < n ; i++)
    {
        printf("line[%lu] = %s",i,line[i]);
    }
    return 0;
}