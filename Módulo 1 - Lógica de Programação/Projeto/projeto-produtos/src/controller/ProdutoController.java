package controller;

import model.Arquivo;
import model.Produto;
import view.ProdutoView;

import java.util.HashMap;
import java.util.Map;

public class ProdutoController {

    private ProdutoView view;

    public void menu() {
        view = new ProdutoView();
        boolean continuar = true;
        while (continuar){
            String opcao = view.pegarOpcaoMenu();
            switch (opcao){
                case "1" -> criarProduto();
                case "2" -> editarProduto();
                case "3" -> excluirProduto();
                case "4" -> pesquisarProduto();
                case "5" -> comprarProdutos();
                case "0" -> {
                    view.fecharScanner();
                    continuar = false;
                }
                default -> System.out.println("\u001B[31mOpção inválida\u001B[0m");

            }
        }
    }

    public void criarProduto(){
        Map<String, Object> produto = view.pegarInformacoesProduto();
        Produto.listaProdutos.add(produto);
        ArquivoController.escreverArquivo();
        System.out.println("\u001B[32mProduto criado com sucesso\u001B[0m");
    }

    public void editarProduto(){
        listarProduto();
        if (Produto.listaProdutos.size() != 0) {
            int id = view.pegarIdProduto();
            String nome = view.pegarNomeProduto();
            Integer quantidade = view.pegarQuantidadeProduto();
            Double preco = view.pegarPrecoProduto();
            Map<String, Object> produto = Produto.listaProdutos.get(id);
            produto.put("nome", nome);
            produto.put("quantidade", quantidade);
            produto.put("preco", preco);
            ArquivoController.escreverArquivo();
            System.out.println("\u001B[32mEstoque atualizado com sucesso\u001B[0m");
        }
    }

    public void listarProduto(){
        if (Produto.listaProdutos.size() == 0){
            System.out.println("\u001B[31mEstoque vazio\u001B[0m");
        } else {
            view.listarProduto();
        }
    }

    public void excluirProduto(){
        listarProduto();
        if (Produto.listaProdutos.size() != 0){
            int id = view.pegarIdProduto();
            Produto.listaProdutos.remove(id);
            ArquivoController.escreverArquivo();
            System.out.println("\u001B[32mProduto removido com sucesso\u001B[0m");
        }
    }

    public void pesquisarProduto(){
        String nomeAPesquisar = view.pegarNomeProduto();
        view.listarProdutosPesquisa(nomeAPesquisar);
    }

    public void comprarProdutos(){
        listarProduto();
        view.adicionarProdutosCarrinho();
    }

    public void atualizarListaProdutos(){
        try{
            for (String linha : Arquivo.dadosLidos){
                Map<String, Object> produto = new HashMap<>();
                String[] dados = linha.split(";");
                String nome = dados[0];
                Integer quantidade = Integer.valueOf(dados[1]);
                Double preco = Double.valueOf(dados[2]);
                produto.put("nome", nome);
                produto.put("quantidade", quantidade);
                produto.put("preco", preco);
                Produto.listaProdutos.add(produto);
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException exception){
            System.out.println("\u001B[31mArquivo de Estoque corrompido\u001B[0m");
            System.exit(0);
        }

    }
}
