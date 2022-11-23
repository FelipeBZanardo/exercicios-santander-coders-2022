package controller;

import model.Arquivo;
import model.Produto;
import view.ArquivoView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArquivoController {

    ArquivoView arquivoView;

    public void menuArquivo(){
        arquivoView = new ArquivoView();

        boolean continuar = true;
        while(continuar){
            switch (arquivoView.pegarOpcaoArquivo()){
                case "1" -> continuar = criarArquivo();
                case "2" -> continuar = selecionarArquivo();
                case "0" -> {
                    arquivoView.encerrarScanner();
                    continuar = false;
                    System.exit(0);
                }
                default -> System.out.println("\u001B[31mOpção inválida\u001B[0m");
            }
        }
    }

    public boolean criarArquivo(){
        String nome = arquivoView.pegarNomeArquivo();
        try{
            Files.createFile(Path.of(nome));
            Arquivo.path = Path.of(nome);
            System.out.println("\u001B[32mArquivo criado com sucesso\u001B[0m");
            return false;
        } catch (IOException exception){
            System.out.println("\u001B[31mArquivo inválido\u001B[0m");
            return true;
        }
    }

    public boolean selecionarArquivo(){

        String nome = arquivoView.pegarNomeArquivo();
        if (Files.exists(Path.of(nome))){
            Arquivo.path = Path.of(nome);
            System.out.println("\u001B[32mArquivo selecionado com sucesso!\u001B[0m");
            return false;
        } else{
            System.out.println("\u001B[31mEsse arquivo não existe!\u001B[0m");
            return true;
        }
    }

    public void lerArquivo(){
        try{
            List<String> dadosLidos = new ArrayList<>();
            dadosLidos = Files.readAllLines(Arquivo.path);
            Arquivo.dadosLidos = dadosLidos;
            System.out.println("\u001B[32mArquivo lido com sucesso\u001B[0m");
        } catch (IOException exception){
            System.out.println("\u001B[31mArquivo danificado\u001B[0m");
        }
    }

    public static void escreverArquivo(){
        List<String> dadosAEscrever = new ArrayList<>();
        for (Map<String, Object> produto : Produto.listaProdutos){
            String linha = produto.get("nome") + ";" +
                    produto.get("quantidade") + ";" + produto.get("preco");
            dadosAEscrever.add(linha);
        }

        try {
            Files.write(Arquivo.path, dadosAEscrever);
            System.out.println("\u001B[32mArquivo de estoque atualizado\u001B[0m");
        } catch (IOException exception){
            System.out.println("\u001B[31mArquivo corrompido!\u001B[0m");
        }
    }


}
