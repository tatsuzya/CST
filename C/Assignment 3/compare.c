#include <ctype.h>
#include <string.h>
#include "compare.h"


/* skip leading whitespaces */
static char* skipws(const char *s);
/* compare 2 strings */
static int stricmp(const char *s1, const char *s2);

/* case sensitive and leading white space*/
int cmpwssen(const void *p, const void *q)
{
	const char *pp = *(char* const *)p;
	const char *qq = *(char* const *)q;
	return strcmp(pp, qq);
}

/* case insensitive and leading white spaces */
int cmpwsinsen(const void *p, const void *q)
{
	const char *pp = *(char* const *)p;
	const char *qq = *(char* const *)q;
	return stricmp(pp, qq);
}

/* case sensitive and no leading white spaces */
int cmpnowssen(const void *p, const void *q)
{
	const char *pp = *(char* const *)p;
	const char *qq = *(char* const *)q;
	pp = skipws(pp);
	qq = skipws(qq);
	return strcmp(pp, qq);
} 

/* case insensitive and no leading white spaces*/
int cmpnowsinsen(const void *p, const void *q)
{
	const char *pp = *(char* const *)p;
	const char *qq = *(char* const *)q;
	pp = skipws(pp);
	qq = skipws(qq);
	return stricmp(pp, qq);
}

/* skip whitespace*/
static char* skipws(const char *s)
{
	const char *p;
	for (p = s; *p != '\n'; p++)
    {
		if (!isspace(*p))
			break;
    }
	return (char*) p;
}

/* case insensitive */
static int stricmp(const char *s1, const char *s2)
{
	const char *p = s1;
	const char *q = s2;
	for (; *p != '\0' && *q != '\0'; p++, q++)
    {
		if (tolower(*p) != tolower(*q))
			break;
    }
	return tolower(*p) - tolower(*q);
}
