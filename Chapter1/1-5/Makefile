CC=gcc
CFLAGS= -g -pedantic -std=c99 -Wall -lm
DEPS = 
OBJ = oneAway.o
PROGRAMS = OneAway

all : $(PROGRAMS)

%.o: %.c $(DEPS)
	$(CC) -c -o $@ $< $(CFLAGS)

OneAway: $(OBJ)
	$(CC) -o $@ $^ $(CFLAGS)

clean:
	rm -f $(PROGRAMS) *.o
