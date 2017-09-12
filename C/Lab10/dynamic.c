#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define LINESIZE 256
#define BLOCK 10

typedef struct {
	char **data;	/* dynamic array of lines */
	size_t nused;	/* number of lines in the dynamic array */
} lines_t;

lines_t readlines(FILE *fp);

int main(int argc, char* argv[]) {
	FILE *fp;
	lines_t lines;
	size_t i;
		
	if (argc == 2) {
		if( (fp = fopen(argv[1], "r")) == 0) {
			perror("fopen");
			return 1;
		}

		lines = readlines(fp);

		if (fclose(fp) != 0) {
			perror("fclose");
			return 2;
		}
	}

	if (argc == 1)
		lines = readlines(stdin);
	
	if (lines.nused > 0)
		for (i = 0; i < lines.nused; i++)
			fprintf(stdout, "%s", lines.data[i]);

    for (i = 0; i < lines.nused; i++)
    {
			free(lines.data[i]);
    }
    free(lines.data);
	
    return 0;
}

lines_t readlines(FILE *fp) 
{
	lines_t lines = {NULL,0};
	char buffer[LINESIZE];
	size_t nalloc = 0;
	char **temp;
	while (fgets(buffer, LINESIZE, fp))
    {
		if (lines.nused == nalloc) {
			if(nalloc == 0){	
				nalloc = 1;
#ifdef DEBUG
				fprintf(stderr, "*");
#endif
			}
			else { 
				nalloc *= 2;
#ifdef DEBUG
				fprintf(stderr, "*");
#endif
			}
			temp = (char**)realloc(lines.data, nalloc * sizeof(char*));
			if(temp == NULL){
				fprintf(stderr, "realloc failed");
				break;
			}
			lines.data = temp;
		}
		lines.data[lines.nused] = (char*)malloc((strlen(buffer) + 1) * sizeof(char));

		if (lines.data[lines.nused] == NULL){
			fprintf(stderr, "malloc failed");
			break;
		}

#ifdef DEBUG
		fprintf(stderr, "%lu",'+', strlen(buffer) + 1);
#endif
		strcpy(lines.data[lines.nused++], buffer);
	}
	return lines;
}

