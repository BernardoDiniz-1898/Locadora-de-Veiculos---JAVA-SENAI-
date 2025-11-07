import java.util.ArrayList;
import java.util.Scanner;

class Veiculos {
    
    static int pk = 4;
    private static ArrayList<Veiculos> garagem_cadastrados = new ArrayList<>();
    private static ArrayList<Veiculos> garagem_estoque = new ArrayList<>();

    static Scanner inputVeiculo = new Scanner(System.in);

    String modelo;
    String marca;
    int ano;
    double preco;
    String status;
    int primaryKey;

    public Veiculos(int primaryKey,String modelo, String marca, int ano, double preco, String status) {

        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.preco = preco;
        this.status = status;
        this.primaryKey = primaryKey;

    }

    public static void Listar_Veiculos() {



        Veiculos Gol_Volkswagen = new Veiculos(1,"Gol", "Volkswagen", 2020, 55000.00,"Disponível");
        Veiculos Onix_Chevrolet = new Veiculos(2,"Onix", "Chevrolet", 2021, 60000.00, "Disponível");
        Veiculos Fiesta_Ford = new Veiculos(3,"Fiesta", "Ford", 2019, 52000.00, "Disponível");
        Veiculos Ferrari_F8 = new Veiculos(4,"F8", "Ferrari", 2022, 3000000.00, "Disponível");
        
        garagem_estoque.add(Gol_Volkswagen);
        garagem_estoque.add(Ferrari_F8);
        garagem_estoque.add(Fiesta_Ford);
        garagem_estoque.add(Ferrari_F8);


        System.out.println("\n---- Lista de Veículos ----\n");

        System.out.println("Placa: " + Gol_Volkswagen.primaryKey + " - " + Gol_Volkswagen.modelo + " - " + Gol_Volkswagen.marca + " - " + Gol_Volkswagen.ano  + " - R$" + Gol_Volkswagen.preco +" Status:  "+Gol_Volkswagen.status);
        System.out.println("Placa: " + Onix_Chevrolet.primaryKey + " - " + Onix_Chevrolet.modelo + " - " + Onix_Chevrolet.marca + " - " + Onix_Chevrolet.ano + " - R$" + Onix_Chevrolet.preco +" Status:  "+Onix_Chevrolet.status);
        System.out.println("Placa: " + Fiesta_Ford.primaryKey + " - " + Fiesta_Ford.modelo + " - " + Fiesta_Ford.marca + " - " + Fiesta_Ford.ano + " - R$" + Fiesta_Ford.preco +" Status:  "+ Fiesta_Ford.status);
        System.out.println("Placa: " + Ferrari_F8.primaryKey +" - "+ Ferrari_F8.modelo + " - " + Ferrari_F8.marca + " - " + Ferrari_F8.ano + " - R$"  + Ferrari_F8.preco +" Status:  "+ Ferrari_F8.status);
        System.out.println();
        
        System.out.println("----- Lista de Veiculos Cadastrado ----");

         if (garagem_cadastrados.isEmpty()) {

            System.out.println("    Nemhum veiculo cadastrado  ");
        
         } else {
            
            for(Veiculos v : garagem_cadastrados) {
   
                System.out.println("Placa: " + v.primaryKey + " - "+ v.modelo + " - " + v.marca + " - " + v.ano + " - R$" + v.preco  +" Status:  "+ v.status);
                
            }
         

         }

        //Voltar ao Menu
        System.out.println("\nPressione Enter para voltar ao Menu Principal...");
        System.out.print("==> ");
        inputVeiculo.nextLine();
        Concessioanaria.Menu(null, null);
        
        

        


        

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
        
        
        Veiculos veiculo_cadastrado = new Veiculos(pk++,modelo_cadastrado, marca_cadastrado, ano_cadastrado, preco_cadastrado, "Disponível");
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

        if(placa_venda == pk) {
            System.out.println("\nPlaca Invalida! Tente Novamente.");
            Vender_Veiculo();
        } else {
            for(Veiculos v : garagem_estoque) {
                if(v.primaryKey == placa_venda) {
                    v.status = "Vendido";
                    System.out.println("\nVeiculo " + v.modelo + " vendido com sucesso!");
                    System.out.println("Pressione Enter para continuar...");
                    inputVeiculo.nextLine(); // Pausa para o usuário ler
                    Concessioanaria.Menu(null,null  );
                }
            }

            for(Veiculos v : garagem_cadastrados) {
                if(v.primaryKey == placa_venda) {
                    v.status = "Vendido";
                    System.out.println("\nVeiculo " + v.modelo + " vendido com sucesso!");
                    System.out.println("Pressione Enter para continuar...");
                    inputVeiculo.nextLine(); // Pausa para o usuário ler
                    Concessioanaria.Menu(null,null  );
                }
            }

        }  
    
    }


