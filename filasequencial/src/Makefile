# Makefile para Fila Java

# Variáveis
JAVAC = javac
JAVA = java
MAIN_CLASS = Fila
SRC = $(MAIN_CLASS).java
CLASS = $(MAIN_CLASS).class

# Regra padrão (compila)
all: compile

# Compilação
compile:
	@$(JAVAC) $(SRC)

# Execução
run:
	@$(JAVA) $(MAIN_CLASS)

# Limpeza
clean:
	@rm -f $(CLASS)

# Atalho para compilar e executar
test: compile run

.PHONY: all compile run clean test