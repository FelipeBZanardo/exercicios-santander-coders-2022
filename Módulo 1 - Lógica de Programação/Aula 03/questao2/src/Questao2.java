/*Faça o exercício anterior com o operador ternário*/

import java.util.Scanner;

public class Questao2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a sua idade: ");
        int idade = scanner.nextInt();

        scanner.close();

        String voto = (idade >= 16 && idade < 18 || idade > 70) ? "Voto facultativo" :
                ((idade >= 18) ? "Voto obrigatório" : "Sem direito a votar");

        System.out.println(voto);
    }
}
