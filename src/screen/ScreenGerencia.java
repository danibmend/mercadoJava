package screen;

import modelo.Produto;
import screenMetods.ScreenGe;
import screenMetods.ScreenSenha;
import utils.ErrorMessage;
import main.Mercado;


public class ScreenGerencia {
    public static boolean gerenciarProdutos() { // PEDIR SENHA DE PESSOAL AUTORIZADO PARA GERENCIAR (SENHA 12345)
        if (Mercado.isIsOnline() == false) {
            ScreenSenha.senhaGerencia();
        } else {

            if (Mercado.getProdutos().size() > 0) {
                System.out.println("|=============================================================|");
                System.out.println("|-------------------- GERÊNCIAR PRODUTOS ---------------------|");
                System.out.println("|                                                             |");

                for (Produto produto : Mercado.getProdutos()) {
                    System.out.println("\n" + produto);
                }

                System.out.println("\nVocê possuí " + Mercado.getProdutos().size() + " produtos em estoque" +
                        "\n " +
                        "\nDigite 1 para cadastrar um novo produto," +
                        "\nDigite 2 para remover um produto" +
                        "\nDigite 'VOLTAR' para voltar ao menu."); // COLOCAR UM IFELSE E UM SCANNER DA OPÇÃO

                String opcao = Mercado.getInput().next();
                // ESTÉTICA PURA
                for (int i = 0; i < 10; i++) {
                    System.out.println();
                }
                boolean flag = true;

                while (flag == true) {
                    if (opcao.equals("1")) {
                        Mercado.setIsOnline(true); // RETORNA O BOOLEAN PRO FALSE AI QUANDO ENTRAR DENOVO TERÁ QUE POR SENHA
                        ScreenCadastro.cadastrarProdutos();
                        flag = false;
                    } else if (opcao.equals("2")) {
                        Mercado.setIsOnline(true); // RETORNA O BOOLEAN PRO FALSE AI QUANDO ENTRAR DENOVO TERÁ QUE POR SENHA
                        ScreenRemoverEstoque.removerProdutosEstoque();
                        flag = false;
                    } else if (opcao.toLowerCase().equals("voltar")) {
                        Mercado.setIsOnline(false);
                        ScreenMenu.menu();
                        flag = false;
                    } else {
                        ErrorMessage.errorMensagem();
                        Mercado.setIsOnline(true);
                        ScreenGerencia.gerenciarProdutos();
                    }
                }

            } else {
                ScreenGe.nenhumProduto();
            }


        }
        return false;
    }

}
