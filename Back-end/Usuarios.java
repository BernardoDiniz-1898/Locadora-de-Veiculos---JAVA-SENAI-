import java.util.ArrayList;
import java.util.Scanner;

public class Usuarios {

    static Scanner inputUsuario = new Scanner(System.in);
    private static ArrayList<Usuarios> listaUsuarios = new ArrayList<>();
    private static ArrayList<Usuarios>listarNovosUsuarios = new ArrayList<>();

    
    String nome;
    String cpf;
    String telefone;  
    String data_ultima_compra;

    public Usuarios(String nome, String cpf, String telefone, String data_ultima_compra) {

        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.data_ultima_compra = data_ultima_compra;
    }

    public static void Listar_Usuarios() {
        
        System.out.println("\n---- Lista de Usuários ----\n");

        Usuarios usuario1 = new Usuarios("", "123.456.789-00", "(11) 91234-5678", "15/06/2024");
        Usuarios usuario2 = new Usuarios("", "987.654.321-00", "(21) 99876-5432", "10/05/2024");
        Usuarios usuario3 = new Usuarios("", "456.789.123-00", "(31) 93456-7890", "20/04/2024");


        System.out.println("1. CPF: " + usuario1.cpf + " - Telefone: " + usuario1.telefone + " - Data Última Compra: " + usuario1.data_ultima_compra);
        System.out.println("2. CPF: " + usuario2.cpf + " - Telefone: " + usuario2.telefone + " - Data Última Compra: " + usuario2.data_ultima_compra);
        System.out.println("3. CPF: " + usuario3.cpf + " - Telefone: " + usuario3.telefone + " - Data Última Compra: " + usuario3.data_ultima_compra);  

        System.out.println("---- Lista de Usuários Cadastrados ----");



    

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

        Usuarios usuario_cadastrado = new Usuarios(nome_cadastrado, cpf_cadastrado, telefone_cadastrado, data_ultima_compra_cadastrado);
        listaUsuarios.add(usuario_cadastrado);

        System.out.println("\nUsuário cadastrado com sucesso!\n");
    }

}
