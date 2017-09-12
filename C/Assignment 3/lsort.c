#include <stdlib.h>
#include <string.h>
#include "macro.h"
#include "lines.h"
#include "compare.h"

static int switches(int argc, char **argv, unsigned *options); 

void help()
{
    fprintf(stderr,"Usage: [OPTION]... [FILE]...\n");
    fprintf(stderr,"  -c  ignore case\n");
    fprintf(stderr,"  -w  ignore leading white space\n");
    fprintf(stderr,"  -r  sort in reverse order\n");
    fprintf(stderr,"  --  mark the end of options\n");
    fprintf(stderr,"With no FILE, read standard input.\n");
}

int main(int argc, char *argv[]) {
	
	/* file index */
	int file;
	unsigned options = 0;

	lines_t lines; FILE* fp;

	int (*compare[4])(const void *p1, const void *p2) = {
		cmpwssen,
		cmpwsinsen,  		
		cmpnowssen,
		cmpnowsinsen		
	};

	/* help function*/
	if(!(file = switches(argc, argv, &options))){
		help();
		return 0; 
	}

#ifdef DEBUG
	/* Print the options information in debug mode */
	fprintf(stderr, "\n-c: %s", (options & ignorecase)? "on":"off");
	fprintf(stderr, "\n-w: %s", (options & ignorews)? "on":"off");
	fprintf(stderr, "\n-r: %s", (options & reverse)? "on":"off");
#endif
	
	/* Read from stdin if no file specified */
	if (file == argc)
    {
		lines = readlines(stdin);
    }else
    {
		/* read from the specified files */
		for (; file<argc; file++)
        {
			if (!(fp = fopen(argv[file],"r")))
            {
				perror("\nfopen");
				continue;
			}
#ifdef DEBUG
			/* Print openning file infomaition in debug mode */
			fprintf(stderr, "\n@%s", argv[file]);
#endif
			lines = readlines(fp);

			if (fclose(fp) != 0)
            {
				perror("fclose");
			}

#ifdef DEBUG
			/* Print closing file infomaition in debug mode */
			fprintf(stderr, "\n#%s", argv[file]);
#endif
		}
    }
	if (lines.nused > 0){
		size_t i;

		unsigned index = options & (ignorecase | ignorews);

		/* qsort with comparing function */
		qsort(lines.data,lines.nused,sizeof(char*),	compare[index]);

		/* reverse */	
		if (options & reverse)
			revlines(lines);
		
		/* Print out sorting  */
		for (i = 0; i < lines.nused; i++)
			fprintf(stdout, "%s", lines.data[i]);
	}

	/* Free memory */	
	if (lines.nused >0)
        freemem(lines);

	return 0;
}
 static int switches(int argc, char **argv, unsigned *options) {
	int i;
	for (i = 1; i < argc; i++){
		/* exit if encounted */
		if(argv[i][0] != '-')
        {
			break;
		}

		if(argv[i][1] == '-'){
			i++;
			break;
		}

        /* compare switches */
		if (strcmp(argv[i], "-c") == 0){
			*options |= ignorecase; 
			continue;
		}
		
		if (strcmp(argv[i], "-w") == 0){
			*options |= ignorews; 
			continue;
		}

		if (strcmp(argv[i], "-r") == 0){
			*options |= reverse; 
			continue;
		}

        /* failed if no switches matches */
		fprintf(stderr, "Invalid arguments.\n");
		return 0;
	}
	return i;
}

