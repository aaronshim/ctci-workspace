#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <math.h>

//return a new string that is the shorter or either run-length
// compression or the original string
char* stringCompression(char* str)
{
	//double loop running method is easiest
	int len = strlen(str);
	char* newstr = malloc((len+1)*sizeof(char));
	int newstr_loc = 0;
	for (int i=0; i < len; i++)
	{
		int count = 1;
		for (int j=i+1; j < len; j++)
		{
			if (str[j] == str[i])
			{
				count++;
			}
		}
		i+=(count-1); //move first pointer

		//now this is the most tricky part with string addition magic
		int num_digits = (int)log10((double)count);
		if (newstr_loc + num_digits + 1 >= len)
		{
			//if compression ends up bigger, send old string
			strcpy(newstr,str);
			return newstr;
		}
		else
		{
			char count_str[num_digits + 1];
			sprintf(count_str, "%d", count);
			newstr[newstr_loc] = str[i];
			strcpy(newstr+(newstr_loc+1)*sizeof(char),count_str);
			newstr_loc+=(1+strlen(count_str));
		}
	}
	return newstr;
}

int main(int argc, char* argv[])
{
	if (argc > 1)
	{
		for (int i=1; i < argc; i++)
		{
			char *output = stringCompression(argv[i]);
			printf("%s -> %s\n", argv[i], output);
			free(output);
		}
	}
	return EXIT_SUCCESS;
}