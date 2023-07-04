package screen;

import main.Mercado;
import modelo.Produto;
import screenMetods.ScreenComp;

public class ScreenProdutos {
    private static String id;

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        ScreenProdutos.id = id;
    }

    public static boolean selecionarProdutos() {

        if (Mercado.getProdutos().size() > 0) {
            System.out.println("|=============================================================|");
            System.out.println("|------------------- PRODUTOS DISPONIVEIS --------------------|");
            System.out.println("|                                                             |");

            for (Produto produto : Mercado.getProdutos()) { // Iterar todo tipo de item Produto do nosso Array Produtos
                System.out.println();
                System.out.printf("|%s\n", produto);
            }
            System.out.println();

            Integer firstCount = 0;
            for (Integer qtdeProduto : Mercado.getCarrinho().values()) {
                firstCount += qtdeProduto;
            }
            System.out.println("\nProdutos no carrinho: " + firstCount);

            System.out.println();
            System.out.println("|DIGITE O ID DO PRODUTO PARA COLOCAR NO CARRINHO              |");
            System.out.println("|Digite 'CARRINHO' para ir ao carrinho                        |");
            System.out.println("|Digite 'VOLTAR' para voltar ao menu                          |");
            System.out.println("|Obs: Adicione um de cada vez                                 |");


            id = Mercado.getInput().next(); // O usuario irá digitar o ID do produto para colocar no carrinho


            // ESTÉTICA PURA
            for (int i = 0; i < 10; i++) {
                System.out.println();
            }

            if (id.toLowerCase().equals("voltar")) {
                ScreenMenu.menu();
            } else if (id.toLowerCase().equals("carrinho")) {
                ScreenCarrinho.verCarrinho();
            } else {
                ScreenComp.comprandoProduto();
            }

        } else {
            System.out.println("Não existem produtos cadastrados!");
            ScreenMenu.menu();
        }
        return false;
    }
}
