package screenMetods;

import main.Mercado;
import modelo.Produto;
import screen.*;
import utils.ErrorMessage;
import utils.Utils;

public class ScreenRemoveC {
    public static void afterRemoveC() {
        if (Mercado.getCarrinho().size() > 0) {
            System.out.println();
            System.out.println("|=============================================================|");
            System.out.println("|--------------- REMOVER PRODUTOS DO CARRINHO ----------------|");
            System.out.println("|                                                             |");
            for (Produto produto : Mercado.getCarrinho().keySet()) {
                System.out.println("Produto: " + produto.getNome() + " " + Utils.doubleString(produto.getPreco())
                        + "\nID: " + produto.getId() + "\nQuantidade: " + Mercado.getCarrinho().get(produto));
            }

                System.out.println();
                System.out.println("Digite 1 para comprar");
                System.out.println("Digite 2 para remover outro produto");
                System.out.println("Digite 3 para voltar ao carrinho");
                System.out.println("Digite 'VOLTAR' para voltar ao menu");

                String afterR = Mercado.getInput().next();

                if (afterR.equals("1")) {
                    ScreenFinalizar.finalizarCompra();
                } else if (afterR.equals("2")) {
                    ScreenRemoverCarrinho.removerProdutosCarrinho();
                } else if (afterR.equals("3")) {
                    ScreenCarrinho.verCarrinho();
                } else if (afterR.toLowerCase().equals("voltar")) {
                    ScreenMenu.menu();
                } else {
                    ErrorMessage.errorMensagem();
                    afterRemoveC();
                }

        }else {
            System.out.println();
            System.out.println("|=============================================================|");
            System.out.println("|-------------------  PRODUTOS DO CARRINHO -------------------|");
            System.out.println("|                                                             |");
            System.out.println();
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
                ScreenCarrinho.verCarrinho();
            }
        }
    }
}
