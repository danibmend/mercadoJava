package screenMetods;

import main.Mercado;
import modelo.Produto;
import screen.ScreenCarrinho;
import screen.ScreenMenu;
import screen.ScreenProdutos;
import utils.ErrorMessage;

public class ScreenComp {


    public static void comprandoProduto(){
        boolean isPresent, flag = false, newFlag = true; // Boolean para verificar se tem coisa no carrinho;

        for (Produto produto : Mercado.getProdutos()) {
            if (ScreenProdutos.getId().equals(Integer.toString(produto.getId()))) {
                flag = true;
                int qtd;
                try {
                    qtd = Mercado.getCarrinho().get(produto); // Checa se o produto está no carrinho e incrementa quantidade.
                    Mercado.getCarrinho().put(produto, ++qtd);
                    System.out.println("\nProduto (" + produto.getNome() + ") adicionado!");
                } catch (NullPointerException e) {
                    // Se o produto for primeiro do carrinho
                    Mercado.getCarrinho().put(produto, 1);
                    System.out.println("\nProduto (" + produto.getNome() + ") adicionado!");
                }

                isPresent = true;

                if (isPresent) {
                    afterComprando();
                } else {
                    System.out.println("Por algum erro no sistema seu produto não foi adicionado, " +
                            "\n porfavor reinicie o sistema e tente fazer o processo novamente.");
                }

            }
        }
        if (flag == false) {
            ErrorMessage.errorMensagem3();
            ScreenProdutos.selecionarProdutos();
        }
    }

    public static void afterComprando(){
        Integer count = 0;
        for (Integer qtdeProduto : Mercado.getCarrinho().values()) {
            count += qtdeProduto;
        }


        System.out.println("\nProdutos no carrinho: " + count);
        System.out.println("\nDeseja adicionar outro produto ao carrinho?");
        System.out.println("\n " +
                "\n| Digite 1 para adicionar mais" +
                "\n| Digite 2 para ir ao carrinho comprar." +
                "\n| Digite 'VOLTAR' para ir ao menu");
        String option = Mercado.getInput().next();

        if (option.equals("1")) {
            ScreenProdutos.selecionarProdutos();
        } else if (option.equals("2")) {
            ScreenCarrinho.verCarrinho();
        } else if (option.toLowerCase().equals("voltar")) {
            ScreenMenu.menu();
        } else {
            ErrorMessage.errorMensagem();
            afterComprando();
        }
    }
}
