package screenMetods;

import main.Mercado;
import screen.ScreenCadastro;
import screen.ScreenGerencia;
import screen.ScreenMenu;
import utils.ErrorMessage;

public class ScreenSenha {

    // MÉTODO DE LOGIN DO CADASTRO
    public static void senhaCadastro(){
        System.out.println("\n|=============================================================|");
        System.out.println("|---------------------- ACESSO RESTRITO ----------------------|");
        System.out.println("|                                                             |");
        System.out.println("|  DIGITE A SENHA OU DIGITE 'VOLTAR' PARA SAIR                |");
        System.out.println("|  Senha: 12345                                               |");

        String senha = Mercado.getInput().next();

        // ESTÉTICA PURA
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }

        if (senha.equals("12345")) {
            Mercado.setIsOnline(true);
            ScreenCadastro.cadastrarProdutos();
        } else if (senha.equals("voltar")) {
            Mercado.setIsOnline(false); // RETORNA O BOOLEAN PRO FALSE AI QUANDO ENTRAR DENOVO TERÁ QUE POR SENHA
            ScreenMenu.menu();
        } else {
            Mercado.setIsOnline(false);
            ErrorMessage.errorMensagem4();
            senhaCadastro();
        }
    }

    // MÉTODO DE LOGIN DO GERENCIAR
    public static boolean senhaGerencia(){
        System.out.println("\n|=============================================================|");
        System.out.println("|---------------------- ACESSO RESTRITO ----------------------|");
        System.out.println("|                                                             |");
        System.out.println("|  DIGITE A SENHA OU DIGITE 'VOLTAR' PARA SAIR                |");
        System.out.println("|  Senha: 12345                                               |");

        String senha = Mercado.getInput().next();
        // ESTÉTICA PURA
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
        if (senha.equals("12345")) {
            Mercado.setIsOnline(true);
            ScreenGerencia.gerenciarProdutos();
            return false;
        } else if (senha.equals("voltar")) {
            Mercado.setIsOnline(false); // RETORNA O BOOLEAN PRO FALSE AI QUANDO ENTRAR DENOVO TERÁ QUE POR SENHA
            ScreenMenu.menu();
            return false;
        } else {
            Mercado.setIsOnline(false);
            ErrorMessage.errorMensagem4();
            ScreenGerencia.gerenciarProdutos();
        }
        return false;
    }
}
