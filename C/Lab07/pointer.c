#include  <stdio.h>
#include  <string.h>
#define LINESIZE 1024

void min_max(const int a[],size_t n, int *pmin, int *pmax);
void first_last(const int a[],size_t t, int x, size_t *pfirst,size_t *plast);
void str_reverse(char s[]);
unsigned long num_reverse(unsigned long n);

int main(void)
{
    const int a[] = {3,2,5,10,1,8,3,9,5};
    char s[] = "hello world";
    long n = 5432109876;
    
    int min, max,*pmin,*pmax;
    size_t first, last, *pfirst, *plast;

    pmin = &min;
    pmax = &max;
    pfirst = &first;
    plast = &last;
   
    min_max(a,10, pmin, pmax);
    printf("Min: %d\nMax: %d\n", min, max);
    
    first_last(a,LINESIZE,5,pfirst,plast);
    printf("First index: %lu\nLast index: %lu \n",first,last);
    
    str_reverse(s);
    printf("Reversed: %s\n",s);
    
    printf("Reversed: %lu\n", num_reverse(n));
    return 0;
}

void min_max(const int a[],size_t n, int *pmin, int *pmax)
{
    int min = a[0],max = a[0];
	size_t i;

    for(i = 0; i < n; i++)
    {
        if(a[i] > max)
		{
            max = a[i];
            *pmax = max;
		}
		
		if(a[i] < min)
		{
			min = a[i];
            *pmin = min;
		}
	}

    return;
}

void first_last(const int a[],size_t t, int x, size_t *pfirst,size_t *plast)
{
    size_t i;

    for(i = t; i > 0; i--)
    {
        if(a[i-1] == x)
        {
            *pfirst = i;
        }
    }
    for(i = 0; i < t; i++)
    {
        if(a[i] == x)
        {
            *plast = i;
        }
    }
    return;
}
void str_reverse(char s[])
{
    int len = strlen(s);
    size_t i,j,tmp;
    
    for(i = 0, j = len; i < j ; i++,j--)
    {
        tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
    return;
}

unsigned long num_reverse(unsigned long n)
{
    long reverse = 0;
    
    while(n!=0)
    {
        reverse = reverse * 10;
        reverse = reverse + n % 10;
        n = n/10;
    }
    return reverse;
}

