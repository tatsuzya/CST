#include  <stdio.h>

int main(void){
    int c; /* c for characters */
    int line = 1; /* line for newlines */
    
    /* the program will execute until EOF is reached */
    while((c=getchar())!= EOF)                
    {	
        /* check for space and tabs */
        if(c == ' ' || c =='\t')    
        {
            /* replace tabs and spaces with single space */
            while((c = getchar() ) == ' '|| c=='\t');  
            putchar('c'); 
        }  
        
        /* check for newlines */ 
        if(c =='\n')
        {
            line++;
            if(line < 3) /* one \n for end of the line and one \n for start of the line */
            {
               putchar(c);
               printf("a");
            }
        }else
        {
            putchar(c);
            line = 0;
        }   
    }
    return 0;
}