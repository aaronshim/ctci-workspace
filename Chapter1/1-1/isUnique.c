#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <stdbool.h>

bool isUnique(char str[])
{
	//one of the most brilliant ideas was that instead of a dictionary
	// histogram we would use in any of the other languages, we can avoid that
	// implementation by just using an array, assuming ASCII
	int histogram[128];
	for (int i=0; i < 128; i++)
		histogram[i]=0;

	int length = (int)strlen(str);
	for (int i=0; i < length; i++)
	{
		if (histogram[(int)str[i]] != 0)
		{
			//we found a repeated letter
			return false;
		}
		else
		{
			//count and move on
			histogram[(int)str[i]]+=1;
		}
	}
	//if no false was triggered, must be true
	return true;
}

int main(int argc, char* argv[])
{
	if (argc > 1)
	{
		for (int i=1; i < argc; i++)
		{
			printf("argument: %s IsUnique? %s\n",
			 argv[i], isUnique(argv[i]) ? "Yes" : "No");
		}
	}

	return EXIT_SUCCESS;
}

//const char* x is the same thing as char x[]? No.