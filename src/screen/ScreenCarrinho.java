package screen;

import main.Mercado;
import modelo.Produto;
import utils.ErrorMessage;
import utils.Utils;

public class ScreenCarrinho {

    public static void verCarrinho() {

            System.out.println("|=============================================================|");
            System.out.println("|------------------- CARRINHO DE COMPRAS ---------------------|");
            System.out.println("|                                                             |");
            System.out.println();
            if (Mercado.getCarrinho().size() > 0) {
                for (Produto produto : Mercado.getCarrinho().keySet()) {
                    System.out.println("Produto: " + produto.getNome() + " " + Utils.doubleString(produto.getPreco())
                            + "\nQuantidade: " + Mercado.getCarrinho().get(produto));
                    System.out.println();
                }
                System.out.println();
                System.out.println("Verifique os itens do seu carrinho, " +
                        "\n- Digite 1 para comprar" +
                        "\n- Digite 2 para remover algo" +
                        "\n- Digite 3 para adicionar algo" +
                        "\n- Digite 'VOLTAR' para voltar ao menu");
                String option = Mercado.getInput().next();
                // ESTÉTICA PURA
                for (int i = 0; i < 10; i++) {
                    System.out.println();
                }


                if (option.equals("voltar")) {
                    ScreenMenu.menu();
                } else if (option.equals("1")) {
                    ScreenFinalizar.finalizarCompra();
                } else if (option.equals("2")) {
                    ScreenRemoverCarrinho.removerProdutosCarrinho();
                } else if (option.toLowerCase().equals("3")) {
                    ScreenProdutos.selecionarProdutos();
                } else {
                    ErrorMessage.errorMensagem();
                    verCarrinho();
                }

            } else {
                System.out.println("Seu carrinho está vazio!" +
                        "\nDigite 1 para adicionar produtos" +
                        "\nDigite 'VOLTAR' para voltar ao menu");
                String option = Mercado.getInput().next();
                // ESTÉTICA PURA
                for (int i = 0; i < 10; i++) {
                    System.out.println();
                }
                if (option.equals("1")) {
                    ScreenProdutos.selecionarProdutos();
                } else if (option.toLowerCase().equals("voltar")) {
                    ScreenMenu.menu();
                } else {
                    ErrorMessage.errorMensagem();
                    verCarrinho();
                }

            }


    }
}
