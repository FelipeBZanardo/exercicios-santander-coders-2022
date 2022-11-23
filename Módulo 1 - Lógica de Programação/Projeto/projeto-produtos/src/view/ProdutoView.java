package view;

import controller.ArquivoController;
import model.Produto;

import java.util.*;

public class ProdutoView {
    Scanner scanner = new Scanner(System.in);

    public String pegarOpcaoMenu(){
        System.out.println("""
                
                1 - Criar novo Produto
                2 - Editar Produto
                3 - Excluir Produto
                4 - Pesquisar Produto
                5 - Comprar Produtos
                0 - Encerrar Programa
                """);
        System.out.print("Digite a opção desejada: ");
        return scanner.nextLine();
    }

    public Map<String, Object> pegarInformacoesProduto(){
        Map<String, Object> produto = new HashMap<>();

        String nome = pegarNomeProduto();
        Integer quantidade = pegarQuantidadeProduto();
        Double preco = pegarPrecoProduto();
        produto.put("nome", nome);
        produto.put("quantidade", quantidade);
        produto.put("preco", preco);

        return produto;
    }

    public String pegarNomeProduto(){
        System.out.print("Digite nome produto: ");
        return scanner.nextLine().trim().toUpperCase();
    }

    public Integer pegarQuantidadeProduto(){
        while (true){
            try{
                System.out.print("Digite a quantidade: ");
                Integer quantidade = scanner.nextInt();
                if (quantidade <= 0){
                    System.out.println("\u001B[31mQuantidade inválida\u001B[0m");
                } else{
                    return quantidade;
                }
            } catch (InputMismatchException exception){
                System.out.println("\u001B[31mDigite apenas números\u001B[0m");
            } finally {
                scanner.nextLine();
            }
        }
    }

    public Double pegarPrecoProduto(){
        while (true){
            try{
                System.out.print("Digite o preço: R$");
                Double preco =  scanner.nextDouble();
                if (preco <= 0){
                    System.out.println("\u001B[31mPreço inválido\u001B[0m");
                } else {
                    return preco;
                }
            } catch (InputMismatchException exception){
                System.out.println("\u001B[31mDigite apenas números\u001B[0m");
            } finally {
                scanner.nextLine();
            }
        }
    }

    public int pegarIdProduto(){
        while(true){
            try{
                System.out.print("Digite o número do Identificador do produto: ");
                int id = scanner.nextInt();
                if (id < 0 || id >= Produto.listaProdutos.size()){
                    System.out.println("\u001B[31mEsse id não existe!\u001B[0m");
                } else {
                    return id;
                }
            } catch (InputMismatchException exception){
                System.out.println("\u001B[31mDigite apenas números\u001B[0m");
            } finally {
                scanner.nextLine();
            }

        }


    }

    public void listarProduto(){
        System.out.println("\n****\tESTOQUE DE PRODUTOS\t****");
        System.out.println("=============================================================================");
        System.out.printf("%-15s %-15s %-15s %-15s\n",
                "Identificador","Produto", "Quantidade", "Preço(R$)");

        for (int i = 0; i < Produto.listaProdutos.size() ; i++) {
            Map<String, Object> produto = Produto.listaProdutos.get(i);

            System.out.printf("%-15d %-15s %-15s %-15.2f\n",
                    i, produto.get("nome"), produto.get("quantidade"),
                    (Double) produto.get("preco"));
        }
    }

    public void listarProdutosPesquisa(String nomeAPesquisar) {
        System.out.println("\n****\tESTOQUE DE PRODUTOS\t****");
        System.out.println("=============================================================================");
        System.out.printf("%-15s %-15s %-15s %-15s\n",
                "Identificador","Produto", "Quantidade", "Preço(R$)");

        for (int i = 0; i < Produto.listaProdutos.size() ; i++) {
            Map<String, Object> produto = Produto.listaProdutos.get(i);

            String nome = (String) produto.get("nome");
            if (nome.contains(nomeAPesquisar)){
                System.out.printf("%-15d %-15s %-15s %-15.2f\n",
                        i, produto.get("nome"), produto.get("quantidade"),
                        (Double) produto.get("preco"));
            }
        }
    }

    public void adicionarProdutosCarrinho(){
        boolean continuar = true;
        while(continuar){
            int id = pegarIdProduto();
            String nome = (String) Produto.listaProdutos.get(id).get("nome");
            Integer quantidadeEstoque = (Integer) Produto.listaProdutos.get(id).get("quantidade");
            Double preco = (Double) Produto.listaProdutos.get(id).get("preco");
            Integer quantidade = 0;
            while (true){
                quantidade = pegarQuantidadeProduto();
                if (quantidade > quantidadeEstoque){
                    System.out.println("\u001B[31mQuantidade indisponível\u001B[0m");
                } else {
                    break;
                }
            }
            Map<String, Object> produtoComprado = new HashMap<>();
            produtoComprado.put("nome", nome);
            produtoComprado.put("quantidade", quantidade);
            produtoComprado.put("preco", preco);
            Produto.listaProdutosComprados.add(produtoComprado);
            Map<String, Object> produto = Produto.listaProdutos.get(id);
            produto.put("nome", nome);
            produto.put("quantidade", quantidadeEstoque - quantidade);
            produto.put("preco", preco);
            ArquivoController.escreverArquivo();
            continuar = continuarComprando();
        }


        listarProdutosComprados();
    }

    public boolean continuarComprando(){
        while(true){
            System.out.print("Deseja continuar? [S/N] ");
            String continuar = scanner.nextLine().trim();
            if(continuar.equalsIgnoreCase("N")){
                return false;
            } else if (continuar.equalsIgnoreCase("S")) {
                return true;
            } else {
                System.out.println("\u001B[31mDigite apenas S para Sim ou N para Não\u001B[0m");
            }
        }
    }

    public void listarProdutosComprados(){
        System.out.println("\n****\tPRODUTOS COMPRADOS\t****");
        System.out.println("=============================================================================");
        System.out.printf("%-15s %-15s %-15s %-15s %-15s\n",
                "Identificador","Produto", "Quantidade", "Preço(R$)", "Total(R$)");

        double soma = 0;
        for (int i = 0; i < Produto.listaProdutosComprados.size() ; i++) {
            Map<String, Object> produto = Produto.listaProdutosComprados.get(i);

            soma += (Double) produto.get("preco") * (Integer) produto.get("quantidade");
            System.out.printf("%-15d %-15s %-15s %-15.2f %-15.2f\n",
                    i, produto.get("nome"), produto.get("quantidade"),
                    (Double) produto.get("preco"),
                    (Double) produto.get("preco") * (Integer) produto.get("quantidade"));
        }
        System.out.printf("\u001B[32mTotal R$%.2f\n\n\u001B[0m", soma);
    }
    public void fecharScanner(){
        scanner.close();
    }
}
