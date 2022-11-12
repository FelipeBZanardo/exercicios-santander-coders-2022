/*Escreva um programa para verificar se uma pessoa pode votar ou não,
de acordo com sua idade. O programa deve escrever na tela as seguintes informacões:

"Voto obrigatório"  - para eleitoras e eleitores, com idades entre 18 e 70 anos.
"Voto  facultativo" - para maiores ou iguais a 16 anos e menores de 18 anos;
 assim como maiores de 70 anos.
"Sem direito a votar" - para o restante.
Fonte: https://www.tre-sc.jus.br/eleicoes/tire-suas-duvidas/voto-obrigatoriedade

* Exemplo
Entrada - 16
Saida - Voto Facultativo*/

import java.util.Scanner;

public class Questao1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a sua idade: ");
        int idade = scanner.nextInt();

        scanner.close();

        if ((idade >= 16 && idade < 18) || idade > 70){
            System.out.println("Voto facultativo");
        } else if(idade >= 18) {
            System.out.println("Voto obrigatório");
        } else {
            System.out.println("Sem direito a votar");
        }
    }
}
