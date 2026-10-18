package br.com.senai.concessionaria.model;

public class Veiculo {

    private int placa;
    private String modelo;
    private String marca;
    private int ano;
    private double preco;
    private StatusVeiculo status;

    public Veiculo(int placa, String modelo, String marca, int ano, double preco, StatusVeiculo status) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.preco = preco;
        this.status = status;
    }

    public int getPlaca() {
        return placa;
    }

    public void setPlaca(int placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public StatusVeiculo getStatus() {
        return status;
    }

    public void setStatus(StatusVeiculo status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Placa: " + placa +
                " - " + modelo +
                " - " + marca +
                " - " + ano +
                " - R$" + preco +
                " - Status: " + status;
    }
}
