package screenMetods;

import main.Mercado;
import screen.ScreenGerencia;
import screen.ScreenMenu;
import screen.ScreenRemoverEstoque;
import utils.ErrorMessage;

public class ScreenRemoveE {
    public static void removidoE(){
        System.out.println("| Produtos em estoque: " + Mercado.getProdutos().size());
        System.out.println("\n| Digite 1 para remover outro produto" +
                "\n| Digite 2 para voltar a gerência" +
                "\n| Digite 'VOLTAR' para voltar ao menu");

        String option = Mercado.getInput().next();

        if (option.equals("1")) {
            Mercado.setIsOnline(true);
            ScreenRemoverEstoque.removerProdutosEstoque();
        } else if (option.equals("2")) {
            Mercado.setIsOnline(true);
            ScreenGerencia.gerenciarProdutos();
        } else if (option.toLowerCase().equals("voltar")) {
            Mercado.setIsOnline(false);
            ScreenMenu.menu();
        } else {
            ErrorMessage.errorMensagem();
            removidoE();
        }
    }
}
