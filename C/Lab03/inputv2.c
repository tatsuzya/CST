#include  <stdio.h>

int main(void){
    int c; /* c for characters */
    int line = 1; /* line for newlines */
    int space = 0;
    
    /* the program will execute until EOF is reached */
    while((c=getchar())!= EOF)                
    {
        /* check for space and tabs */
        if(c == ' ' || c =='\t')    
        {
            space++;
            if(space < 2)
            {
                putchar(' ');
            }
        }  
        
        /* check for newlines */ 
        else if(c =='\n')
        {
            line++;
            if(line < 3) /* one \n for end of the line and one \n for start of the line */
            {
               putchar(c);
            }
        }
        
        else
        {
            putchar(c);
            line = 0;
            space = 0;
        }   
    }
    return 0;
}