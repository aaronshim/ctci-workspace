#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

//Is s2 a rotation of s1?
// (this one is super simple if we know the trick)
bool stringRotation(char s1[], char s2[])
{
	int len1 = strlen(s1);

	//sanity check
	if (len1 != strlen(s2))
	{
		return false;
	}

	char* twos1 = malloc((2*len1+1)*sizeof(char));
	memcpy(twos1,s1,len1*sizeof(char));
	//for null terminator
	memcpy(twos1+len1*sizeof(char),s1,(len1+1)*sizeof(char));
	
	bool result = strstr(twos1,s2) != NULL;
	free(twos1);
	return result;
}

int main(int argc, char* argv[])
{
	if (argc != 3)
	{
		fprintf(stderr, "You must supply exactly two strings to evaluate!\n");
		return EXIT_FAILURE;
	}

	printf("%s %s a rotation of %s\n", argv[2],
	 stringRotation(argv[1], argv[2]) ? "is" : "is NOT",
	  argv[1]);

	return EXIT_SUCCESS;
}
