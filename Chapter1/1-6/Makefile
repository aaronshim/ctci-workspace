CC=gcc
CFLAGS= -g -pedantic -std=c99 -Wall -lm
DEPS = 
OBJ = stringCompression.o
PROGRAMS = StringCompression

all : $(PROGRAMS)

%.o: %.c $(DEPS)
	$(CC) -c -o $@ $< $(CFLAGS)

StringCompression: $(OBJ)
	$(CC) -o $@ $^ $(CFLAGS)

clean:
	rm -f $(PROGRAMS) *.o
