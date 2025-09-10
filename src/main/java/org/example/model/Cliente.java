package org.example.model;

public class Cliente {

    private String nome;
    private int cpf_cnpj;
    private String endereco;
    private String cidade;
    private String estado;

    public Cliente() {
        this.nome = "";
        this.cpf_cnpj = 0;
        this.endereco = "";
        this.cidade = "";
        this.estado = "";
    }

    public Cliente(String nome, int cpf_cnpj, String endereco, String cidade, String estado) {
        this.nome = nome;
        this.cpf_cnpj = cpf_cnpj;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(int cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
