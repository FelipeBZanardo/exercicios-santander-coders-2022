/*Faça um programa que pegue o nome completo que o usuário digitar e
imprima o nome com cada parte separada por espaço,
um símbolo de exclamação no início.

Exemplo:
Nome: João Mario da Silva
Resultado: !João !Maria !da !Silva*/

/*Comentários sobre o exercício:
 * A resolução prevê que o nome digitado pelo usuário está sem excessos de espaços entre as palavras.
 * Caso isso aconteça, irá aparecer no resultado mais aparições do ponto de exclamação.
 * Para corrigir esse erro, basta descomentar a linha 25 e comentar a linha 26:
 *   ela substitui qualquer aparição de espaço, inclusive vários espaços seguidos,
 *   por " !";*/

import java.util.Scanner;

public class Questao2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome: ");
        String nomeEntrada = scanner.nextLine().trim();

        //String nomeModificado = "!" + nomeEntrada.replaceAll("\\s+", " !");                   //Leia os comentários acima sobre essa linha
        String nomeModificado = "!" + nomeEntrada.replace(" ", " !");
        System.out.println("Resultado: " + nomeModificado);
    }
}
