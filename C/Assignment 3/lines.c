#include <stdlib.h>
#include <string.h>
#include "lines.h"
#include "macro.h"

lines_t readlines(FILE *fp) 
{
	static lines_t lines = {NULL,0};
	static size_t nalloc = 0;

	char line[LINESIZE];
	char **tmp;
	while (fgets(line, LINESIZE, fp))
    {
		if (lines.nused == nalloc) 
        {
			if(nalloc == 0)
            {	
				nalloc = 1;
#ifdef DEBUG
				fprintf(stderr, "*");
#endif
			}else 
            { 
				nalloc *= 2;
#ifdef DEBUG
				fprintf(stderr, "*");
#endif
			}
			tmp = (char**)realloc(lines.data, nalloc * sizeof(char*));
			
			if(tmp == NULL){
				fprintf(stderr, "Realloc failed");
				break;
			}
#ifdef DEBUG
			/* Print in debug mode */
				fprintf(stderr, "\n*");
#endif
			lines.data = tmp;
		}
		/* Allocate memory to store the string */
		lines.data[lines.nused] = (char*)malloc((strlen(line) + 1) * sizeof(char));

		if (lines.data[lines.nused] == NULL){
			fprintf(stderr, "Malloc failed");
			break;
		}

#ifdef DEBUG
		/* Print the amount of memory allocated in debug mode*/
		fprintf(stderr, "%lu+", strlen(line) + 1);
#endif
		/* Copy string to memory and increment line*/
		strcpy(lines.data[lines.nused++], line);
	}
	return lines;
}

/* free memory */
void freemem(lines_t lines) {
	size_t i;
	if (lines.nused == 0)
		return;
	for (i = 0; i < lines.nused; i++)
    {
		free(lines.data[i]);
#ifdef DEBUG
		fprintf(stderr,"-");
#endif
	}
	free(lines.data);
#ifdef DEBUG
	fprintf(stderr,"-");
#endif
	lines.nused = 0;
}

/* reverse lines */
void revlines(lines_t lines){
	size_t i, j;
	char *tmp;

	for (i = 0, j = lines.nused - 1; i < j; i++, j--){
		tmp = lines.data[i];
		lines.data[i] = lines.data[j];
		lines.data[j] = tmp;
	}
}
