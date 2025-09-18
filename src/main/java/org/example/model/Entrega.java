package org.example.model;

import java.sql.Date;
import java.time.LocalDate;

public class Entrega {

    private int id_entrega;
    private int id_pedido;
    private int id_motora;
    private LocalDate data_saida;
    private LocalDate data_entrega;
    private String status_entrega;
    private String nome_motorista;
    private String nome_cliente;

    public Entrega(int id_pedido, int id_motora, LocalDate data_saida, LocalDate data_entrega, String status_entrega) {
        this.id_pedido = id_pedido;
        this.id_motora = id_motora;
        this.data_saida = data_saida;
        this.data_entrega = data_entrega;
        this.status_entrega = status_entrega;
    }

    public Entrega(int id_entrega, String status_entrega) {
        this.id_entrega = id_entrega;
        this.status_entrega = status_entrega;
    }

    public Entrega(int id_entrega, int id_pedido, int id_motora, LocalDate data_saida, LocalDate data_entrega, String status_entrega, String nome_motorista, String nome_cliente) {
        this.id_entrega = id_entrega;
        this.id_pedido = id_pedido;
        this.id_motora = id_motora;
        this.data_saida = data_saida;
        this.data_entrega = data_entrega;
        this.status_entrega = status_entrega;
        this.nome_motorista = nome_motorista;
        this.nome_cliente = nome_cliente;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_motora() {
        return id_motora;
    }

    public void setId_motora(int id_motora) {
        this.id_motora = id_motora;
    }

    public LocalDate getData_saida() {
        return data_saida;
    }

    public void setData_saida(LocalDate data_saida) {
        this.data_saida = data_saida;
    }

    public LocalDate getData_entrega() {
        return data_entrega;
    }

    public void setData_entrega(LocalDate data_entrega) {
        this.data_entrega = data_entrega;
    }

    public String getStatus_entrega() {
        return status_entrega;
    }

    public void setStatus_entrega(String status_entrega) {
        this.status_entrega = status_entrega;
    }

    public int getId_entrega() {
        return id_entrega;
    }

    public void setId_entrega(int id_entrega) {
        this.id_entrega = id_entrega;
    }

    public String getNome_motorista() {
        return nome_motorista;
    }

    public void setNome_motorista(String nome_motorista) {
        this.nome_motorista = nome_motorista;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }
}
