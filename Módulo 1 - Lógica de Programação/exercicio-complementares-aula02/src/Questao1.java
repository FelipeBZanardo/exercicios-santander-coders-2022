/*Faça um programa, que solicite ao usuário que informe o mês
e o sistema deve imprimir o valor gasto do mês.

->Considerações:
Utilizar enum
Criar um valor para cada mês*/

/*Comentários sobre o exercício:
* Não achei necessário o uso do if/switch na resolução do exercício como comentado em aula
* O enum "Ano" já contém os valores dos gastos de cada mês.
* E esses valores podem ser acessados através do método .getValor()
* O usuário entra com o nome do mês. Se esse mês não existir (digitado errado),
* ocorre uma exceção que é tratada pelo try/catch, obrigando o usuário
* a digitar corretamente através do do...while */

import java.util.Scanner;

public class Questao1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean erro = true;        //variável de controle. true enquanto o usuário digitar um mês inválido

        do {
            System.out.print("Digite um mês do ano: ");
            String mesEntrada = scanner.nextLine().trim().toUpperCase();

            try{
                double gastoMes = Ano.valueOf(mesEntrada).getValor();
                System.out.printf("O gasto do mês de %s é : R$%.2f", mesEntrada, gastoMes);
                erro = false;
            } catch (IllegalArgumentException exception){
                System.err.println(exception.getMessage());
                System.out.println("Esse mês não existe!");
            } catch (Exception exception){
                System.out.println("Erro desconhecido!");
            }

        }while(erro);
    }
}
