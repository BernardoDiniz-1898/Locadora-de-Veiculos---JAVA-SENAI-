package br.com.senai.concessionaria.view;

import br.com.senai.concessionaria.util.InputUtil;

public class MenuPrincipal {

    public static void exibir(String usuario) {
        while (true) {
            String nomeUsuario = usuario == null || usuario.isEmpty() ? "" : usuario;
            System.out.printf("\n---- MENU PRINCIPAL || BEM VINDO %s ----\n\n", nomeUsuario);
            System.out.println("1 - Gerenciamento de Veículos");
            System.out.println("2 - Gerenciamento de Usuários");
            System.out.println("3 - Sair");

            int opcao = InputUtil.lerInt("\n==> ");
            switch (opcao) {
                case 1:
                    VeiculoView.exibirMenu();
                    break;
                case 2:
                    UsuarioView.exibirMenu();
                    break;
                case 3:
                    System.out.println("\nSaindo do sistema...");
                    return;
                default:
                    System.out.println("\nOpção inválida. Tente novamente.\n");
            }
        }
    }
}
