package screen;

import main.Mercado;
import modelo.Produto;
import screenMetods.ScreenRemoveC;
import utils.ErrorMessage;
import utils.Utils;

import java.util.InputMismatchException;

public class ScreenRemoverCarrinho {
    private static boolean error;

    public static void removerProdutosCarrinho() {


        if (Mercado.getProdutos().size() > 0) {
            System.out.println("|=============================================================|");
            System.out.println("|--------------- REMOVER PRODUTOS DO CARRINHO ----------------|");
            System.out.println("|                                                             |");

            for (Produto produto : Mercado.getCarrinho().keySet()) {
                System.out.println("Produto: " + produto.getNome() + " " + Utils.doubleString(produto.getPreco())
                        + "\nID: " + produto.getId() + "\nQuantidade: " + Mercado.getCarrinho().get(produto));
                System.out.println();
            }
            // ITERAR A HASHMAP PARA COLOCAR A QUANTIDADE DE VALORES (PRODUTO) NO CARRINHO
            Integer count = 0;
            for (Integer qtdeProduto : Mercado.getCarrinho().values()) {
                count += qtdeProduto;
            }
            System.out.println("\n" + count + " produtos no carrinho,\n");

            System.out.println("| Digite o ID do produto que deseja remover," +
                    "\n| Digite 'VOLTAR' para voltar ao menu");

            do {
                error = true;
                try {
                    int removeOption = Mercado.getInput().nextInt(); //1
                    Produto produtoTirar = Mercado.getProdutos().get(removeOption);//1


                        int qtde = Mercado.getCarrinho().get(produtoTirar); // HASHMAP 1
                        if (qtde == 1) { //2
                            Mercado.getCarrinho().remove(produtoTirar);
                        } else {
                            Mercado.getCarrinho().put(produtoTirar, --qtde); //2 , --qtd
                        }
                        // ESTÉTICA PURA
                        for (int i = 0; i < 10; i++) {
                            System.out.println();
                        }
                        System.out.println(produtoTirar.getNome() + " foi removido com sucesso!");
                        ScreenRemoveC.afterRemoveC();



                }catch (InputMismatchException e){
                    Mercado.getInput().nextLine();
                    ScreenMenu.menu();
                    error = false;
                    Mercado.getInput().nextLine();
                }catch (IndexOutOfBoundsException ex){
                    excpTwo();
                }catch (NullPointerException exc){
                    excpTwo();
                }


            } while (error);


        } else {
            ErrorMessage.errorMensagem5();
            ScreenMenu.menu();
        }

    }
    public static void excpTwo(){
        ErrorMessage.errorMensagem3(); // AVISA QUE ESSE ID NAO EXISTE
        removerProdutosCarrinho(); //VOLTA PRO METODO
    }

}