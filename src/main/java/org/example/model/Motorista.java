package org.example.model;

public class Motorista {

    private String nome;
    private int cnh;
    private String veiculo;
    private String cidadeBase;
    private int total_entregas;
    private int id_motora;

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

    public Motorista(int id_motora, String nome, int cnh, String veiculo, String cidadeBase, int total_entregas) {
        this.id_motora = id_motora;
        this.nome = nome;
        this.cnh = cnh;
        this.veiculo = veiculo;
        this.cidadeBase = cidadeBase;
        this.total_entregas = total_entregas;
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

    public int getTotal_entregas() {
        return total_entregas;
    }

    public void setTotal_entregas(int total_entregas) {
        this.total_entregas = total_entregas;
    }

    public int getId_motora() {
        return id_motora;
    }

    public void setId_motora(int id_motora) {
        this.id_motora = id_motora;
    }
}
