#include <stdio.h>

#define LINESIZE 1024

int menu(const char *choices[], const char *prompt);

int main(void) {

    const char *choices[] = {"Enter Data", "Display Data", "Quit",0};
    char prompt[] = "Please select a option >";                            
 
    menu(choices,prompt);
    
    return 0;
}

int menu(const char *choices[], const char *prompt) {

    size_t i;
    int choice = 1;
    char line[LINESIZE];
    int max = 0;
		
    for (i=0; choices[i] != 0; i++)
    {
        max++;
    }
		    
    while(1){
   	for (i=0; choices[i] != 0; i++)
    	{
 	    printf("%d. %s \n", (int)i+1, choices[i]);
	}

	printf("%s \n", prompt);

    	if (!fgets(line, LINESIZE, stdin))
    	{
            clearerr(stdin);
            return 0;
    	}
    
    	if(sscanf(line,"%d",&choice)==1)
    	{
            if(choice > 0 && choice <= max)
	    {
	        printf("\nOption %d is selected\n\n",choice);
		break;
	    }
	    else
	    {
	        printf("\nPlease reenter\n\n");
	    }
	}
    }
    return choice;
 } 
