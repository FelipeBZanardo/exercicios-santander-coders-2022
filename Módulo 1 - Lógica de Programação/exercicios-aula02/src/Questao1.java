/*Faça um programa que receba uma frase com
"Janeiro: 1543, Fevereiro: 1222, Março: 1234".
Imprima sequencialmente em linhas separadas por cada mês
e na última linha a frase:
"Total: " e o valor da soma de todos os meses.
Exemplo:
        Janeiro: 1543
        Fevereiro: 1222
        Março: 1234
        Total: 3999*/

/*Comentários sobre o exercício:
* A resolução prevê que a frase está digitada sem excessos de espaços entre as palavras.
* Caso isso aconteça, ocorrerá um erro, já que .substring pegaria uma "fatia" errada com os números
* Para corrigir esse erro, basta descomentar a linha 22:
*   ela substitui qualquer aparição de espaço, inclusive vários espaços seguidos,
*   por apenas um, assim a frase ficaria idêntica ao enunciado*/

public class Questao1 {
    public static void main(String[] args) {
        String frase = "Janeiro: 1543, Fevereiro: 1222, Março: 1234";
        //frase = frase.replaceAll("\\s+", " ");            //Leia os comentários acima sobre essa linha

        String[] meses = frase.split(",");
        int soma = 0;
        for (String mes : meses){
            soma += Integer.parseInt(mes.substring(mes.indexOf(":") + 2));
            System.out.println(mes.trim());
        }
        System.out.println("Total: " + soma);
    }
}
