package br.com.senai.concessionaria.view;

import br.com.senai.concessionaria.model.Usuario;
import br.com.senai.concessionaria.service.UsuarioService;
import br.com.senai.concessionaria.util.InputUtil;

import java.util.List;

public class UsuarioView {

    public static void exibirMenu() {
        while (true) {
            System.out.println("\n---- Gerenciamento de Usuários ----\n");
            System.out.println("1 - Listar Usuários");
            System.out.println("2 - Cadastrar Usuário");
            System.out.println("3 - Inativar Usuário");
            System.out.println("4 - Editar Usuário");
            System.out.println("5 - Voltar ao Menu Principal");

            int opcao = InputUtil.lerInt("\n==> ");
            switch (opcao) {
                case 1:
                    listarUsuarios();
                    break;
                case 2:
                    cadastrarUsuario();
                    break;
                case 3:
                    inativarUsuario();
                    break;
                case 4:
                    editarUsuario();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("\nOpção inválida. Tente novamente.\n");
            }
        }
    }

    private static void listarUsuarios() {
        List<Usuario> usuarios = UsuarioService.listarUsuarios();
        List<Usuario> usuariosNovos = UsuarioService.listarUsuariosNovos();

        System.out.println("\n---- Lista de Usuários ----\n");
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
        } else {
            for (Usuario u : usuarios) {
                System.out.println(u);
            }
        }

        System.out.println("\n\n---- Lista de Usuários Cadastrados Recentemente ----");
        if (usuariosNovos.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado recentemente.");
        } else {
            for (Usuario u : usuariosNovos) {
                System.out.println(u);
            }
        }
        InputUtil.pressionarEnter();
    }

    private static void cadastrarUsuario() {
        System.out.println("\n---- Cadastrar Usuário ----\n");
        String nome = InputUtil.lerString("Nome: ");
        String cpf = InputUtil.lerString("CPF: ");
        String telefone = InputUtil.lerString("Telefone: ");
        String dataUltimaCompra = InputUtil.lerString("Data Última Compra (DD/MM/AAAA): ");

        UsuarioService.cadastrarUsuario(nome, cpf, telefone, dataUltimaCompra);
        System.out.println("\nUsuário cadastrado com sucesso!");
        InputUtil.pressionarEnter();
    }

    private static void inativarUsuario() {
        System.out.println("\n---- Inativar Usuário ----\n");
        String cpf = InputUtil.lerString("Digite o CPF do usuário que deseja inativar: ");

        boolean sucesso = UsuarioService.inativarUsuario(cpf);
        if (sucesso) {
            System.out.println("\nUsuário inativado com sucesso!");
        } else {
            System.out.println("\nUsuário não encontrado!");
        }
        InputUtil.pressionarEnter();
    }

    private static void editarUsuario() {
        System.out.println("\n---- Editar informações de Usuário ----\n");
        String cpf = InputUtil.lerString("Digite o CPF do usuário que deseja editar: ");

        if (!UsuarioService.existeUsuario(cpf)) {
            System.out.println("\nUsuário não encontrado!");
            InputUtil.pressionarEnter();
            return;
        }

        System.out.println("\nQual atributo do usuário deseja alterar?");
        System.out.println("1 - Nome");
        System.out.println("2 - Telefone");
        System.out.println("3 - Data da Última Compra");
        System.out.println("4 - CPF");
        int opcao = InputUtil.lerInt("\n==> ");

        boolean sucesso = false;
        switch (opcao) {
            case 1:
                String novoNome = InputUtil.lerString("Digite o novo nome: ");
                sucesso = UsuarioService.editarNome(cpf, novoNome);
                if (sucesso) {
                    System.out.println("\nNome alterado com sucesso!");
                } else {
                    System.out.println("\nErro ao alterar o nome!");
                }
                break;
            case 2:
                String novoTelefone = InputUtil.lerString("Digite o novo telefone: ");
                sucesso = UsuarioService.editarTelefone(cpf, novoTelefone);
                if (sucesso) {
                    System.out.println("\nTelefone alterado com sucesso!");
                } else {
                    System.out.println("\nErro ao alterar o telefone!");
                }
                break;
            case 3:
                String novaData = InputUtil.lerString("Digite a nova data da última compra (DD/MM/AAAA): ");
                sucesso = UsuarioService.editarDataUltimaCompra(cpf, novaData);
                if (sucesso) {
                    System.out.println("\nData da última compra alterada com sucesso!");
                } else {
                    System.out.println("\nErro ao alterar a data!");
                }
                break;
            case 4:
                String novoCpf = InputUtil.lerString("Digite o novo CPF: ");
                sucesso = UsuarioService.editarCpf(cpf, novoCpf);
                if (sucesso) {
                    System.out.println("\nCPF alterado com sucesso!");
                } else {
                    System.out.println("\nErro ao alterar o CPF!");
                }
                break;
            default:
                System.out.println("\nOpção inválida! Retornando ao menu.");
                return;
        }
        InputUtil.pressionarEnter();
    }
}
