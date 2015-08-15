CC=gcc
CFLAGS= -g -pedantic -std=c99 -Wall
DEPS = 
OBJ = urlify.o
PROGRAMS = URLify

all : $(PROGRAMS)

%.o: %.c $(DEPS)
	$(CC) -c -o $@ $< $(CFLAGS)

URLify: $(OBJ)
	$(CC) -o $@ $^ $(CFLAGS)

clean:
	rm -f $(PROGRAMS) *.o
