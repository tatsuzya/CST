#include <stdio.h>

#define LINESIZE 1024

int menu(const char *choices[], const char *prompt);
int get_int(const char prompt[], int eof);
int get_valid_int(const char prompt[],int eof,int min, int max);

int main(void) 
{
    const char *choices[] = {"Enter Data", "Display Data", "Quit",0};                            
  
    menu(choices,">");
    
    return 0;
}

int menu(const char *choices[], const char *prompt) {

    size_t i;
    int valid;

    for (i= 0; choices[i] != 0; i++)
    {
        printf("%d. %s \n", (int)i+1, choices[i]);
    }
	
    while(1)
    {  
        valid = get_valid_int(prompt,0,1,i);
		break;
    }
    return valid;
 } 

int get_int(const char prompt[], int eof)
{
    int input;
    char c[LINESIZE];
    char line[LINESIZE];
    char d;
   
    fprintf(stdout,"%s",prompt);

    while(1)
    {
	    
        if(!fgets(line, LINESIZE, stdin))
        {
            clearerr(stdin);
            return eof;
        }
        if(sscanf(line,"%s",c) == 1)
        {
            if(sscanf(c,"%d%c",&input,&d) ==1)
            { 
                break;
            }
        }
    }    
    return input;
}

int get_valid_int(const char prompt[], int eof, int min, int max)
{ 
 
    while(1)
    {    
	    int valid = get_int(prompt,eof);   

	    if(valid == eof)
        {
            clearerr(stdin);
            return eof;
        }

	    if(valid >= min && valid <= max)
        {
            return valid;
        }        
    }
    return 0 ;
}

