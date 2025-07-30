public class Encadeado {

    public class No {
        private int conteudo;
        private No proximo;

        public No(int conteudo) {
            this.conteudo = conteudo;
            this.proximo = null;
        }

        public int getConteudo() {
            return conteudo;
        }

        public No getProximo() {
            return proximo;
        }

        public void setConteudo(int novoConteudo) {
            this.conteudo = novoConteudo;
        }

        public void setProximo(No proximo) {
            this.proximo = proximo;
        }
    }

    private No cabeca;
    private int tamanho;

    public Encadeado() {
        cabeca = null;
        tamanho = 0;
    }

    public boolean vazia() {
        return tamanho == 0;
    }

    public int tamanho() {
        return tamanho;
    }

    public int elemento(int pos) {
        if (pos < 1 || pos > tamanho || cabeca == null) {
            return -1;
        }

        No aux = cabeca;
        for (int i = 1; i < pos; i++) {
            aux = aux.getProximo();
        }

        return aux.getConteudo();
    }

    public boolean modifica(int pos, int novoValor) {
        if (pos < 1 || pos > tamanho || cabeca == null) {
            return false;
        }

        No aux = cabeca;
        for (int i = 1; i < pos; i++) {
            aux = aux.getProximo();
        }

        aux.setConteudo(novoValor);
        return true;
    }

    public boolean insere1(int pos, int valor) {
        if ((vazia()) && (pos != 1)) {
            return false;
        }

        if (pos == 1) {
            return insereinicio(valor);
        } else if (pos == tamanho + 1) {
            return inserefim(valor);
        } else if (pos > 1 && pos <= tamanho) {
            return inseremeio(valor, pos);
        }

        return false;
    }

    private boolean insereinicio(int valor) {
        No novoNo = new No(valor);
        novoNo.setProximo(cabeca);
        cabeca = novoNo;
        tamanho++;
        return true;
    }

    private boolean inseremeio(int valor, int pos) {
        No novoNo = new No(valor);
        No anterior = cabeca;

        for (int i = 1; i < pos - 1; i++) {
            anterior = anterior.getProximo();
        }

        if (anterior == null) return false;

        novoNo.setProximo(anterior.getProximo());
        anterior.setProximo(novoNo);
        tamanho++;
        return true;
    }

    private boolean inserefim(int valor) {
        No novoNo = new No(valor);

        if (vazia()) {
            cabeca = novoNo;
        } else {
            No auxiliar = cabeca;
            while (auxiliar.getProximo() != null) {
                auxiliar = auxiliar.getProximo();
            }
            auxiliar.setProximo(novoNo);
        }

        tamanho++;
        return true;
    }

    public int remover(int pos) {
        if (vazia() || pos < 1 || pos > tamanho) {
            return -1;
        }

        if (pos == 1) {
            return removeinicio();
        } else if (pos == tamanho) {
            return removefim();
        } else {
            return removemeio(pos);
        }
    }

    private int removeinicio() {
        No auxiliar = cabeca;
        int valor = auxiliar.getConteudo();

        cabeca = auxiliar.getProximo();
        tamanho--;

        auxiliar.setProximo(null);
        auxiliar = null;

        return valor;
    }

    private int removefim() {
        if (tamanho == 1) {
            int valor = cabeca.getConteudo();
            cabeca = null;
            tamanho--;
            return valor;
        }

        No anterior = cabeca;
        for (int i = 1; i < tamanho - 1; i++) {
            anterior = anterior.getProximo();
        }

        No removido = anterior.getProximo();
        int valor = removido.getConteudo();

        anterior.setProximo(null);
        removido.setProximo(null);
        removido = null;

        tamanho--;
        return valor;
    }

    private int removemeio(int pos) {
        No atual = cabeca;
        No anterior = null;

        for (int i = 1; i < pos; i++) {
            anterior = atual;
            atual = atual.getProximo();
        }

        if (atual == null) return -1;

        int valor = atual.getConteudo();
        anterior.setProximo(atual.getProximo());

        atual.setProximo(null);
        atual = null;

        tamanho--;
        return valor;
    }

    public void imprimir() {
        No atual = cabeca;
        System.out.print("[");
        while (atual != null) {
            System.out.print(atual.getConteudo());
            if (atual.getProximo() != null) {
                System.out.print(", ");
            }
            atual = atual.getProximo();
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Encadeado lista = new Encadeado();
        
        System.out.println("=== TESTANDO LISTA ENCADEADA ===");
        System.out.println("Lista criada. Vazia? " + lista.vazia());
        System.out.println("Tamanho inicial: " + lista.tamanho());
        
        System.out.println("\n=== TESTE DE INSERÇÃO ===");
        for (int i = 1; i <= 10; i++) {
            lista.insere1(i, i * 10);
            System.out.println("Inserido " + (i * 10) + " na posição " + i + ":");
            lista.imprimir();
        }
        
        System.out.println("\nTamanho após inserções: " + lista.tamanho());
        
        System.out.println("\n=== TESTE DE ACESSO A ELEMENTOS ===");
        for (int i = 1; i <= 10; i++) {
            System.out.println("Elemento na posição " + i + ": " + lista.elemento(i));
        }
        
        System.out.println("\n=== TESTE DE MODIFICAÇÃO ===");
        for (int i = 1; i <= 10; i++) {
            lista.modifica(i, lista.elemento(i) + 5);
            System.out.println("Modificado elemento " + i + ":");
            lista.imprimir();
        }
        
        System.out.println("\n=== TESTE DE REMOÇÃO ===");
        
        System.out.println("Removido do início: " + lista.remover(1));
        lista.imprimir();
        System.out.println("Tamanho: " + lista.tamanho());
        
        System.out.println("\nRemovido do meio (posição 5): " + lista.remover(5));
        lista.imprimir();
        System.out.println("Tamanho: " + lista.tamanho());
        
        System.out.println("\nRemovido do fim: " + lista.remover(lista.tamanho()));
        lista.imprimir();
        System.out.println("Tamanho: " + lista.tamanho());
        
        System.out.println("\n=== TESTE DE INSERÇÃO EM POSIÇÕES ESPECÍFICAS ===");
        
        System.out.println("Inserindo 100 no início:");
        lista.insere1(1, 100);
        lista.imprimir();
        
        System.out.println("\nInserindo 200 na posição 3:");
        lista.insere1(3, 200);
        lista.imprimir();
        
        System.out.println("\nInserindo 300 no fim:");
        lista.insere1(lista.tamanho() + 1, 300);
        lista.imprimir();
        
        System.out.println("\n=== TESTE DE CASOS ESPECIAIS ===");
        
        System.out.println("Elemento na posição 20 (inválida): " + lista.elemento(20));
        
        System.out.println("Remover na posição 20 (inválida): " + lista.remover(20));
        
        System.out.println("Modificar posição 20 (inválida): " + lista.modifica(20, 99));
        
        System.out.println("\nEsvaziando a lista:");
        while (!lista.vazia()) {
            System.out.println("Removido do início: " + lista.remover(1));
            lista.imprimir();
        }
        
        System.out.println("\nLista vazia? " + lista.vazia());
        System.out.println("Tamanho final: " + lista.tamanho());
        System.out.println("\nTentativa de remoção em lista vazia: " + lista.remover(1));
        System.out.println("Tentativa de acesso em lista vazia: " + lista.elemento(1));

    }
}
