/*Faça um programa para testar o exercicio do "Voto”, feito em casa.
O programa deve utilizar um array(pode ser bidimensional), onde devem estar armazenados
a entrada e o resultado do método, também conhecido como array de teste.
O programa deve percorrer o array de teste, enviando a entrada para o método e
comparar o resultado do método com o valor armazenado no array.
Caso o resultado do array seja igual ao método.

Exibir a seguinte mensagem:
Teste (numero do teste) - Sucesso.
Caso o resultado do array seja diferente do método
Exibir a seguinte mensagem:
Teste (numero do teste) - Falhou.
A execução da aplição deve ficar parecida com a forma abaixo.
Por exemplo:

Teste1 - Sucesso
Teste2 - Falha
Teste3 - Sucesso
Os testes devem conter:
3 casos “Não pode votar”
3 casos “Voto obrigatório”
3 casos “Voto opcional”
Observação:

Utilizar casos extremos que atinjam o começo e o fim de uma condição.
Por exemplo:

18 e 70 nos casos de "Voto obrigatório”
16 e 17 nos casos de "Voto opcional”

Extra:

Gravar o resultado de cada teste dentro de um array,
para informar o resultado geral dos testes.
Caso todos os testes passem com sucesso:
Exibir a seguinte mensagem: "Testes executados com sucesso".
Caso algum dos testes falhe:
Exibir a mensagem com os testes que falharam: Os seguintes testes falharam:
Teste 1 - Resultado : "Obrigatorio" - Correto: "Não pode votar"*/

public class Questao1Array {
    public static void main(String[] args) {
        //Utilizando dois arrays separados

        int[] entrada = {18, 70, 42, 15, 10, 3, 16, 17, 71};
        String[] saidasEsperadas = {"Voto obrigatório", "Voto obrigatório", "Voto obrigatório",
                "Sem direito a votar", "Sem direito a votar", "Sem direito a votar",
                "Voto facultativo", "Voto facultativo", "Voto facultativo"};

        String[] saidasObtidas = new String[saidasEsperadas.length];

        int contaFalhas = 0;

        for (int i = 0; i < entrada.length; i++) {
            saidasObtidas[i] = validarVoto(entrada[i]);
            if(saidasObtidas[i].equals(saidasEsperadas[i])){
                System.out.printf("Teste %d - \u001B[32mSucesso\u001B[0m\n", (i+1));
            } else {
                System.out.printf("Teste %d - \u001B[31mFalhou\u001B[0m\n", (i+1));
                contaFalhas++;
            }
        }

        //Parte extra:
        if(contaFalhas == 0){
            System.out.println("Testes executados com sucesso");
        } else{
            System.out.println("Os seguintes testes falharam: ");
            for (int i = 0; i < saidasObtidas.length; i++){
                if (!saidasObtidas[i].equals(saidasEsperadas[i])){
                    System.out.printf("Teste %d - Resultado: %s - Correto: %s\n",
                            (i+1),saidasObtidas[i], saidasEsperadas[i]);
                }
            }
        }

    }

    public static String validarVoto(int idade){
        if ((idade >= 16 && idade < 18) || idade > 70){
            return "Voto facultativo";
        } else if(idade >= 18) {
            return "Voto obrigatório";
        } else {
            return "Sem direito a votar";
        }
    }
}
