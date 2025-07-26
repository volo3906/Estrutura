import java.util.Scanner;

public class sequencia {

    private int valor[];
    int tamanhoAtual;
    int tamanhoMax;

    public sequencia() {
        tamanhoMax = 10;
        tamanhoAtual = 0;
        valor = new int[tamanhoMax];
    }

    public boolean vazia() {
        return tamanhoAtual == 0;
    }

    public boolean cheia() {
        return tamanhoAtual == tamanhoMax;
    }

    public int tamanho() {
        return tamanhoAtual;
    }

    public int elemento(int pos) {
        if (pos >= 1 && pos <= tamanhoAtual) {
            return valor[pos - 1];
        }
        return -1;
    }

    public boolean insere(int dado, int pos) {
        if (cheia() || pos < 1 || pos > tamanhoAtual + 1) {
            return false;
        }
        for (int i = tamanhoAtual; i >= pos; i--) {
            valor[i] = valor[i - 1];
        }
        valor[pos - 1] = dado;
        tamanhoAtual++;
        return true;
    }

    public int remove(int pos) {
        if (pos < 1 || pos > tamanhoAtual) {
            return -1;
        }
        int dado = valor[pos - 1];
        for (int i = pos - 1; i < tamanhoAtual - 1; i++) {
            valor[i] = valor[i + 1];
        }
        tamanhoAtual--;
        return dado;
    }

    public void imprime() {
        System.out.print("Lista: ");
        for (int i = 0; i < tamanhoAtual; i++) {
            System.out.print(valor[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        sequencia lista = new sequencia();
        int opcao;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Inserir elemento");
            System.out.println("2. Remover elemento");
            System.out.println("3. Ver elemento em uma posição");
            System.out.println("4. Verificar se está vazia");
            System.out.println("5. Verificar se está cheia");
            System.out.println("6. Mostrar tamanho");
            System.out.println("7. Imprimir lista");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a ser inserido: ");
                    int valor = scanner.nextInt();
                    System.out.print("Digite a posição (1 a " + (lista.tamanhoAtual + 1) + "): ");
                    int pos = scanner.nextInt();
                    if (lista.insere(valor, pos)) {
                        System.out.println("Inserido com sucesso.");
                    } else {
                        System.out.println("Erro ao inserir (lista cheia ou posição inválida).");
                    }
                    break;
                case 2:
                    System.out.print("Digite a posição a remover (1 a " + lista.tamanhoAtual + "): ");
                    int rem = scanner.nextInt();
                    int removido = lista.remove(rem);
                    if (removido != -1) {
                        System.out.println("Removido: " + removido);
                    } else {
                        System.out.println("Posição inválida.");
                    }
                    break;
                case 3:
                    System.out.print("Digite a posição (1 a " + lista.tamanhoAtual + "): ");
                    int p = scanner.nextInt();
                    int val = lista.elemento(p);
                    if (val != -1) {
                        System.out.println("Valor na posição " + p + ": " + val);
                    } else {
                        System.out.println("Posição inválida.");
                    }
                    break;
                case 4:
                    System.out.println("A lista está vazia? " + lista.vazia());
                    break;
                case 5:
                    System.out.println("A lista está cheia? " + lista.cheia());
                    break;
                case 6:
                    System.out.println("Tamanho atual da lista: " + lista.tamanho());
                    break;
                case 7:
                    lista.imprime();
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}

