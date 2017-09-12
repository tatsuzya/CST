#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>

#define LINESIZE 128 
typedef struct node node;
typedef node* list;

typedef struct  {
	char id[10];
	int score;
}record;

struct node {
	record data;
	node* next;
};

void list_init(list *lstp);
void list_destory(list *lstp);
int list_insert(list *lstp, const record *recp);
void list_print(list lst);


int input_record(record* recp);

static int valid_id(char *id);
static int valid_score(int score);

int main(void){
	list head;
	record r;

	list_init(&head);

	while (input_record(&r))
		if (!list_insert(&head, &r))
			break;
	list_print(head);
	list_destory(&head);
	return 0;
}

void list_init(list *lstp){
	*lstp = NULL;
}

int list_insert(list* lstp,const record* recp){
	list newnode;
	list *tracer;

	newnode = (list)malloc(sizeof(node));

    if(newnode == 0 )
    {
        return 0;
    }
	strcpy(newnode->data.id, recp->id);
	newnode->data.score = recp->score;

	for (tracer = lstp; *tracer!= 0 ; tracer = &(*tracer)->next)
		if (strcmp(recp->id, (*tracer)->data.id) < 0)
			break;
	newnode->next = *tracer;
	*tracer = newnode;
	return 1;
}

void list_print(list lst){
	const node* p;
	for ( p = lst; p != NULL; p = p->next)
		fprintf(stdout, "\n%s %d", p->data.id, p->data.score);
}

void list_destory(list *lstp){
	node*p, *q;
	for (p = *lstp; p != NULL; p = q) {
		q = p->next;
		free(p);
	}
	*lstp = NULL;
}

int input_record(record *recp){
	char line[LINESIZE];
	char id[10];
	int score;
	int validinput = 0;

	while (!validinput){
		printf("Please enter student ID ");
		if (!fgets(line, LINESIZE, stdin))
			return 0;
		if (line[0] == '\n')
			return 0;
		strncpy(id, line, 10-1);
		id[10-1] = '\0';

		validinput = valid_id(id);
		if (!validinput)
			printf("Invalid ID, try again.\n");
	}

	validinput = 0;

	while (!validinput){
		printf("Please enter score ");
		if (!fgets(line, LINESIZE, stdin))
			return 0;
		if (line[0] == '\n')
			return 0;
		if (sscanf(line, "%d", &score) != 1)
			return 0;

		validinput = valid_score(score);

		if (!validinput)
			printf("Invalid score, try again.\n");
	}
	strcpy(recp->id, id);
	recp->score = score;
	return 1;
}

static int valid_id(char *id){
	size_t i;
	
	if (strlen(id) != 10 - 1)
		return 0;
	if (tolower(id[0]) != 'a')
		return 0;
	for (i = 1; i < strlen(id); i++)
		if (!isdigit(id[i]))
			return 0;
	return 1;
}
static int valid_score(int score){
	return score >= 0 && score <= 100;
}