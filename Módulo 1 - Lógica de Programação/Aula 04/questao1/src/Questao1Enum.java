
enum Voto {
    VOTO_OBRIGATORIO ("Voto obrigatório"),
    VOTO_FACULTATIVO ("Voto facultativo"),
    NAO_VOTA ("Sem direito a votar");

    private final String DESCRICAO;

    Voto(String descricao) {
        this.DESCRICAO = descricao;
    }

    public String getDescricao() {
        return DESCRICAO;
    }

}

public class Questao1Enum {
    public static void main(String[] args) {

        //Utilizando enum e array

        int[] entrada = {18, 70, 42, 15, 10, 3, 16, 17, 71};

        Voto[] saidasEsperadas = {Voto.VOTO_OBRIGATORIO, Voto.VOTO_OBRIGATORIO, Voto.VOTO_OBRIGATORIO,
        Voto.NAO_VOTA, Voto.NAO_VOTA, Voto.NAO_VOTA,
        Voto.VOTO_FACULTATIVO, Voto.VOTO_FACULTATIVO, Voto.VOTO_FACULTATIVO};

        Voto[] saidasObtidas = new Voto[entrada.length];

        int contaFalhas = 0;

        for (int i = 0; i < entrada.length; i++){
            saidasObtidas[i] = validarVoto(entrada[i]);
            if(saidasObtidas[i].equals(saidasEsperadas[i])){
                System.out.printf("Teste %d - \u001B[32mSucesso\u001B[0m\n", (i+1));
            }else {
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
                            (i+1),saidasObtidas[i].getDescricao(), saidasEsperadas[i].getDescricao());
                }
            }
        }


    }

    public static Voto validarVoto(int idade){
        if ((idade >= 16 && idade < 18) || idade > 70){
            return Voto.VOTO_FACULTATIVO;
        } else if(idade >= 18) {
            return Voto.VOTO_OBRIGATORIO;
        } else {
            return Voto.NAO_VOTA;
        }
    }
}
