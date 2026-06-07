import java.util.Scanner;


public class Concessioanaria {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        String Password = null;
        String PasswordAgain;
        String User = null;

        while (Boolean.TRUE) {

            System.out.println("---- CADASTRO ----\n");

            // Loop para garantir que o nome de usuário tenha pelo menos 9 caracteres
            while (Boolean.TRUE) {

                System.out.print("User ==> ");
                User = input.nextLine();

                if (User.length() >= 7) {
                    break;
                } else {
                    System.out.println("\nO nome de usuário deve ter pelo menos 7 caracteres. Tente novamente.\n");
                }
            }

            // Loop para garantir que as senhas coincidam
            while (Boolean.TRUE) {

                while (Boolean.TRUE) {

                    System.out.print("Password: ");
                    Password = input.nextLine();
                    if (Password.length() >= 8) {
                        break;
                    } else {
                        System.out.println("\nA senha deve ter pelo menos 8 caracteres. Tente novamente.\n");
                    }

                }
                System.out.print("Password Again: ");
                PasswordAgain = input.nextLine();

                if (Password.equals(PasswordAgain)) {
                    System.out.println("\nCadastro realizado com sucesso!\n");
                    break;
                } else {
                    System.out.println("\nAs senhas não coincidem. Tente novamente.\n");

                }

            }

            break;

        }
        Menu(User, Password);

        input.close();

    }


    // Método de menu principal
    public static void Menu(String UserMenu, String PasswordMenu) {

    System.out.printf("\n---- MENU PRINCIPAL || BEM VINDO %s  ----\n\n", UserMenu == null ? "" : UserMenu);

    System.out.println("1 - Gerenciamento de Veículos");
    System.out.println("2 - Gerenciamento de Usuario");
    System.out.println("3 - Sair");
    System.out.print("\n==>  ");
    int escolha = input.nextInt();
    input.nextLine(); // consumir newline restante

        //Switch Menu Principal
        switch (escolha) {

            case 1:
                System.out.println("\n---- Gerenciamento de Veículos ----\n");
                System.out.println("1 - Listar Veículos");
                System.out.println("2 - Cadastrar Veículo");
                System.out.println("3 - Vender Veículo");
                System.out.println("4 - Editar Veiculo");
                System.out.print("5 - Voltar ao Menu Principal\n");

                System.out.print("\n==>  ");
                int escolhaVeiculo = input.nextInt();

                //Switch Menu Veículos
                switch (escolhaVeiculo) {
                    case 1:
                        Veiculos.Listar_Veiculos();
                        break;
                    case 2:
                        Veiculos.Cadastrar_Veiculo();
                        break;
                    case 3:
                        Veiculos.Vender_Veiculo();
                        break;
                    case 4:
                        Veiculos.Editar_Veiculo();
                        break;
                    case 5:
                        Menu(UserMenu, PasswordMenu);
                        break;
                    
                    default:
                        System.out.println("\nOpção inválida. Tente novamente.\n");
                        Menu(UserMenu, PasswordMenu);
                        break;

                }
                // evitar fall-through
                break;

            case 2:
                System.out.println("\n---- Gerenciador de Usuarios ----\n");
                System.out.println("1 - Listar Usuários");
                System.out.println("2 - Cadastrar Usuário");
                System.out.println("3 - Inativar Usuário");
                System.out.println("4 - Editar Usuário");
                System.out.println("5 - Voltar ao Menu Principal");
                System.out.print("\n==>  ");
                int escolhaUsuario = input.nextInt();
                input.nextLine(); // consumir newline

                switch (escolhaUsuario) {
                    case 1:
                        Usuarios.Listar_Usuarios();
                        break;
                    case 2:
                        Usuarios.Cadastrar_Usuario();
                        break;
                    case 3:
                        Usuarios.Inativar_Usuario();
                        break;
                    case 4:
                        Usuarios.Editar_Usuario();
                        break;
                    case 5:
                        Menu(UserMenu, PasswordMenu);
                        break;
                    default:
                        System.out.println("\nOpção inválida. Tente novamente.\n");
                        Menu(UserMenu, PasswordMenu);
                        break;
                }

                break;

            default:
                System.out.println("\nOpção inválida. Tente novamente.\n");
                Menu(UserMenu, PasswordMenu);
                break;
        }
    }

}


