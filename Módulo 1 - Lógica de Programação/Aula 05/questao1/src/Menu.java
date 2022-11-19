import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    Carrinho carrinho = new Carrinho();
    public void iniciarMenu(){
        System.out.println("****\tCARRINHO DE COMPRAS\t****\n");

        while(true){
            Produto produto = this.carrinho.receberProduto();
            if(this.carrinho.adicionarProduto(produto)){
                System.out.println("\u001B[32mProduto adicionado com sucesso\u001B[0m");
            }
            if (!this.continuarAdicionandoProduto()){
                this.carrinho.imprimirLista();
                System.out.println("Fim do programa");
                break;
            }
        }

    }

    public boolean continuarAdicionandoProduto(){
        Scanner scanner = new Scanner(System.in);
        char resposta = 'N';
        while(true){
            System.out.print("Deseja continuar comprando: [S/N] ");
            resposta = scanner.next().trim().toUpperCase().charAt(0);
            if (resposta == 'S'){
                return true;
            } else if (resposta == 'N') {
                return false;
            } else {
                System.out.println("\u001B[31mDigite apenas S para Sim ou N para Não\u001B[0m");
            }
        }
    }

    public static String receberNomeProduto(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do produto: ");
        return scanner.nextLine();
    }

    public static int receberQuantidadeProduto(){
        Scanner scanner = new Scanner(System.in);

        int quantidade = 0;
        while(true){
            try{
                System.out.print("Quantidade do produto: ");
                quantidade = scanner.nextInt();
                return quantidade;
            } catch (InputMismatchException exception){
                scanner.nextLine();
                System.out.println("\u001B[31mDigite apenas números\u001B[0m");
            }
        }
    }

    public static double receberPrecoProduto(){
        Scanner scanner = new Scanner(System.in);

        double preco = 0;
        while(true){
            try{
                System.out.print("Preço do produto: R$");
                preco = scanner.nextDouble();
                return preco;
            } catch (InputMismatchException exception){
                scanner.nextLine();
                System.out.println("\u001B[31mDigite apenas números\u001B[0m");
            }
        }
    }

}
