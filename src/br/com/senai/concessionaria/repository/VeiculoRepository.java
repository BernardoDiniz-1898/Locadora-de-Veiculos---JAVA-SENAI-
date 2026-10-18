package br.com.senai.concessionaria.repository;

import br.com.senai.concessionaria.model.StatusVeiculo;
import br.com.senai.concessionaria.model.Veiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VeiculoRepository {

    private static final List<Veiculo> veiculos = new ArrayList<>();
    private static int proximoId = 1;

    static {
        carregarPreCadastrados();
    }

    private static void carregarPreCadastrados() {
        adicionar(new Veiculo(1, "Gol", "Volkswagen", 2020, 55000.00, StatusVeiculo.DISPONIVEL));
        adicionar(new Veiculo(2, "Onix", "Chevrolet", 2021, 60000.00, StatusVeiculo.VENDIDO));
        adicionar(new Veiculo(3, "Fiesta", "Ford", 2019, 52000.00, StatusVeiculo.VENDIDO));
        adicionar(new Veiculo(4, "F8", "Ferrari", 2022, 3000000.00, StatusVeiculo.VENDIDO));
    }

    public static void adicionar(Veiculo veiculo) {
        veiculos.add(veiculo);
        if (veiculo.getPlaca() >= proximoId) {
            proximoId = veiculo.getPlaca() + 1;
        }
    }

    public static List<Veiculo> listarTodos() {
        return new ArrayList<>(veiculos);
    }

    public static Optional<Veiculo> buscarPorPlaca(int placa) {
        return veiculos.stream()
                .filter(v -> v.getPlaca() == placa)
                .findFirst();
    }

    public static int gerarProximaPlaca() {
        return proximoId++;
    }
}
