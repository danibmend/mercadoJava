package screen;

import main.Mercado;
import modelo.Produto;
import screenMetods.ScreenF;
import utils.ErrorMessage;
import utils.Utils;



public class ScreenFinalizar {
    private static Double valorCompra = 0.00;
    private static Double valorCompraIndivudal = 0.00;

    public static void finalizarCompra() {

        System.out.println("|=============================================================|");
        System.out.println("|--------------------- FINALIZAR COMPRA ----------------------|");
        System.out.println("|                                                             |");
        valorCompra = 0.00;
        for (Produto p : Mercado.getCarrinho().keySet()) {
            int qtd = Mercado.getCarrinho().get(p);

            valorCompraIndivudal = (p.getPreco() * qtd);
            valorCompra += valorCompraIndivudal;
            System.out.println(p.getNome());
            System.out.println("Quantidade: " + qtd);
            System.out.println("Total: " + valorCompraIndivudal);
            System.out.println();
            

        }

        if (Mercado.getCarrinho().size() > 0) {


                System.out.println();
                System.out.println("O valor da sua compra é:" +
                        "\n------------------------");

                System.out.println( Utils.doubleString(valorCompra));

                System.out.println("Para comprar digite 1       |      Para voltar ao menu digite 'VOLTAR'");
                String lastOption = Mercado.getInput().next();
                // ESTÉTICA PURA
                for (int i = 0; i < 10; i++) {
                    System.out.println();
                }


                if (lastOption.toLowerCase().equals("voltar")) {
                    ScreenMenu.menu();

                } else if (lastOption.equals("1")) {
                    ScreenF.comprasFeitas();
                } else {
                    ErrorMessage.errorMensagem();
                    ScreenFinalizar.finalizarCompra();
                }


            } else{
                System.out.println();
                System.out.println("Você não possui nenhum produto no carrinho!" +
                        "\n------------------------");
                System.out.println("Digite 1 para adicionar um produto " +
                        "Digite 'voltar' para voltar ao menu");
                String lastOption = Mercado.getInput().next();
                // ESTÉTICA PURA
                for (int i = 0; i < 10; i++) {
                    System.out.println();
                }


                if (lastOption.toLowerCase().equals("voltar")) {
                    ScreenMenu.menu();
                } else if (lastOption.equals("1")) {
                    ScreenProdutos.selecionarProdutos();
                } else {
                    ErrorMessage.errorMensagem();
                    ScreenFinalizar.finalizarCompra();
                }

            }

    }

}

