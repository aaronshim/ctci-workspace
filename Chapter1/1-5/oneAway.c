#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

bool oneAway(char str1[], char str2[])
{
	int len1 = strlen(str1);
	int len2 = strlen(str2);

	// easy first condition check
	if (len1 - len2 > 1 || len2 - len1 > 1)
	{
		return false;
	}

	//replacement check
	if (len1 == len2)
	{
		bool foundDifference = false;
		for (int i=0; i < len1; i++)
		{
			if (str1[i] != str2[i])
			{
				if (foundDifference)
				{
					return false;
				}
				else
				{
					foundDifference = true;
				}
			}
		}
	}
	else
	{
		//insertion and takeaway are symmetric processes:
		// find big and small, run algorithm accordingly
		char* bigStr;
		char* smallStr;
		int smallLen;
		if (len1 > len2)
		{
			smallLen = len2;
			bigStr = str1;
			smallStr = str2;
		}
		else
		{
			smallLen = len1;
			bigStr = str2;
			smallStr = str1;
		}

		//iterate with respect to the small so we don't go off the end
		// (the unchecked last character may be the insert)
		for (int i=0; i < smallLen; i++)
		{
			if (bigStr[i] != smallStr[i])
			{
				return strcmp(bigStr+(i+1)*sizeof(char),
					smallStr+i*sizeof(char)) == 0;
			}
		}
	}

	//final return
	return true;
}

int main(int argc, char* argv[])
{
	if (argc != 3)
	{
		fprintf(stderr, "You must supply exactly two strings to compare!\n");
		return EXIT_FAILURE;
	}

	printf("%s and %s %s one away!\n", argv[1], argv[2],
	 oneAway(argv[1], argv[2]) ? "are" : "are NOT");

	return EXIT_SUCCESS;
}