import java.util.ArrayList;
import java.util.Scanner;


public class Usuarios {

    static int indexUsuario = 0;
    static Scanner inputUsuario = new Scanner(System.in);
    private static ArrayList<Usuarios> listaUsuarios = new ArrayList<>();
    private static ArrayList<Usuarios> listarNovosUsuarios = new ArrayList<>();

    String status_usuario;
    String nome;
    int cpf;
    String telefone;
    String data_ultima_compra;

    public Usuarios(String nome, int cpf, String telefone, String data_ultima_compra, String status_usuarios) {
        this.status_usuario = status_usuarios;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.data_ultima_compra = data_ultima_compra;
    }

    public static void Listar_Usuarios() {
        if (listaUsuarios.isEmpty()) {
            Criar_Usuario();
        }

        System.out.println("\n---- Lista de Usuários ----\n");

        for (Usuarios usuario : listaUsuarios) {
            System.out.println(
                    "Nome: " + usuario.nome + "CPF: " + usuario.cpf + " - Telefone: " + usuario.telefone
                            + " - Data Última Compra: " + usuario.data_ultima_compra + "Status: " + usuario.status_usuario);
        }

        System.out.println("\n\n---- Lista de Usuários Cadastrados ----");

        if (listarNovosUsuarios.isEmpty()) {
            System.out.println("\n\n---- Nenhum usuario cadastrado recentemente! ----");
        } else {
            for (Usuarios u : listarNovosUsuarios) {
                System.out.println("Nome: " + u.nome + "CPF:" + u.cpf + " - Telefone: " + u.telefone
                        + " - Data Última Compra: " + u.data_ultima_compra);
            }
        }

        System.out.println("\nPressione Enter para voltar ao Menu Principal...");
        System.out.print("==> ");
        inputUsuario.nextLine();
        Concessioanaria.Menu(null, null);




    }

    public static void Criar_Usuario() {
        System.out.println("\n---- Lista de Usuários ----\n");

        Usuarios usuario1 = new Usuarios("João", 1, "(11) 91234-5678", "15/06/2024", "Ativo");
        Usuarios usuario2 = new Usuarios("Fabio ", 2, "(21) 99876-5432", "10/05/2024", "Ativo");
        Usuarios usuario3 = new Usuarios("H.Foud CU", 3, "(31) 93456-7890", "20/04/2024", "Ativo");

        listaUsuarios.add(usuario1);
        listaUsuarios.add(usuario2);
        listaUsuarios.add(usuario3);
    }

    public static void Cadastrar_Usuario() {
        System.out.println("\n---- Cadastrar Usuário ----\n");

        System.out.print("Nome: ");
        String nome_cadastrado = inputUsuario.nextLine();

        System.out.print("CPF: ");
        int cpf_cadastrado = inputUsuario.nextInt();

        System.out.print("Telefone: ");
        String telefone_cadastrado = inputUsuario.nextLine();

        System.out.print("Data Última Compra (DD/MM/AAAA): ");
        String data_ultima_compra_cadastrado = inputUsuario.nextLine();

        Usuarios usuario_cadastrado = new Usuarios(nome_cadastrado, cpf_cadastrado, telefone_cadastrado, data_ultima_compra_cadastrado, "Ativo");
        listarNovosUsuarios.add(usuario_cadastrado);

        System.out.println("\nUsuário cadastrado com sucesso!\n");

        System.out.println("\nPressione Enter para voltar ao Menu Principal...");
        System.out.print("==> ");
        inputUsuario.nextLine();
        Concessioanaria.Menu(null, null);

    }

    public static void Inativar_Usuario() {


        System.out.println("\n---- Inativar Usuário ----\n");

        System.out.println("Digite o CPF do usuario que deseja inativar:");
        System.out.print("==> ");
        int Cpf_usuario = inputUsuario.nextInt();

        for (Usuarios u : listaUsuarios) {
            if (u.cpf == Cpf_usuario) {
                u.status_usuario = "Inativo";
                System.out.println("\nUsuário inativado com sucesso!\n");
                return;
            }
        }

        for (Usuarios u : listarNovosUsuarios) {
            if (u.cpf == Cpf_usuario) {
                u.status_usuario = "Inativo";
                System.out.println("\nUsuário inativado com sucesso!\n");
                return;
            }
        }

        System.out.println("\nUsuário não encontrado!\n");

    }

