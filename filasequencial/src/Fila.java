public class Fila {
    private int valores[];
    private int inicio;
    private int fim;
    private int quantidade;
    private int maximo;

    public static void main(String[] args) {
        Fila fila = new Fila();
        
        System.out.println("=== TESTES DA FILA ===");
        
        System.out.println("\nTeste 1 - Estado inicial:");
        System.out.println("Vazia? " + fila.vazia());
        System.out.println("Cheia? " + fila.cheia());
        System.out.println("Tamanho: " + fila.tamanho());
        System.out.println("Início: " + fila.comeco());
        System.out.println("Fim: " + (fila.vazia() ? "-1" : fila.valores[fila.fim])); 
        System.out.print("Conteúdo: ");
        fila.imprimir();

        System.out.println("\n\nTeste 2 - Inserindo elementos:");
        int[] elementos = {10, 20, 30, 40, 50};
        for (int elem : elementos) {
            System.out.println("\nInserindo " + elem + ":");
            System.out.println("Sucesso? " + fila.inserir(elem));
            System.out.print("Fila: ");
            fila.imprimir();
            System.out.println("\nVazia? " + fila.vazia());
            System.out.println("Cheia? " + fila.cheia());
            System.out.println("Tamanho: " + fila.tamanho());
            System.out.println("Início: " + fila.comeco());
            System.out.println("Fim: " + fila.valores[fila.fim]); 
        }

        System.out.println("\n\nTeste 3 - Tentando inserir em fila cheia:");
        System.out.println("Inserindo 60: " + fila.inserir(60));
        System.out.print("Fila: ");
        fila.imprimir();
        System.out.println("\nInício: " + fila.comeco());
        System.out.println("Fim: " + fila.valores[fila.fim]); 

        System.out.println("\n\nTeste 4 - Removendo elementos:");
        while (!fila.vazia()) {
            System.out.println("\nRemovendo elemento:");
            int removido = fila.remover();
            System.out.println("Elemento removido: " + removido);
            System.out.print("Fila atual: ");
            fila.imprimir();
            System.out.println("\nVazia? " + fila.vazia());
            System.out.println("Cheia? " + fila.cheia());
            System.out.println("Tamanho: " + fila.tamanho());
            if (!fila.vazia()) {
                System.out.println("Início: " + fila.comeco());
                System.out.println("Fim: " + fila.valores[fila.fim]); 
            }
        }

        System.out.println("\n\nTeste 5 - Tentando remover de fila vazia:");
        System.out.println("Resultado: " + fila.remover());
        System.out.print("Fila: ");
        fila.imprimir();
        System.out.println("\nInício: " + fila.comeco());
        System.out.println("Fim: " + (fila.vazia() ? "-1" : fila.valores[fila.fim])); // Mostra fim
    }

    public Fila() {
        inicio = 0;
        fim = -1;
        quantidade = 0;
        maximo = 5;
        valores = new int[maximo];
    }

    public boolean vazia() {
        if (quantidade == 0){
          return true;
        }
        else{
          return false;
        }
    }

    public boolean cheia() {
      if(quantidade == maximo){
        return true;
      }
      else{
        return false;
      }
    }

    public int tamanho() {
        return quantidade;
    }

    public int comeco() {
        if(vazia()) {
            return -1;
        }
        else {
            return valores[inicio];
        }
    }

    public boolean inserir(int num) {
        if(cheia()) {
            return false;
        }

        fim = (fim + 1) % maximo;
        valores[fim] = num;
        quantidade++;
        return true;
    }

    public int remover() {
        if(vazia()) {
            return -1;
        }
        int valor_removido = valores[inicio];
        inicio = (inicio + 1) % maximo;
        quantidade--;
        return valor_removido;
    }

    public void imprimir() {
        if (vazia()) {
            System.out.println("Fila vazia!");
            return;
        }
        
        int i = inicio;
        int contador = 0;
        
        while (contador < quantidade) {
            System.out.print(valores[i] + " ");
            i = (i + 1) % maximo;
            contador++;
        }
    }
}