package org.example.model;

public class Motorista {

    private String nome;
    private int cnh;
    private String veiculo;
    private String cidadeBase;

    public Motorista() {
        this.nome = "";
        this.cnh = 0;
        this.veiculo = "";
        this.cidadeBase = "";
    }

    public Motorista(String nome, int cnh, String veiculo, String cidadeBase) {
        this.nome = nome;
        this.cnh = cnh;
        this.veiculo = veiculo;
        this.cidadeBase = cidadeBase;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCnh() {
        return cnh;
    }

    public void setCnh(int cnh) {
        this.cnh = cnh;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getCidadeBase() {
        return cidadeBase;
    }

    public void setCidadeBase(String cidadeBase) {
        this.cidadeBase = cidadeBase;
    }
}
