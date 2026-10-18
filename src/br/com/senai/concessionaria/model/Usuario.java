package br.com.senai.concessionaria.model;

public class Usuario {

    private String nome;
    private String cpf;
    private String telefone;
    private String dataUltimaCompra;
    private String status;

    public Usuario(String nome, String cpf, String telefone, String dataUltimaCompra, String status) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataUltimaCompra = dataUltimaCompra;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataUltimaCompra() {
        return dataUltimaCompra;
    }

    public void setDataUltimaCompra(String dataUltimaCompra) {
        this.dataUltimaCompra = dataUltimaCompra;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                " - CPF: " + cpf +
                " - Telefone: " + telefone +
                " - Data Última Compra: " + dataUltimaCompra +
                " - Status: " + status;
    }
}
