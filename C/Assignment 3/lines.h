#ifndef LINES_H
#define LINES_H

#include <stdio.h> 

typedef struct {
	char **data;	/* dynamic array of lines */
	size_t nused;	/* number of lines in the dynamic array */
} lines_t;

lines_t readlines(FILE *fp);
void freemem(lines_t lines); 
void revlines(lines_t lines);

#endif