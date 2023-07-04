package screen;

import modelo.Produto;
import utils.ErrorMessage;
import main.Mercado;


public class ScreenMenu {
    public static void menu() {
        // MENU

        System.out.println();
        System.out.println("|=============================================================|");
        System.out.println("|---------------------- SUPERMERCADOS ------------------------|");
        System.out.println("|---------------------- DANIEL  BMEND ------------------------|");
        System.out.println("|                                                             |");
        System.out.println("|                                                             |");
        System.out.println("|        Selecione o número da ação que deseja realizar       |");
        System.out.println("|                                                             |");
        System.out.println("|                         FUNCIONARIOS                        |");
        System.out.println("|       1- CADASTRAR           |         2- GERENCIR          |");
        System.out.println("|                                                             |");
        System.out.println("|                          CLIENTES                           |");
        System.out.println("|       3- NOSSOS PRODUTOS     |         4- CARRINHO          |");
        System.out.println("|                                                             |");
        System.out.println("|       5- FINALIZAR COMPRA    |         6- SAIR              |");
        System.out.println("|                                                             |");
        System.out.println("|=============================================================|");
        System.out.println();

        System.out.print("DIGITE AQUI O NÚMERO: ");

        String option = Mercado.getInput().next(); // MUDAR PRA DIGITAR APENAS UM NUMERO

        // ESTÉTICA PURA
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }

        switch (option) {
            // AREA DO DONO DO MERCADO
            case "1":
                ScreenCadastro.cadastrarProdutos();
                break;
            case "2":
                ScreenGerencia.gerenciarProdutos();
                // AREA DO CLIENTE
            case "3":
                ScreenProdutos.selecionarProdutos();
                break;
            case "4":
                ScreenCarrinho.verCarrinho();
                break;
            case "5":
                ScreenFinalizar.finalizarCompra();
                break;
            case "6":
                ScreenSair.sair();// PARAR O PROGRAMA.
                break;
            default:
                ErrorMessage.errorMensagem();
                menu();
                break;
        }
    }
}

