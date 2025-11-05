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
                    System.out.println("\nCadastro realizado com sucesso!n\n\n");
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

    public static void Menu(String UserMenu, String PasswordMenu) {

        System.out.printf("\n\n---- MENU || BEM VINDO %s  ----\n", UserMenu);

        System.out.println("1 - Cadastrar Veículo");
        System.out.println("2 - Vender Veículo");
        System.out.println("3 - Listar Veículos");
        System.out.println("4 - Sair");
        System.out.print("\n==>: ");
        int acao = input.nextInt();

        switch (acao) {
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

class Veiculo {
    
    String modelo;
    String marca;
    int ano;
    double preco;

    public Veiculo(String modelo, String marca, int ano, double preco) {
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.preco = preco;
    }

    public static void VeiculosLista(String[] args) {

        Veiculo Gol_Volkswagen = new Veiculo("Gol", "Volkswagen", 2020, 55000.00);
        Veiculo Onix_Chevrolet = new Veiculo("Onix", "Chevrolet", 2021, 60000.00);
        Veiculo Fiesta_Ford = new Veiculo("Fiesta", "Ford", 2019, 52000.00);
        Veiculo Ferrari_F8 = new Veiculo("F8", "Ferrari", 2022, 3000000.00);

        System.out.println("\n---- Lista de Veículos ----\n");
        System.out.println("1. " + Gol_Volkswagen.modelo + " - " + Gol_Volkswagen.marca + " - " + Gol_Volkswagen.ano  + " - R$" + Gol_Volkswagen.preco);
        System.out.println("2. " + Onix_Chevrolet.modelo + " - " + Onix_Chevrolet.marca + " - " + Onix_Chevrolet.ano + " - R$" + Onix_Chevrolet.preco);
        System.out.println("3. " + Fiesta_Ford.modelo + " - " + Fiesta_Ford.marca + " - " + Fiesta_Ford.ano + " - R$" + Fiesta_Ford.preco);
        System.out.println("4. " + Ferrari_F8.modelo + " - " + Ferrari_F8.marca + " - " + Ferrari_F8.ano + " - R$"  + Ferrari_F8.preco);

    }

}