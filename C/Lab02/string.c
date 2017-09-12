#include <stdio.h>
#include <string.h>
#include <ctype.h>
#define CHECK(EXPR) printf("%s...%s\n", (EXPR) ? "passed": "Failed",#EXPR)
int str_all_digits(const char s[]);
int str_has_digit(const char s[]);
size_t str_replace_all(char s[], int oldc, int newc);
int str_replace_first(char s[], int oldc, int newc);
int str_replace_last(char s[], int oldc, int newc);

int main(void)
{
    char s[] ="dbfcee";
    char x[] ="112344";
    char w[] ="43cbb5";
    
    CHECK(str_all_digits(s)==0);
    CHECK(str_all_digits(x)==1);
    CHECK(str_all_digits(w)==0);
    CHECK(str_has_digit(s)==0);
    CHECK(str_has_digit(x)==1);
    CHECK(str_has_digit(w)==1);
    CHECK(str_replace_all(s,'e','b')==2);
    CHECK(str_replace_all(x,'1','5')==2);
    CHECK(str_replace_all(w,'b','d')==2);
    CHECK(str_replace_first(s,'b','r')==1);
    CHECK(str_replace_first(x,'5','7')==1);
    CHECK(str_replace_first(w,'d','h')==1);
    CHECK(str_replace_last(s,'b','r')==1);
    CHECK(str_replace_last(x,'5','7')==1);
    CHECK(str_replace_last(w,'d','h')==1);
    return 0 ;
}

int str_all_digits(const char s[])
{
	size_t i;
    
	for( i = 0; s[i] != '\0'; i++)
        if (!isdigit(s[i]))
            return 0;
    	return 1;
}

int str_has_digit(const char s[])
{
    size_t i;
    
    for ( i = 0 ; s[i] != '\0'; i++)
        if(isdigit(s[i]))
            return 1;
    return 0;
}

size_t str_replace_all(char s[], int oldc, int newc)
{
    size_t i;
    
    size_t count = 0;
    for ( i = 0; s[i] != '\0' ; i++)
        if(s[i] == oldc)
        {
            s[i] = newc;
            count++;
        }
    return count;
}

int str_replace_first(char s[], int oldc, int newc)
{
	size_t i = 0;
    	int count = 0;
	for(i = 0; s[i] != '\0'; i++)
   	{
		if(s[i] == oldc)
        {
	count++;
            if(count==1)
            {
                s[i] = newc;
                return 1;
            }
        }
    }
	return 0;
}

int str_replace_last(char s[], int oldc, int newc)
{
	size_t i = 0;
	int index = -1;
	for(i = 0; s[i] != '\0'; i++)
   	{
			
        	if(s[i] == oldc)
        	{
            	index = i;
		}
	}
	if(index != -1)
    	{
		s[index] = newc;
		return 1;
	}
	return 0;
}
