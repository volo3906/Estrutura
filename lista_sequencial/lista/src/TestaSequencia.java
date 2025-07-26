public class TestaSequencia {
    public static void main(String[] args) {
        testaConstrutor();
        testaVazia();
        testaCheia();
        testaTamanho();
        testaElemento();
        testaInsere();
        testaRemove();
        System.out.println("\nTodos os testes foram concluídos!");
    }

    public static void imprimeLista(sequencia lista, String mensagem) {
        System.out.print(mensagem + " - Estado atual: ");
        lista.imprime();
    }

    public static void testaConstrutor() {
        System.out.println("\n=== TESTANDO CONSTRUTOR ===");
        sequencia lista = new sequencia();
        imprimeLista(lista, "Construtor");
        verifica("Construtor - Lista deve iniciar vazia", lista.vazia());
        verifica("Construtor - Tamanho deve ser 0", lista.tamanho() == 0);
    }

    public static void testaVazia() {
        System.out.println("\n=== TESTANDO VAZIA() ===");
        sequencia lista = new sequencia();
        imprimeLista(lista, "Lista nova");
        verifica("vazia() - Lista nova deve estar vazia", lista.vazia());
        
        lista.insere(10, 1);
        imprimeLista(lista, "Após inserir 10 na posição 1");
        verifica("vazia() - Lista com elementos não deve estar vazia", !lista.vazia());
    }

    public static void testaCheia() {
        System.out.println("\n=== TESTANDO CHEIA() ===");
        sequencia lista = new sequencia();
        imprimeLista(lista, "Lista nova");
        verifica("cheia() - Lista nova não deve estar cheia", !lista.cheia());
        
        for (int i = 1; i <= 10; i++) {
            lista.insere(i, i);
            imprimeLista(lista, "Inserido " + i + " na posição " + i);
        }
        verifica("cheia() - Lista preenchida deve estar cheia", lista.cheia());
    }

    public static void testaTamanho() {
        System.out.println("\n=== TESTANDO TAMANHO() ===");
        sequencia lista = new sequencia();
        imprimeLista(lista, "Lista nova");
        verifica("tamanho() - Lista nova deve ter tamanho 0", lista.tamanho() == 0);
        
        lista.insere(1, 1);
        imprimeLista(lista, "Após inserir 1 na posição 1");
        verifica("tamanho() - Deve retornar 1 após inserção", lista.tamanho() == 1);
        
        lista.remove(1);
        imprimeLista(lista, "Após remover da posição 1");
        verifica("tamanho() - Deve retornar 0 após remoção", lista.tamanho() == 0);
    }

    public static void testaElemento() {
        System.out.println("\n=== TESTANDO ELEMENTO() ===");
        sequencia lista = new sequencia();
        lista.insere(10, 1);
        lista.insere(20, 2);
        lista.insere(30, 3);
        imprimeLista(lista, "Lista inicial");
        
        verifica("elemento() - Posição válida 1", lista.elemento(1) == 10);
        verifica("elemento() - Posição válida 2", lista.elemento(2) == 20);
        verifica("elemento() - Posição válida 3", lista.elemento(3) == 30);
        verifica("elemento() - Posição inválida 0", lista.elemento(0) == -1);
        verifica("elemento() - Posição inválida 4", lista.elemento(4) == -1);
    }

    public static void testaInsere() {
        System.out.println("\n=== TESTANDO INSERE() ===");
        sequencia lista = new sequencia();
        imprimeLista(lista, "Lista vazia");
        
        verifica("insere() - Inserir no início lista vazia", lista.insere(10, 1));
        imprimeLista(lista, "Após inserir 10 na posição 1");
        
        verifica("insere() - Inserir no final", lista.insere(20, 2));
        imprimeLista(lista, "Após inserir 20 na posição 2");
        
        verifica("insere() - Inserir no meio", lista.insere(15, 2));
        imprimeLista(lista, "Após inserir 15 na posição 2");
        
        verifica("insere() - Posição 0 deve falhar", !lista.insere(5, 0));
        imprimeLista(lista, "Tentativa de inserir na posição 0 (sem mudança)");
        
        verifica("insere() - Posição > tamanho+1 deve falhar", !lista.insere(5, 5));
        imprimeLista(lista, "Tentativa de inserir na posição 5 (sem mudança)");
        
        while (!lista.cheia()) {
            int pos = lista.tamanho() + 1;
            lista.insere(pos * 10, pos);
            imprimeLista(lista, "Inserido " + (pos * 10) + " na posição " + pos);
        }
        verifica("insere() - Lista cheia deve falhar", !lista.insere(100, 1));
        imprimeLista(lista, "Tentativa de inserir em lista cheia (sem mudança)");
    }

  public static void testaRemove() {
    System.out.println("\n=== TESTANDO REMOVE() ===");
    sequencia lista = new sequencia();
    lista.insere(10, 1);
    lista.insere(20, 2);
    lista.insere(30, 3);
    imprimeLista(lista, "Lista inicial [10, 20, 30]");
    
    int removido = lista.remove(2);
    imprimeLista(lista, "Após remover posição 2 (valor 20)");
    verifica("remove() - Deve retornar valor 20", removido == 20);
    verifica("remove() - Tamanho deve ser 2", lista.tamanho() == 2);
    verifica("remove() - Elemento na posição 2 deve ser 30", lista.elemento(2) == 30);
    
    removido = lista.remove(0);
    imprimeLista(lista, "Tentativa de remover posição 0");
    verifica("remove() - Deve retornar -1 para posição 0", removido == -1);
    verifica("remove() - Tamanho deve permanecer 2", lista.tamanho() == 2);
    
    removido = lista.remove(3);
    imprimeLista(lista, "Tentativa de remover posição 3");
    verifica("remove() - Deve retornar -1 para posição 3", removido == -1);
    verifica("remove() - Tamanho deve permanecer 2", lista.tamanho() == 2);
    
    removido = lista.remove(1);
    imprimeLista(lista, "Após remover posição 1 (valor 10)");
    verifica("remove() - Deve retornar valor 10", removido == 10);
    verifica("remove() - Tamanho deve ser 1", lista.tamanho() == 1);
    
    removido = lista.remove(1);
    imprimeLista(lista, "Após remover posição 1 (valor 30) - lista vazia");
    verifica("remove() - Deve retornar valor 30", removido == 30);
    verifica("remove() - Tamanho deve ser 0", lista.tamanho() == 0);
    verifica("remove() - Lista deve estar vazia", lista.vazia());
    
    removido = lista.remove(1);
    imprimeLista(lista, "Tentativa de remover de lista vazia");
    verifica("remove() - Deve retornar -1 para lista vazia", removido == -1);
}

    public static void verifica(String mensagem, boolean condicao) {
        if (condicao) {
            System.out.println("[OK] " + mensagem);
        } else {
            System.out.println("[ERRO] " + mensagem);
        }
    }
}