    public static void Editar_Veiculo() {
        System.out.println("\n ---- Editar Veiculo ----\n");

        System.out.println("Digite a placa do carro que sera editado");
        System.out.print("==> ");
        int placa_editar = inputVeiculo.nextInt();

        if(placa_editar == pk) {
            System.out.println("\nPlaca Invalida! Tente Novamente.");
            Editar_Veiculo();
        } else {
            
            System.out.println("O que deseja editar?");
            System.out.println("1 - Modelo");   
            System.out.println("2 - Marca");
            System.out.println("3 - Ano");
            System.out.println("4 - Preço");
            System.out.print("==> ");
            int escolha_editar = inputVeiculo.nextInt();


            switch (escolha_editar) {

                //Editar Modelo
                case 1:
                    System.out.print("Digite o novo modelo: ");
                    String novo_modelo = inputVeiculo.nextLine();

                    for(Veiculos v : garagem_estoque) {
                        if(v.primaryKey == placa_editar) {
                            v.modelo = novo_modelo;
                            System.out.println("\nModelo atualizado com sucesso!");
                            System.out.println("Pressione Enter para continuar...");
                            inputVeiculo.nextLine(); // Pausa para o usuário ler
                            Concessioanaria.Menu(null,null  );
                        }
                    }

                    for(Veiculos v : garagem_cadastrados) {
                        if(v.primaryKey == placa_editar) {
                            v.modelo = novo_modelo;
                            System.out.println("\nModelo atualizado com sucesso!");
                            System.out.println("Pressione Enter para continuar...");
                            inputVeiculo.nextLine(); // Pausa para o usuário ler
                            Concessioanaria.Menu(null,null  );
                        }
                    }
                    break;


                    //Editar Marca
                    case 2:

                    System.out.print("Digite a nova marca: ");
                    String nova_marca = inputVeiculo.nextLine();       

                    for(Veiculos v : garagem_estoque) {
                        if(v.primaryKey == placa_editar) {
                            v.marca = nova_marca;
                            System.out.println("\nMarca atualizada com sucesso!");
                            System.out.println("Pressione Enter para continuar...");
                            inputVeiculo.nextLine(); // Pausa para o usuário ler
                            Concessioanaria.Menu(null,null  );
                        }
                    }

                    for(Veiculos v : garagem_cadastrados) {
                        if(v.primaryKey == placa_editar) {
                            v.marca = nova_marca;
                            System.out.println("\nMarca atualizada com sucesso!");
                            System.out.println("Pressione Enter para continuar...");
                            inputVeiculo.nextLine(); // Pausa para o usuário ler
                            Concessioanaria.Menu(null,null  );
                        }
                    }
                    break;

                    //Editar Ano
                    case 3:

                    System.out.print("Digite o novo ano: ");
                    int novo_ano = inputVeiculo.nextInt();

                    for(Veiculos v : garagem_estoque) {
                        if(v.primaryKey == placa_editar) {
                            v.ano = novo_ano;
                            System.out.println("\nAno atualizado com sucesso!");
                            System.out.println("Pressione Enter para continuar...");
                            inputVeiculo.nextLine(); // Pausa para o usuário ler
                            Concessioanaria.Menu(null,null  );
                        }
                    }


                    for(Veiculos v : garagem_cadastrados) {
                        if(v.primaryKey == placa_editar) {
                            v.ano = novo_ano;
                            System.out.println("\nAno atualizado com sucesso!");
                            System.out.println("Pressione Enter para continuar...");
                            inputVeiculo.nextLine(); // Pausa para o usuário ler
                            Concessioanaria.Menu(null,null  );
                        }
                    }
                    break;

                    //Editar Preço
                    case 4:

                    System.out.print("Digite o novo preço: ");
                    double novo_preco = inputVeiculo.nextDouble();

                    for(Veiculos v : garagem_estoque) {
                        if(v.primaryKey == placa_editar) {
                            v.preco = novo_preco;
                            System.out.println("\nPreço atualizado com sucesso!");
                            System.out.println("Pressione Enter para continuar...");
                            inputVeiculo.nextLine(); // Pausa para o usuário ler
                            Concessioanaria.Menu(null,null  );
                        }
                    }

                    for(Veiculos v : garagem_cadastrados) {
                        if(v.primaryKey == placa_editar) {
                            v.preco = novo_preco;
                            System.out.println("\nPreço atualizado com sucesso!");
                            System.out.println("Pressione Enter para continuar...");
                            inputVeiculo.nextLine(); // Pausa para o usuário ler
                            Concessioanaria.Menu(null,null  );
                        }
                    }
                    break;
                    
                default:
                    System.out.println("\nOpção inválida. Tente novamente.\n");
                    Editar_Veiculo();
                    break;
            }
        }












    }


   



}
