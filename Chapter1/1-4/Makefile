CC=gcc
CFLAGS= -g -pedantic -std=c99 -Wall
DEPS = 
OBJ = palindromePermutation.o
PROGRAMS = PalindromePermutation

all : $(PROGRAMS)

%.o: %.c $(DEPS)
	$(CC) -c -o $@ $< $(CFLAGS)

PalindromePermutation: $(OBJ)
	$(CC) -o $@ $^ $(CFLAGS)

clean:
	rm -f $(PROGRAMS) *.o
