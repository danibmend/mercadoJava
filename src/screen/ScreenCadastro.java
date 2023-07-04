package screen;

import main.Mercado;
import screenMetods.ScreenCad;
import screenMetods.ScreenSenha;
import utils.ErrorMessage;


public class ScreenCadastro {

    public static void cadastrarProdutos() { // PEDIR SENHA DE PESSOAL AUTORIZADO PARA CADASTRAR (SENHA 12345)
        if (Mercado.isIsOnline() == false) {
            ScreenSenha.senhaCadastro();
        } else {
            System.out.println("\n|=============================================================|");
            System.out.println("|------------------- CADASTRO DE PRODUTOS --------------------|");
            System.out.println("|                                                             |");
            System.out.println();
            System.out.println("|          VOCÊ ESTÁ NA ÁREA DE CADASTRO DE PRODUTOS          |");
            System.out.println("|                                                             |");
            System.out.println("| PARA CADASTRAR DIGITE 1                                     |" +
                               "\n| PARA VOLTAR AO MENU DIGITE 'VOLTAR'                           |");
            System.out.println();
            System.out.print("|DIGITE AQUI A OPÇÃO: ");

            String option = Mercado.getInput().next();
            // ESTÉTICA PURA
            for (int i = 0; i < 10; i++) {
                System.out.println();
            }

            if (option.equals("1")){
                ScreenCad.cadastroTelaDois();
            } else if (option.toLowerCase().equals("voltar")){
                Mercado.setIsOnline(false); // RETORNA O BOOLEAN PRO FALSE AI QUANDO ENTRAR DENOVO TERÁ QUE POR SENHA
                ScreenMenu.menu();
            } else {
                ErrorMessage.errorMensagem();
                Mercado.setIsOnline(true);
                ScreenCadastro.cadastrarProdutos();
            }

        }
    }

}
