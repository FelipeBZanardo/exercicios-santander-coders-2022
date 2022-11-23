package view;

import java.util.Scanner;

public class ArquivoView {
    Scanner scanner = new Scanner(System.in);

    public String pegarOpcaoArquivo(){
        System.out.println("""
                
                1 - Criar novo arquivo de Estoque
                2 - Selecionar arquivo de Estoque
                0 - Encerrar Programa
                """);
        System.out.print("Digite a opção desejada: ");
        return scanner.nextLine();

    }

    public String pegarNomeArquivo(){
        System.out.print("Digite o nome do arquivo.txt: ");
        String nome = scanner.nextLine().trim();
        if (!nome.contains(".txt")){
            nome += ".txt";
        }
        return nome;
    }

    public void encerrarScanner(){
        scanner.close();
    }
}
