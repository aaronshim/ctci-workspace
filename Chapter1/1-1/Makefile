CC=gcc
CFLAGS= -g -pedantic -std=c99 -Wall
DEPS = 
OBJ = isUnique.o
PROGRAMS = IsUnique

all : $(PROGRAMS)

%.o: %.c $(DEPS)
	$(CC) -c -o $@ $< $(CFLAGS)

IsUnique: $(OBJ)
	$(CC) -o $@ $^ $(CFLAGS)

clean:
	rm -f $(PROGRAMS) *.o