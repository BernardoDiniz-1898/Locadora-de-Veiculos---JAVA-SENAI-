import java.util.ArrayList;
import java.util.Scanner;

class Veiculos {
    
    
    static int indexVeiculo = 0;
    private static ArrayList<Veiculos> garagem_cadastrados = new ArrayList<>();
    private static ArrayList<Veiculos> garagem_estoque = new ArrayList<>();
    static Scanner inputVeiculo = new Scanner(System.in);

    String modelo;
    String marca;
    int ano;
    double preco;
    String status;
    int placa;

    public Veiculos(int primaryKey,String modelo, String marca, int ano, double preco, String status) {

        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.preco = preco;
        this.status = status;
        this.placa = primaryKey;

    }



    public static void Listar_Veiculos(){

        if(garagem_estoque.isEmpty()){

            Criar_Veiculos();
            
        }

         System.out.println("\n---- Lista de Veículos ----\n");
        for(Veiculos v : garagem_estoque){

            System.out.println("Placa: " + v.placa + " - "+ v.modelo + " - " + v.marca + " - " + v.ano + " - R$" + v.preco  +" Status:  "+ v.status);
        }

        System.out.println("----- Lista de Veiculos Cadastrado ----");

         if (garagem_cadastrados.isEmpty()) {

            System.out.println("\n---- Nemhum veiculo cadastrado ----\n  ");
        
         } else {
            
            for(Veiculos v : garagem_cadastrados) {
   
                System.out.println("Placa: " + v.placa + " - "+ v.modelo + " - " + v.marca + " - " + v.ano + " - R$" + v.preco  +" Status:  "+ v.status);
                
            }


    }

    System.out.println("\nPressione Enter para voltar ao Menu Principal...");
    System.out.print("==> ");
    inputVeiculo.nextLine();
    Concessioanaria.Menu(null, null);

}

    public static void Criar_Veiculos() {

        Veiculos Gol_Volkswagen = new Veiculos(1,"Gol", "Volkswagen", 2020, 55000.00,"Disponivel");
        Veiculos Onix_Chevrolet = new Veiculos(2,"Onix", "Chevrolet", 2021, 60000.00, "Vendido");
        Veiculos Fiesta_Ford = new Veiculos(3,"Fiesta", "Ford", 2019, 52000.00, "Vendido");
        Veiculos Ferrari_F8 = new Veiculos(4,"F8", "Ferrari", 2022, 3000000.00, "Vendido");
        
        garagem_estoque.add(Gol_Volkswagen);
        garagem_estoque.add(Onix_Chevrolet);
        garagem_estoque.add(Fiesta_Ford);
        garagem_estoque.add(Ferrari_F8);
    }

   
      
        
    
    

    public static void Cadastrar_Veiculo () {

        System.out.println("\n---- Cadastrar Veículo ----\n");

        System.out.print("Modelo: ");
        String modelo_cadastrado = inputVeiculo.nextLine();

        System.out.println();

        System.out.print("Marca: ");
        String marca_cadastrado = inputVeiculo.nextLine();    

        System.out.print("Ano: ");
        int ano_cadastrado = inputVeiculo.nextInt();        

        System.out.print("Preço: ");     
        double preco_cadastrado = inputVeiculo.nextDouble();


        

        inputVeiculo.nextLine();
        
        
        Veiculos veiculo_cadastrado = new Veiculos(indexVeiculo++,modelo_cadastrado, marca_cadastrado, ano_cadastrado, preco_cadastrado, "Disponível");
        garagem_cadastrados.add(veiculo_cadastrado);

        

        System.out.println("\nVeículo " + modelo_cadastrado + " cadastrado com sucesso!");
        System.out.println("Pressione Enter para continuar...");
        inputVeiculo.nextLine(); // Pausa para o usuário ler
        Concessioanaria.Menu(null,null  );


        
    }


    public static void Vender_Veiculo() {

        System.out.println("\n ---- Vender Veiculo ----");
        

        System.out.print("Digite a placa do carro que sera vendido: ");
        int placa_venda = inputVeiculo.nextInt();

        for(Veiculos v : garagem_estoque) {

            if(v.placa == placa_venda){

                indexVeiculo = v.placa;

            }
        }

        for(Veiculos v : garagem_cadastrados) {


            if(v.placa == placa_venda) {

                indexVeiculo = v.placa;

            }

        }


        if(placa_venda == indexVeiculo) {

            for(Veiculos v : garagem_estoque) {

                if(v.placa == placa_venda) {


                    if(v.status == "Vendido") {

                        System.out.println("Esse Veiculo ja foi vendido...");
                        System.out.println("Pressione Enter para continuar...");

                        inputVeiculo.nextLine(); // Pausa para o usuário ler
                        Concessioanaria.Menu(null,null  );

                    } else {

                        v.status = "Vendido";

                    }
                    

                    
                    System.out.println("\nVeiculo " + v.modelo + " vendido com sucesso!");
                    System.out.println("Pressione Enter para continuar...");
                    inputVeiculo.nextLine(); // Pausa para o usuário ler
                    Concessioanaria.Menu(null,null  );

                }
            }

            for(Veiculos v : garagem_cadastrados) {
                if(v.placa == placa_venda) {
                    v.status = "Vendido";
                    System.out.println("\nVeiculo " + v.modelo + " vendido com sucesso!");
                    System.out.println("Pressione Enter para continuar...");
                    inputVeiculo.nextLine(); // Pausa para o usuário ler
                    Concessioanaria.Menu(null,null  );
            
        } else {
            System.out.println("\nPlaca Invalida! Tente Novamente.");
            Vender_Veiculo();
                }
            }

        }  
    
    }


