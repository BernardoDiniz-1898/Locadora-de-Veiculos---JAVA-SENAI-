package br.com.senai.concessionaria.service;

import br.com.senai.concessionaria.model.StatusVeiculo;
import br.com.senai.concessionaria.model.Veiculo;
import br.com.senai.concessionaria.repository.VeiculoRepository;

import java.util.List;
import java.util.Optional;

public class VeiculoService {

    public static List<Veiculo> listarVeiculos() {
        return VeiculoRepository.listarTodos();
    }

    public static void cadastrarVeiculo(String modelo, String marca, int ano, double preco) {
        int placa = VeiculoRepository.gerarProximaPlaca();
        Veiculo veiculo = new Veiculo(placa, modelo, marca, ano, preco, StatusVeiculo.DISPONIVEL);
        VeiculoRepository.adicionar(veiculo);
    }

    public static boolean venderVeiculo(int placa) {
        Optional<Veiculo> veiculoOpt = VeiculoRepository.buscarPorPlaca(placa);
        if (veiculoOpt.isEmpty()) {
            return false;
        }

        Veiculo veiculo = veiculoOpt.get();
        if (veiculo.getStatus() == StatusVeiculo.VENDIDO) {
            return false;
        }

        veiculo.setStatus(StatusVeiculo.VENDIDO);
        return true;
    }

    public static boolean editarModelo(int placa, String novoModelo) {
        Optional<Veiculo> veiculoOpt = VeiculoRepository.buscarPorPlaca(placa);
        if (veiculoOpt.isEmpty()) {
            return false;
        }
        veiculoOpt.get().setModelo(novoModelo);
        return true;
    }

    public static boolean editarMarca(int placa, String novaMarca) {
        Optional<Veiculo> veiculoOpt = VeiculoRepository.buscarPorPlaca(placa);
        if (veiculoOpt.isEmpty()) {
            return false;
        }
        veiculoOpt.get().setMarca(novaMarca);
        return true;
    }

    public static boolean editarAno(int placa, int novoAno) {
        Optional<Veiculo> veiculoOpt = VeiculoRepository.buscarPorPlaca(placa);
        if (veiculoOpt.isEmpty()) {
            return false;
        }
        veiculoOpt.get().setAno(novoAno);
        return true;
    }

    public static boolean editarPreco(int placa, double novoPreco) {
        Optional<Veiculo> veiculoOpt = VeiculoRepository.buscarPorPlaca(placa);
        if (veiculoOpt.isEmpty()) {
            return false;
        }
        veiculoOpt.get().setPreco(novoPreco);
        return true;
    }

    public static boolean existeVeiculo(int placa) {
        return VeiculoRepository.buscarPorPlaca(placa).isPresent();
    }
}
