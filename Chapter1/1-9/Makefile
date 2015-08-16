CC=gcc
CFLAGS= -g -pedantic -std=c99 -Wall -lm
DEPS = 
OBJ = stringRotation.o
PROGRAMS = StringRotation

all : $(PROGRAMS)

%.o: %.c $(DEPS)
	$(CC) -c -o $@ $< $(CFLAGS)

StringRotation: $(OBJ)
	$(CC) -o $@ $^ $(CFLAGS)

clean:
	rm -f $(PROGRAMS) *.o
