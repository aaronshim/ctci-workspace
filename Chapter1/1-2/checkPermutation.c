#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <stdbool.h>

// super simple comparison for our string sorting
int compare (const void * a, const void * b)
{
	//make sure the cast from void* here is to char
	// otherwise this compare will not behave as expected!
	// (chars will do subtraction just fine)
	return ( *(char*)a - *(char*)b );
}

bool isPermutation(char str1[], char str2[])
{
	if (strlen(str1) != strlen(str2))
	{
		return false;
	}

	//let's make sure we don't destroy the copies we are handed
	int len = (int)strlen(str1);
	//remember the extra space for the null terminator
	char* str1_copy = malloc((len+1)*sizeof(char));
	char* str2_copy = malloc((len+1)*sizeof(char));
	strcpy(str1_copy,str1);
	strcpy(str2_copy, str2);

	qsort(str1_copy, len, sizeof(char), compare);
	qsort(str2_copy, len, sizeof(char), compare);

	bool answer = (strcmp(str1_copy,str2_copy) == 0);

	free(str1_copy);
	free(str2_copy);

	return answer;
}

int main(int argc, char* argv[])
{
	if (argc != 3)
	{
		fprintf(stderr, "You must provide exactly two strings!\n");
		return EXIT_FAILURE;
	}

	printf("%s and %s %s permutations!\n", argv[1], argv[2],
	 isPermutation(argv[1], argv[2]) ? "are" : "are NOT");
	return EXIT_SUCCESS;
}