package br.com.senai.concessionaria.view;

import br.com.senai.concessionaria.model.Veiculo;
import br.com.senai.concessionaria.service.VeiculoService;
import br.com.senai.concessionaria.util.InputUtil;

import java.util.List;

public class VeiculoView {

    public static void exibirMenu() {
        while (true) {
            System.out.println("\n---- Gerenciamento de Veículos ----\n");
            System.out.println("1 - Listar Veículos");
            System.out.println("2 - Cadastrar Veículo");
            System.out.println("3 - Vender Veículo");
            System.out.println("4 - Editar Veículo");
            System.out.println("5 - Voltar ao Menu Principal");

            int opcao = InputUtil.lerInt("\n==> ");
            switch (opcao) {
                case 1:
                    listarVeiculos();
                    break;
                case 2:
                    cadastrarVeiculo();
                    break;
                case 3:
                    venderVeiculo();
                    break;
                case 4:
                    editarVeiculo();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("\nOpção inválida. Tente novamente.\n");
            }
        }
    }

    private static void listarVeiculos() {
        List<Veiculo> veiculos = VeiculoService.listarVeiculos();
        System.out.println("\n---- Lista de Veículos ----\n");
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
        } else {
            for (Veiculo v : veiculos) {
                System.out.println(v);
            }
        }
        InputUtil.pressionarEnter();
    }

    private static void cadastrarVeiculo() {
        System.out.println("\n---- Cadastrar Veículo ----\n");
        String modelo = InputUtil.lerString("Modelo: ");
        String marca = InputUtil.lerString("Marca: ");
        int ano = InputUtil.lerInt("Ano: ");
        double preco = InputUtil.lerDouble("Preço: ");

        VeiculoService.cadastrarVeiculo(modelo, marca, ano, preco);
        System.out.println("\nVeículo " + modelo + " cadastrado com sucesso!");
        InputUtil.pressionarEnter();
    }

    private static void venderVeiculo() {
        System.out.println("\n---- Vender Veículo ----\n");
        int placa = InputUtil.lerInt("Digite a placa do veículo que será vendido: ");

        boolean sucesso = VeiculoService.venderVeiculo(placa);
        if (sucesso) {
            System.out.println("\nVeículo vendido com sucesso!");
        } else {
            System.out.println("\nPlaca inválida ou veículo já vendido!");
        }
        InputUtil.pressionarEnter();
    }

    private static void editarVeiculo() {
        System.out.println("\n---- Editar Veículo ----\n");
        int placa = InputUtil.lerInt("Digite a placa do veículo que será editado: ");

        if (!VeiculoService.existeVeiculo(placa)) {
            System.out.println("\nPlaca inválida! Tente novamente.");
            InputUtil.pressionarEnter();
            return;
        }

        System.out.println("\nO que deseja editar?");
        System.out.println("1 - Modelo");
        System.out.println("2 - Marca");
        System.out.println("3 - Ano");
        System.out.println("4 - Preço");
        int opcao = InputUtil.lerInt("\n==> ");

        boolean sucesso = false;
        switch (opcao) {
            case 1:
                String novoModelo = InputUtil.lerString("Digite o novo modelo: ");
                sucesso = VeiculoService.editarModelo(placa, novoModelo);
                if (sucesso) {
                    System.out.println("\nModelo atualizado com sucesso!");
                } else {
                    System.out.println("\nErro ao atualizar modelo!");
                }
                break;
            case 2:
                String novaMarca = InputUtil.lerString("Digite a nova marca: ");
                sucesso = VeiculoService.editarMarca(placa, novaMarca);
                if (sucesso) {
                    System.out.println("\nMarca atualizada com sucesso!");
                } else {
                    System.out.println("\nErro ao atualizar marca!");
                }
                break;
            case 3:
                int novoAno = InputUtil.lerInt("Digite o novo ano: ");
                sucesso = VeiculoService.editarAno(placa, novoAno);
                if (sucesso) {
                    System.out.println("\nAno atualizado com sucesso!");
                } else {
                    System.out.println("\nErro ao atualizar ano!");
                }
                break;
            case 4:
                double novoPreco = InputUtil.lerDouble("Digite o novo preço: ");
                sucesso = VeiculoService.editarPreco(placa, novoPreco);
                if (sucesso) {
                    System.out.println("\nPreço atualizado com sucesso!");
                } else {
                    System.out.println("\nErro ao atualizar preço!");
                }
                break;
            default:
                System.out.println("\nOpção inválida! Tente novamente.");
                editarVeiculo();
                return;
        }
        InputUtil.pressionarEnter();
    }
}
