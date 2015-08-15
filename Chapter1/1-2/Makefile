CC=gcc
CFLAGS= -g -pedantic -std=c99 -Wall
DEPS = 
OBJ = checkPermutation.o
PROGRAMS = CheckPermutation

all : $(PROGRAMS)

%.o: %.c $(DEPS)
	$(CC) -c -o $@ $< $(CFLAGS)

CheckPermutation: $(OBJ)
	$(CC) -o $@ $^ $(CFLAGS)

clean:
	rm -f $(PROGRAMS) *.o
