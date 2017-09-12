#include  <stdio.h>
#include  <string.h>
#define LINESIZE 1024
int is_permutation(unsigned long n1,unsigned long n2);
int is_permutation(unsigned long n3,unsigned long n4);
int is_staggering(unsigned long n);

int main(void)
{
	size_t i;
	int count = 0;
	long n1 = 73140526;
	long n2 = 45263017;
	long n3 = 12345678;
	long n4 = 87654321;
	if(is_permutation(n1,n2)==1)
	{
		printf("%lu and %lu is a permutation\n",n1,n2);
	}else{
		printf("%lu and %lu is not a permutaiton\n",n1,n2);
	}

	if(is_permutatino(n3,n4)==1)
	{
		printf("%lu and %lu is a permutation\n",n3,n4);
	}else{
		printf("%lu and %lu is not a permutaiton\n",n3,n4);
	}


	for(i = 100 ; i <=1000000000; i ++)
	{
		if(is_staggering(i)==0)
		count++;
	}

	printf("There is %d non-staggering number\n",count);
	return 0;
}

/*	check for permutation 
	return 1 if true
	return 0 if false	   */

	
int is_permutation(unsigned long n1, unsigned long n2)
{
	int count[10];
	size_t i;

	/* compare 2 unsinged long */
	for ( i = 0 ; i < 10 ; i++)
	{
		count[i] = 0;
	}

	while (n1 != 0)
	{
		count[n1 % 10]++;
		n1 /= 10;
	}

	while (n2 != 0)
	{
		count[n2 % 10]--;
		n2 /= 10;
	}

	for (i = 0 ; i < 10 ; i++)
	{
		if(count[i]!=0)
		{
			return 0;
		}
	}
	return 1;
}
int is_pemutation(unsigned long n3,unsigned long n4)
{
	size_t i,j,len;
	char num1[10],num2[10];
	char tmp;
	sprintf(num1,"%lu",n3);
	sprintf(num2,"%lu",n4);
	len = strlen(num1);

	/** compare 2 string array **/
	for(i = 0; i < len-1 ; i++)
	{
		for (j = i + 1; j < len; j++)
		{
			if(num1[i]>num1[j])
			{
				tmp = num1[i];
				num1[i] = num1[j];
				num1[j] = tmp;
			}
			if(num2[i]>num2[j])
			{
				tmp = num2[i];
				num2[i] = num2[j];
				num2[j] = tmp;
			}
		}
	}
	
	for (i = 0 ; i < len ; i++)
	{
		if(num1[i]!=num2[i])
		{
			return 0;
		}
	}
	
	return 1;
}

int is_staggering(unsigned long n)
{
	
	int countd = 0,counti = 0,next = 0,j; 
	char num[LINESIZE];
	size_t i,len = strlen(num);
	sprintf(num,"%lu",n);

	for(i = 0 ; i < len ; i++)
	{
		if(num[i] >= next )
		{
			next = num[i];
			counti++;
		}
	}

	next = 0 ;

	for(j = len; j >=0 ; j --)
	{
		if(num[j-1] >= next)
		{
			next = num[j-1];
			countd++;
		}
	}

	if(countd == (int)len || counti == (int)len)
	{
		return 0;
	}else
	{
		return 1;
	}
	
	return 0;
}