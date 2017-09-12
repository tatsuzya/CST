#include<stdio.h>
#define CHECK(EXPR) printf("%s...%s\n",(EXPR)?"passed" : "FAILED", #EXPR)
int array_max(const int a[],size_t n);
size_t array_index_of_first_max(const int a[], size_t n);
size_t array_index_of_last_max(const int a[], size_t n);
int array_equal(const int a[], const int b[], size_t n);



int main(void){
	int a[] = {1,2,3,7,5,6,7};
	int b[] = {9,10,23,12,23,5,4};
	int c[] = {30,30,12,5,20,24,13};
	CHECK(array_max(a,7)==7);
	CHECK(array_max(b,7)==23);
	CHECK(array_max(c,7)==30);
	CHECK(array_index_of_first_max(a,7)==3);
	CHECK(array_index_of_first_max(b,7)==2);
	CHECK(array_index_of_first_max(c,7)==0);
	CHECK(array_index_of_last_max(a,7)==6);
	CHECK(array_index_of_last_max(b,7)==4);
	CHECK(array_index_of_last_max(c,7)==1);
	CHECK(array_equal(a,b,7)== 0);
	CHECK(array_equal(a,c,7)== 0);
	
	CHECK(array_equal(b,c,7)== 0);
	return 0;
}


int array_max(const int a[],size_t n)
{
	int max = a[0];
	size_t i;
	for( i = 0 ; i < n ; i++)
	{
		if( a[i] > max )
		{
		    max = a[i];
		}
	}
	return max;
}


size_t array_index_of_first_max(const int a[], size_t n)
{
	int max = a[0];
	size_t i;
	size_t first_max_index = 0;
	
	for(i = 0; i < n; i++)
	{
		if(a[i] > max)
		{
			max = a[i];
			first_max_index = i;
		}
	}
	return first_max_index;
}


size_t array_index_of_last_max(const int a[], size_t n)
{
	int max = a[0];
	size_t i;
	size_t last_max_index = 0;
 
	for(i = 0; i < n; i++)
	{
		if(a[i] >= max)
		{
			max = a[i];
			last_max_index = i;
		}
	}
	return last_max_index;
}


int array_equal(const int a[], const int b[], size_t n)
{
	size_t i;
	for(i = 0; i < n; i++)
	{
		if(a[i] != b[i])
		{
		return 0;
	    }
	}
	return 1;
}

