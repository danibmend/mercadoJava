package screenMetods;

import main.Mercado;
import modelo.Produto;
import screen.ScreenMenu;
import utils.ErrorMessage;

import java.util.InputMismatchException;

public class ScreenCad {


    public static void cadastroTelaDois(){
        System.out.println("|------------------------ CADASTRANDO ------------------------|");
        Mercado.getInput().nextLine();
        boolean flag;
       do {
           //flag = true;
           try {
               System.out.print("\n| Digite o nome do produto: ");//O USUARIO IRA DIGITAR O NOME E SERÁ ARMAZENADO NA VARIAVEL nome
               String nome = Mercado.getInput().nextLine();

               System.out.print("| Digite o preço do produto (apenas '0,00' SEM ESPAÇO OU '.'): ");
               Double preco = Mercado.getInput().nextDouble();
               //O USUARIO IRA DIGITAR O VALOR E SERÁ ARMAZENADO NA VARIAVEL preco

               Produto produto = new Produto(nome, preco);//Um objeto da classe PRODUTO será criado
               System.out.printf("\nO produto (%s) foi cadastrado com sucesso!\n", produto.getNome());

               Mercado.getProdutos().add(produto); //O objeto criado será adicionado a arraylist produtos
               cadastroTelaQuatro();
               flag = false;
           } catch (InputMismatchException e) {
               ErrorMessage.errorMensagem6();
               flag = true;
               Mercado.setIsOnline(true);
               Mercado.getInput().nextLine();
           }
       }while (flag);
    }


    public static void cadastroTelaQuatro(){
        System.out.println("| PARA CADASTRAR OUTRO PRODUTO DIGITE 1                       |" +
                         "\n| PARA VOLTAR AO MENU DIGITE 'VOLTAR'                         |");


        String optioninside = Mercado.getInput().next();
        // ESTÉTICA PURA
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }

        if (optioninside.toLowerCase().equals("voltar")) {
            Mercado.setIsOnline(false); // RETORNA O BOOLEAN PRO FALSE AI QUANDO ENTRAR DENOVO TERÁ QUE POR SENHA
            ScreenMenu.menu();
        } else if (optioninside.equals("1")) {
            Mercado.setIsOnline(true);
            ScreenCad.cadastroTelaDois();
        } else {
            ErrorMessage.errorMensagem();
            cadastroTelaQuatro();
        }
    }
}
