public class Questao1Matriz {
    public static void main(String[] args) {
        //Utilizando um array bidemensional(matriz)

        String[][] dadosEsperados = {{"18", "70", "42", "15", "10", "3", "16", "17", "71"},
                {"Voto obrigatório", "Voto obrigatório", "Voto obrigatório",
                        "Sem direito a votar", "Sem direito a votar", "Sem direito a votar",
                        "Voto facultativo", "Voto facultativo", "Voto facultativo"}};

        String[] saidasObtidas = new String[dadosEsperados[0].length];

        int contaFalhas = 0;

        for (int i = 0; i < saidasObtidas.length; i++) {
            saidasObtidas[i] = validarVoto(Integer.parseInt(dadosEsperados[0][i]));
            if(saidasObtidas[i].equals(dadosEsperados[1][i])){
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
                if (!saidasObtidas[i].equals(dadosEsperados[1][i])){
                    System.out.printf("Teste %d - Resultado: %s - Correto: %s\n",
                            (i+1),saidasObtidas[i], dadosEsperados[1][i]);
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
