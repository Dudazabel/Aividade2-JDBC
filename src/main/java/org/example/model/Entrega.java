package org.example.model;

import java.sql.Date;
import java.time.LocalDate;

public class Entrega {

    private int id_pedido;
    private int id_motora;
    private LocalDate data_saida;
    private LocalDate data_entrega;
    private String status_entrega;

    public Entrega() {
        this.id_pedido = 0;
        this.id_motora = 0;
        this.data_saida = null;
        this.data_entrega = null;
        this.status_entrega = "";
    }

    public Entrega(int id_pedido, int id_motora, LocalDate data_saida, LocalDate data_entrega, String status_entrega) {
        this.id_pedido = id_pedido;
        this.id_motora = id_motora;
        this.data_saida = data_saida;
        this.data_entrega = data_entrega;
        this.status_entrega = status_entrega;
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
}
