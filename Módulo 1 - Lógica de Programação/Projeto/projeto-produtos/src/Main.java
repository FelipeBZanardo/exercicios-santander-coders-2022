import controller.ArquivoController;
import controller.ProdutoController;

public class Main {
    public static void main(String[] args) {
        ProdutoController produtoController = new ProdutoController();
        ArquivoController arquivoController = new ArquivoController();
        arquivoController.menuArquivo();
        arquivoController.lerArquivo();
        produtoController.atualizarListaProdutos();
        produtoController.menu();
    }
}
