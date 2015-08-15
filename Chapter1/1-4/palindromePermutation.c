#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <ctype.h>

bool palindromePermutation(char str[])
{
	//histogram makes this much easier again
	int histogram[128];
	for (int i=0; i < 128; i++)
	{
		histogram[i] = 0;
	}

	//mark histogram
	int len = strlen(str);
	for (int i=0; i < len; i++)
	{
		if (isalpha(str[i]))
		{
			histogram[(int)tolower(str[i])]++;
		}
	}

	//make sure everything is in pairs other than one singleton
	bool sawOdd = false;
	for (int i=0; i < 128; i++)
	{
		if (histogram[i]%2 != 0)
		{
			if (!sawOdd)
			{
				sawOdd = true;
			}
			else
			{
				return false;
			}
		}
	}
	return true;
}

int main(int argc, char* argv[])
{
	//run for each one of argument inputs
	if (argc > 1)
	{
		for (int i=1; i < argc; i++)
		{
			printf("%s %s a palindrome permutation!\n", argv[i],
				palindromePermutation(argv[i]) ? "is" : "is NOT");
		}
	}

	return EXIT_SUCCESS;	
}