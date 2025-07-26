JAVAC = javac
JAVA = java
SRC = sequencia.java TestaSequencia.java
CLASS = sequencia.class TestaSequencia.class

all: compile

compile:
	$(JAVAC) $(SRC)

run:
	$(JAVA) sequencia

test: compile
	$(JAVA) TestaSequencia

clean:
	rm -f $(CLASS)

.PHONY: all compile run test clean
