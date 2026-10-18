package br.com.senai.concessionaria;

import br.com.senai.concessionaria.util.InputUtil;
import br.com.senai.concessionaria.view.MenuPrincipal;

public class Main {

    public static void main(String[] args) {
        String usuario = realizarCadastroInicial();
        MenuPrincipal.exibir(usuario);
        InputUtil.fechar();
    }

    private static String realizarCadastroInicial() {
        System.out.println("---- CADASTRO ----\n");

        String usuario;
        while (true) {
            usuario = InputUtil.lerString("User ==> ");
            if (usuario.length() >= 7) {
                break;
            }
            System.out.println("\nO nome de usuário deve ter pelo menos 7 caracteres. Tente novamente.\n");
        }

        while (true) {
            String senha;
            while (true) {
                senha = InputUtil.lerString("Password: ");
                if (senha.length() >= 8) {
                    break;
                }
                System.out.println("\nA senha deve ter pelo menos 8 caracteres. Tente novamente.\n");
            }
            String senhaNovamente = InputUtil.lerString("Password Again: ");
            if (senha.equals(senhaNovamente)) {
                System.out.println("\nCadastro realizado com sucesso!\n");
                break;
            }
            System.out.println("\nAs senhas não coincidem. Tente novamente.\n");
        }

        return usuario;
    }
}
