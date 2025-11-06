import java.util.ArrayList;
import java.util.Scanner;
class Veiculo {
    private static ArrayList<Veiculo> garagem = new ArrayList<>();
    static Scanner inputVeiculo = new Scanner(System.in);

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
        System.out.println();
        
        System.out.println("----- Lista de Veiculos Cadastrado ----");
         if (garagem.isEmpty()) {

            System.out.println("Nemhum veiculo cadastrado");
        
         } else {
            int i = 1;
            for(Veiculo v : garagem) {


                System.out.println(i + "." + v );
                i++;
            }



         }

        //Voltar ao Menu
        System.out.println("\nDigite 0 para voltar ao menu principal");
        System.out.print("==> ");
        int retornoMenu = inputVeiculo.nextInt();
        if (retornoMenu == 0) {
            Concessioanaria.Menu(null, null);
        }
        

        


        

    }

    public static void Cadastrar_Veiculo () {

        System.out.println("\n---- Cadastrar Veículo ----\n");

        System.out.print("Modelo: ");
        String modelo_cadastrado = inputVeiculo.nextLine();

        System.out.print("Marca: ");
        String marca_cadastrado = inputVeiculo.nextLine();    

        System.out.print("Ano: ");
        int ano_cadastrado = inputVeiculo.nextInt();        

        System.out.print("Preço: ");     
        double preco_cadastrado = inputVeiculo.nextDouble();

        inputVeiculo.nextLine();
        
        
        Veiculo veiculo_cadastrado = new Veiculo(modelo_cadastrado, marca_cadastrado, ano_cadastrado, preco_cadastrado);
        garagem.add(veiculo_cadastrado);

        

        System.out.println("\nVeículo " + modelo_cadastrado + " cadastrado com sucesso!");
        System.out.println("Pressione Enter para continuar...");
        inputVeiculo.nextLine(); // Pausa para o usuário ler
        Concessioanaria.Menu(null,null  );


        
    }


   



}
