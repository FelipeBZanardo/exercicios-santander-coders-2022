import java.util.LinkedHashSet;
import java.util.Set;

public class Carrinho {
    private Set<Produto> listaProdutos = new LinkedHashSet<>();

    public Carrinho() {
    }

    public Produto receberProduto(){
        String nome = "";
        while(true){
            nome = Menu.receberNomeProduto().trim().toUpperCase();
            if(!this.verificarProduto(nome)){
                System.out.println("\u001B[31mEsse produto já existe\u001B[0m.");
            }else{
                break;
            }
        }
        int quantidade = Menu.receberQuantidadeProduto();
        double preco = Menu.receberPrecoProduto();

        return new Produto(nome, quantidade, preco);
    }

    public boolean adicionarProduto (Produto produto){
        return listaProdutos.add(produto);
    }

    public void imprimirLista(){
        System.out.println("\n****\tCARRINHO DE COMPRAS\t****");
        System.out.println("====================================================\n");
        System.out.printf("%-20s %-20s %-20s %-20s\n",
                "Produto", "Quantidade", "Preço(R$)", "Total(R$)");

        double soma = 0d;
        for(Produto produto : listaProdutos){
            soma += produto.getPreco() * produto.getQuantidade();
            System.out.printf("%-20s %-20d %-20.2f %-20.2f\n",
                    produto.getNome(), produto.getQuantidade(), produto.getPreco(),
                    produto.getPreco() * produto.getQuantidade());
        }
        System.out.printf("\n\u001B[32mTotal R$%.2f\u001B[0m\n",soma);
    }

    public boolean verificarProduto(String nome){
        String nomeProduto = nome.trim().toUpperCase();

        if (listaProdutos.size() != 0){
            for(Produto produto : listaProdutos){
                if(produto.getNome().equalsIgnoreCase(nomeProduto)){
                    return false;
                }
            }
        }
        return true;
    }


}
