package screenMetods;

import main.Mercado;
import screen.ScreenMenu;
import screen.ScreenSair;
import utils.ErrorMessage;


public class ScreenF {
    public static void comprasFeitas(){
        Mercado.getCarrinho().clear();
        System.out.println("|=============================================================|");
        System.out.println("|-------------------    COMPRAS FEITAS! =) -------------------|");
        System.out.println("|                                                             |");

        System.out.println("\nDigite 'VOLTAR' para ir ao menu " +
                "\nDigite  'SAIR' do mercado!");

        String finish = Mercado.getInput().next();
        if (finish.toLowerCase().equals("voltar")) {
            ScreenMenu.menu();
        }else if (finish.toLowerCase().equals("sair")){
            ScreenSair.sair();
        } else{
            ErrorMessage.errorMensagem();
            comprasFeitas();
        }

    }
}
