package screen;

import main.Mercado;
import modelo.Produto;
import screenMetods.ScreenRemoveE;
import utils.ErrorMessage;

import java.util.InputMismatchException;

public class ScreenRemoverEstoque {
    private static boolean firtError;
    public static void removerProdutosEstoque() {

        if (Mercado.getProdutos().size() > 0) {
            System.out.println("|=============================================================|");
            System.out.println("|---------------- REMOVER PRODUTOS DO ESTOQUE ----------------|");
            System.out.println("|                                                             |");
            for (Produto produto : Mercado.getProdutos()) {
                System.out.println("\n" + produto);
            }
            System.out.println("\n" + Mercado.getProdutos().size() + " produtos em estoque,\n");
            System.out.println("| Digite o ID do produto que deseja remover, ou 'VOLTAR' para voltar");

            do {
                firtError = true;
                try {
                    int removeOption = Mercado.getInput().nextInt();
                    Produto removeProduto = Mercado.getProdutos().get(removeOption);


                            Mercado.getProdutos().remove(removeProduto);
                            // ESTÉTICA PURA
                            for (int i = 0; i < 10; i++) {
                                System.out.println();
                            }
                            System.out.println(removeProduto.getNome() + " foi removido com sucesso!");
                            ScreenRemoveE.removidoE();


                }catch (InputMismatchException e){
                    Mercado.setIsOnline(false);
                    Mercado.getInput().nextLine();
                    ScreenMenu.menu();
                    firtError = false;
                    Mercado.getInput().nextLine();
                }catch (IndexOutOfBoundsException ex){
                    ErrorMessage.errorMensagem3();
                    Mercado.getInput().nextLine();
                    removerProdutosEstoque();
                }
            }while (firtError);

        } else {
            ErrorMessage.errorMensagem5();
            ScreenMenu.menu();
        }

    }
}
