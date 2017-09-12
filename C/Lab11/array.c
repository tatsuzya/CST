#include <stdio.h>
#include <string.h>

int *arr_first_max(const int*a, size_t n);
int *arr_last_max(const int*a, size_t n); 
size_t str_replace_all(char *s, int oldc, int newc); 
char *str_find_last(const char *s, int c);

int main(void){
	int a[] = {1, 3, 4, 12, 8, 1, 12 };	
    char s[] = "aabbbccddee";
	int *first;
    int *last;
    int count;

	first = arr_first_max(a, 10);
	printf("arr_first_max:%d\n",*first);
	
	last = arr_last_max(a, 10);
	printf("arr_last_max:%d\n",*last);

    count = str_replace_all(s,'b','f');
    printf("%d\n",count);


	return 0;
}

int *arr_first_max(const int*a, size_t n){
	const int *max = a;
	const int *p;
	for (p=a; p<a+n; p++)
    {
		if (*p > *max)
        {
			max = p;
        }
    }
	return (int*)max ;
}

int *arr_last_max(const int*a, size_t n){
	const int *max = a;
	const int *p;
	for (p=a; p<a+n; p++)
    {
		if (*p >= *max)
        {
            max = p;
        }
    }
	return (int*)max;
}

size_t str_replace_all(char *s, int oldc, int newc){
	char* p;
	size_t n = 0;
	for (p=s; *p!='\0'; p++)
    {
		if (*p == oldc)
        {
			*p = newc;
			n++;
		}
    }
	return n;
}

char *str_find_last(const char *s, int c){
	const char *p;
	char* q = NULL;
	for (p = s; *p != '\0'; p++)
    {
		if (*p == c)
        {
			q = (char*)p;
        }
    }
	return q;
}