    public static void Editar_Usuario() {
        boolean foi = false;
        System.out.println("\n---- Editar informações de Usuario ----\n");

        System.out.println("Digite o CPF do usuario que deseja ser editar:");
        System.out.print("==> ");
        int Cpf_usuario = inputUsuario.nextInt();

        for (Usuarios u : listaUsuarios) {
            if (u.cpf == Cpf_usuario) {
                indexUsuario = u.cpf;
            }
        }

        for (Usuarios u : listarNovosUsuarios) {
            if (u.cpf == Cpf_usuario) {
                indexUsuario = u.cpf;
            }
        }

        if (Cpf_usuario == indexUsuario) {
            System.out.println("\nQual atributo do Usuario deseja alterar?");
            System.out.println("1 - Nome ");
            System.out.println("2 - Telefone ");
            System.out.println("3 - Ultima Compra ");
            System.out.println("4 - Cadastro de Pessoa Fisica\n");
            System.out.print("==> \n");
            int escolha = inputUsuario.nextInt();

            switch (escolha) {
                case 1:
                    inputUsuario.nextLine();
                    System.out.print("Digie o novo Nome:");
                    String new_name = inputUsuario.nextLine();

                    for (Usuarios u : listaUsuarios) {
                        if (u.cpf == Cpf_usuario) {
                            u.nome = new_name;
                            foi = true;
                        }
                    }

                    for (Usuarios u : listarNovosUsuarios) {
                        if (u.cpf == Cpf_usuario) {
                            u.nome = new_name;
                            foi = true;
                        }
                    }

                    if (foi) {
                        System.out.println("\nNome alterado com sucesso!\n");
                    } else {
                        System.out.println("\nErro ao alterar o Nome!\n");
                    }

                    System.out.println("Pressione Enter para continuar...");
                    inputUsuario.nextLine(); // Pausa para o usuário ler
                    Concessioanaria.Menu(null, null);
                    break;

                case 2:
                    inputUsuario.nextLine();
                    System.out.print("Digie o novo Telefone:");
                    String new_telefone = inputUsuario.nextLine();

                    for (Usuarios u : listaUsuarios) {
                        if (u.cpf == Cpf_usuario) {
                            u.telefone = new_telefone;
                            foi = true;
                        }
                    }

                    for (Usuarios u : listarNovosUsuarios) {
                        if (u.cpf == Cpf_usuario) {
                            u.telefone = new_telefone;
                            foi = true;
                        }
                    }

                    if (foi) {
                        System.out.println("\nTelefone alterado com sucesso!\n");
                    } else {
                        System.out.println("\nErro ao alterar o Telefone!\n");
                    }

                    System.out.println("Pressione Enter para continuar...");
                    inputUsuario.nextLine(); // Pausa para o usuário ler
                    Concessioanaria.Menu(null, null);
                    break;

                case 3:
                    inputUsuario.nextLine();
                    System.out.print("Digie a nova Data da Ultima Compra (DD/MM/AAAA):");
                    String new_data_ultima_compra = inputUsuario.nextLine();
                    for (Usuarios u : listaUsuarios) {
                        if (u.cpf == Cpf_usuario) {
                            u.data_ultima_compra = new_data_ultima_compra;
                            foi = true;
                        }
                    }

                    for (Usuarios u : listarNovosUsuarios) {
                        if (u.cpf == Cpf_usuario) {
                            u.data_ultima_compra = new_data_ultima_compra;
                            foi = true;
                        }
                    }

                    if (foi) {
                        System.out.println("\nData da Ultima Compra alterada com sucesso!\n");
                    } else {
                        System.out.println("\nErro ao alterar a Data da Ultima Compra!\n");
                    }

                    System.out.println("Pressione Enter para continuar...");
                    inputUsuario.nextLine(); // Pausa para o usuário ler
                    Concessioanaria.Menu(null, null);
                    break;

                case 4:
                    inputUsuario.nextLine();
                    System.out.println("Digite o novo CPF:");
                    int new_cpf = inputUsuario.nextInt();
                    for (Usuarios u : listaUsuarios) {
                        if (u.cpf == Cpf_usuario) {
                            u.cpf = new_cpf;
                            foi = true;
                        }
                    }

                    for (Usuarios u : listarNovosUsuarios) {
                        if (u.cpf == Cpf_usuario) {
                            u.cpf = new_cpf;
                            foi = true;
                        }
                    }

                    if (foi) {
                        System.out.println("\nCPF alterado com sucesso!\n");
                    } else {
                        System.out.println("\nErro ao alterar o CPF!\n");
                    }

                    System.out.println("Pressione Enter para continuar...");
                    inputUsuario.nextLine(); // Pausa para o usuário ler
                    Concessioanaria.Menu(null, null);
                    break;

                default:
                    System.out.println("\nOpção inválida! Retornando ao menu principal.\n");
                    Concessioanaria.Menu(null, null);
                    break;
            }
        }
    }
}

