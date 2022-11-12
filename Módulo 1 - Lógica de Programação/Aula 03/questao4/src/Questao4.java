//Faça o exercício anterior, utilizando if-else

import java.util.InputMismatchException;
import java.util.Scanner;

public class Questao4 {
    public static void main(String[] args) {
        System.out.println("\t\t*****\tVENDA DE BEBIDAS\t*****\n");
        System.out.println("1 - Coca-Cola - R$ 5,00");
        System.out.println("2 - Coca-Cola 0 - R$ 4,50");
        System.out.println("3 - Pepsi - R$ 4,40");
        System.out.println("4 - Guaraná Antarctica - R$ 3,50");
        System.out.println("5 - Fanta Laranja - R$ 4,23");
        System.out.println("6 - Água - R$ 2,50");

        boolean erro = true;

        do {
            try{
                Scanner scanner = new Scanner(System.in);
                System.out.print("\nDigite o número da opção: ");
                int opcao = scanner.nextInt();

                selecionarProduto(opcao);

                if (opcao >= 1 && opcao <= 6){
                   scanner.close();
                   erro = false;
                }

            } catch (InputMismatchException exception){
                System.out.println("Digite apenas números!");
            }

        }while(erro);
    }

    public static void selecionarProduto (int opcao){

        if (opcao == 1){
            System.out.println("Você comprou: Coca-Cola no valor de R$5,00");
        } else if (opcao == 2) {
            System.out.println("Você comprou: Coca-Cola 0 no valor de R$4,50");
        } else if (opcao == 3) {
            System.out.println("Você comprou: Pepsi no valor de R$4,40");
        } else if (opcao == 4) {
            System.out.println("Você comprou: Guaraná Antarctica no valor de R$3,50");
        } else if (opcao == 5) {
            System.out.println("Você comprou: Fanta Laranja no valor de R$4,23");
        } else if (opcao == 6) {
            System.out.println("Você comprou: Água no valor de R$2,50");
        } else {
            System.out.println("Digite apenas números de 1 a 6!");
        }

    }
}
