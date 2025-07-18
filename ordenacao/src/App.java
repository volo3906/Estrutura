import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Uso: java selection <arquivo.in>");
            return;
        }

        long[] numbers = lerArquivo(args[0]);

        long[] copia_do_array = Arrays.copyOf(numbers, numbers.length);
        long[] copia_do_array1 = Arrays.copyOf(numbers, numbers.length);

        System.out.println("Antes da ordenação:");
        System.out.println(Arrays.toString(copia_do_array1));

        long inicio = System.nanoTime();

        selectionsort(copia_do_array1);

        long fim = System.nanoTime();

        System.out.println("Antes da ordenação:");
        System.out.println(Arrays.toString(copia_do_array1));

        long duracaoEmNano = fim - inicio;
        double duracaoEmMili = duracaoEmNano / 1_000_000.0;

        System.out.println("Antes da ordenação:\n");
        printArray(copia_do_array);

        long inicio1 = System.nanoTime();

        insertionsort(copia_do_array);

        long fim1 = System.nanoTime();

        System.out.println("Depois da ordenação:\n");
        printArray(copia_do_array);

        long duracaoEmNano1 = fim1 - inicio1;
        double duracaoEmMili1 = duracaoEmNano1 / 1_000_000.0;
        System.out.printf("Tempo de execução do Selection Sort: %.3f ms\n", duracaoEmMili);
        System.out.printf("Tempo de execução do Insertion Sort: %.3f ms\n", duracaoEmMili1);

        System.out.println();

        if (duracaoEmMili < duracaoEmMili1) {
            System.out.printf("O Selection Sort foi mais rápido por %.3f ms\n", duracaoEmMili1 - duracaoEmMili);
        } else if (duracaoEmMili1 < duracaoEmMili) {
            System.out.printf("O Insertion Sort foi mais rápido por %.3f ms\n", duracaoEmMili - duracaoEmMili1);
        } else {
            System.out.println("Os dois algoritmos tiveram o mesmo tempo de execução.");
        }
    }

    private static long[] lerArquivo(String nomeArquivo) {
        try {
            Scanner scanner = new Scanner(new File(nomeArquivo));

            int tamanho = scanner.nextInt();
            long[] numbers = new long[tamanho];

            for (int i = 0; i < tamanho; i++) {
                numbers[i] = scanner.nextLong();
            }

            scanner.close();
            return numbers;
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + nomeArquivo);
        } catch (Exception e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return new long[0];
    }

    private static void selectionsort(long[] numbers){
        int length = numbers.length;

        for(int i = 0; i < length-1; i++){
            long min = numbers[i];
            int indexOfMin = i;

            for(int j = i+1; j < length; j++){
                if(numbers[j] < min){
                    min = numbers[j];
                    indexOfMin = j;
                }
            }
            swap(numbers, i, indexOfMin);
        }
    }

    private static void swap(long[] numbers, int a, int b){
        long temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }

    private static void printArray(long[] numbers) {
        for (long number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    private static void insertionsort(long[] inputArray) {
        for (int i = 1; i < inputArray.length; i++) {
            long valor_atual = inputArray[i];
            int j = i - 1;
            while (j >= 0 && inputArray[j] > valor_atual) {
                inputArray[j + 1] = inputArray[j];
                j--;
            }
            inputArray[j + 1] = valor_atual;
        }
    }
}
