import java.util.ArrayList;
import java.util.Scanner;

public class Usuarios {

    static int indexUsuario = 0;
    static Scanner inputUsuario = new Scanner(System.in);
    private static ArrayList<Usuarios> listaUsuarios = new ArrayList<>();
    private static ArrayList<Usuarios>listarNovosUsuarios = new ArrayList<>();

    String status_usuario;
    String nome;
    String cpf;
    String telefone;  
    String data_ultima_compra;

    public Usuarios(String nome, String cpf, String telefone, String data_ultima_compra, String status_usuarios) {

        this.status_usuario = status_usuario;
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
            System.out.println("Nome: " + usuario.nome +  "CPF: " + usuario.cpf + " - Telefone: " + usuario.telefone + " - Data Última Compra: " + usuario.data_ultima_compra + "Status: " + usuario.status_usuario);
        }





        System.out.println("---- Lista de Usuários Cadastrados ----");

        if(listarNovosUsuarios.isEmpty()) {

            System.out.println("\n---- Nenhum usuario cadastrado recentemente! ----");

        } else{

            for(Usuarios u : listarNovosUsuarios){

                System.out.println("Nome: "+ u.nome + "CPF:"+ u.cpf + " - Telefone: " + u.telefone + " - Data Última Compra: " + u.data_ultima_compra );
              
            }

        }

    }




    public static void Criar_Usuario() {
        
        System.out.println("\n---- Lista de Usuários ----\n");

        Usuarios usuario1 = new Usuarios("João" , "CPF: 123.456.789-00", "(11) 91234-5678", "15/06/2024","Ativo");
        Usuarios usuario2 = new Usuarios("Fabio ", "CPF: 987.654.321-00", "(21) 99876-5432", "10/05/2024","Ativo");
        Usuarios usuario3 = new Usuarios("H.Foud CU", "CPF: 456.789.123-00", "(31) 93456-7890", "20/04/2024","Ativo");

        listaUsuarios.add(usuario1);
        listaUsuarios.add(usuario2);
        listaUsuarios.add(usuario3);

    }

    public static void Cadastrar_Usuario() {
        
        System.out.println("\n---- Cadastrar Usuário ----\n");

        System.out.print("Nome: ");
        String nome_cadastrado = inputUsuario.nextLine();

        System.out.print("CPF: ");
        String cpf_cadastrado = inputUsuario.nextLine();

        System.out.print("Telefone: ");
        String telefone_cadastrado = inputUsuario.nextLine();

        System.out.print("Data Última Compra (DD/MM/AAAA): ");
        String data_ultima_compra_cadastrado = inputUsuario.nextLine();

        Usuarios usuario_cadastrado = new Usuarios(nome_cadastrado, cpf_cadastrado, telefone_cadastrado, data_ultima_compra_cadastrado,"Ativo");
        listarNovosUsuarios.add(usuario_cadastrado);

        System.out.println("\nUsuário cadastrado com sucesso!\n");
    }



    public static void Editar_Usuario() {

        System.out.println("\n---- Editar informações de Usuario ----\n");

        System.out.println("Digite o CPF do usuario que deseja ser editar:");
        System.out.print("==> ");
        int Cpf_usuario= inputUsuario.nextInt();

        if(Cpf_usuario == indexUsuario) {


            
        }
        







    }

}
