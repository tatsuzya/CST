#ifndef COMPARE_H
#define COMPARE_H

 
/* Case sensitive with leading white space*/
int cmpwssen(const void *p, const void *q);

/* Case insensitive with leading white space*/
int cmpwsinsen(const void *p, const void *q);

/* Case sensitive and no leading white space*/
int cmpnowssen(const void *p, const void *q); 

/* Case insensitive and no leading white space*/
int cmpnowsinsen(const void *p, const void *q); 

#endif