    public static void Editar_Veiculo() {
        System.out.println("\n ---- Editar Veiculo ----\n");

        System.out.println("Digite a placa do carro que sera editado");
        System.out.print("==> ");
        int placa_editar = inputVeiculo.nextInt();

        if(placa_editar == indexVeiculo) {
            System.out.println("\nPlaca Invalida! Tente Novamente.");
            Editar_Veiculo();
        } else {
            
            System.out.println("\nO que deseja editar?");
            System.out.println("1 - Modelo");   
            System.out.println("2 - Marca");
            System.out.println("3 - Ano");
            System.out.println("4 - Preço");
            System.out.print("==> \n");
            int escolha_editar = inputVeiculo.nextInt();


            switch (escolha_editar) {

                //Editar Modelo
                case 1:
                    inputVeiculo.nextLine(); // Consumir a quebra de linha pendente
                    System.out.println("Digite o novo modelo: ");
                    String novo_modelo = inputVeiculo.next();

                    boolean encontrado = false;

                    for(Veiculos v : garagem_estoque) {
                        if(v.placa == placa_editar) {
                            v.modelo = novo_modelo;
                           
                            encontrado = true;
                        }
                    }

                    for(Veiculos v : garagem_cadastrados) {
                        if(v.placa == placa_editar) {
                            v.modelo = novo_modelo;

                            encontrado = true;
                            
                        }
                    }


                 if (encontrado) {
                        System.out.println("\nMarca atualizada com sucesso!");
                    } else {
                        System.out.println("\nPlaca não encontrada!");
                    }


                    
                    System.out.println("Pressione Enter para continuar...");
                    inputVeiculo.nextLine(); // Pausa para o usuário ler
                    Concessioanaria.Menu(null,null  );
                break;





                    //Editar Marca
                    case 2:
                    inputVeiculo.nextLine(); // Consumir a quebra de linha pendente
                    System.out.print("Digite a nova marca: ");
                    String nova_marca = inputVeiculo.nextLine();  
                    
                    boolean encontradoMarca = false;
                    
                    for(Veiculos v : garagem_estoque) {
                        if(v.placa == placa_editar) {
                            v.marca = nova_marca;
                            
                          
                            encontradoMarca = true;
                        }
                    }

                    for(Veiculos v : garagem_cadastrados) {
                        if(v.placa == placa_editar) {
                            v.marca = nova_marca;

                            encontradoMarca = true;
                            
                        }
                    }

                    if (encontradoMarca) {
                        System.out.println("\nMarca atualizada com sucesso!");
                    } else {
                        System.out.println("\nPlaca não encontrada!");
                    }

                    System.out.println("Pressione Enter para continuar...");
                    inputVeiculo.nextLine(); // Pausa para o usuário ler
                    Concessioanaria.Menu(null,null  );
                break;





                    //Editar Ano
                    case 3:

                    inputVeiculo.nextLine(); // Consumir a quebra de linha pendente
                    System.out.print("Digite o novo ano: ");
                    int novo_ano = inputVeiculo.nextInt();

                    boolean encontradoAno = false;                    

                    for(Veiculos v : garagem_estoque) {
                        if(v.placa == placa_editar) {
                            v.ano = novo_ano;
                        
                            encontradoAno = true;
                        
                        }
                    }


                    for(Veiculos v : garagem_cadastrados) {
                        if(v.placa == placa_editar) {
                            v.ano = novo_ano;
                            
                            encontradoAno = true;
                         
                        }

                    }


                    if (encontradoAno) {
                        System.out.println("\nAno atualizado com sucesso!");
                    } else {
                        System.out.println("\nPlaca não encontrada!");
                    }

                    System.out.println("Pressione Enter para continuar...");
                    inputVeiculo.nextLine(); // Pausa para o usuário ler
                    Concessioanaria.Menu(null,null  );

                break;




                    //Editar Preço
                    case 4:

                    inputVeiculo.nextLine(); // Consumir a quebra de linha pendente
                    
                    System.out.print("Digite o novo preço: ");
                    double novo_preco = inputVeiculo.nextDouble();

                    boolean encontradoPreco = false;

                    for(Veiculos v : garagem_estoque) {
                        if(v.placa == placa_editar) {
                            v.preco = novo_preco;
                           
                            encontradoPreco = true;
                        }
                    }

                    for(Veiculos v : garagem_cadastrados) {
                        if(v.placa == placa_editar) {
                            v.preco = novo_preco;

                            encontradoPreco = true;
                        }
                    }

                    if (encontradoPreco) {
                        System.out.println("\nPreço atualizado com sucesso!");
                    } else {
                        System.out.println("\nPlaca não encontrada!");
                    }

                    System.out.println("Pressione Enter para continuar...");
                    inputVeiculo.nextLine(); // Pausa para o usuário ler
                    Concessioanaria.Menu(null,null  );


                    break;

                default:
                    System.out.println("\nOpção inválida! Tente novamente.");   
                    Editar_Veiculo();
                    break;
            }
        }

    }

}
