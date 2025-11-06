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

        System.out.printf("\n---- MENU || BEM VINDO %s  ----\n\n", UserMenu);

        System.out.println("1 - Cadastrar Veículo");
        System.out.println("2 - Vender Veículo");
        System.out.println("3 - Listar Veículos");
        System.out.println("4 - Gerenciamento de Usuario");
        System.out.println("5 - Sair");
        System.out.print("\n==>  ");
        int acao = input.nextInt();

        switch (acao) {

            case 1:
                Veiculo.Cadastrar_Veiculo();
                
                return;
            case 3:
                Veiculo.VeiculosLista(null);
                return;

            default:
                System.out.println("\nOpção inválida. Tente novamente.\n");
                Menu(UserMenu, PasswordMenu);
                break;
        }
    }

}


