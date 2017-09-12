#include  <stdio.h>
#define LINESIZE 1024

int get_last_first(FILE *fp);
int get_first_last(FILE *fp);


int main(void)
{
    get_last_first(stdin);
    get_first_last(stdin);
    return 0;
}

int get_last_first(FILE*fp)
{
    char last[LINESIZE];
    char first[LINESIZE];
    char line[LINESIZE];

    printf("Please enter a last name , first name : ");
    
    if(!fgets(line, LINESIZE ,fp))
    {
        clearerr(stdin);
        return 0;
    }
    
    if(sscanf(line," %[a-zA-Z-] , %[a-zA-Z-] ", last, first) == 2)
    {
        printf("%s %s \n" , first, last);
		return 1;
    }
    return -1;
}

int get_first_last(FILE*fp)
{
    char last[LINESIZE];
    char first[LINESIZE];
    char line[LINESIZE];

    printf("Please enter a first name , last name : ");
    
    if(!fgets(line, LINESIZE ,fp))
    {
        clearerr(stdin);
        return 0;
    }
    
    if(sscanf(line," %[a-zA-Z-] %[a-zA-Z-] ", first, last) == 2)
    {
        printf("%s %s \n" , first, last);
		return 1;
    }
    return -1;
}