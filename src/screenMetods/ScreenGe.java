package screenMetods;

import main.Mercado;
import screen.ScreenMenu;
import utils.ErrorMessage;

public class ScreenGe {
    public static void nenhumProduto(){
        System.out.println("Nenhum produto cadastrado, porfavor digite 'VOLTAR' para voltar.");
        String menu = Mercado.getInput().next();
        // ESTÉTICA PURA
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }

        if (menu.toLowerCase().equals("voltar")) {
            ScreenMenu.menu();
        } else {
            ErrorMessage.errorMensagem();
            nenhumProduto();
        }
    }
}
