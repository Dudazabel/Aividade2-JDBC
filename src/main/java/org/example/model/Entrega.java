package org.example.model;

import java.sql.Date;

public class Entrega {

    private int id_cliente;
    private int id_motora;
    private Date data_saida;
    private Date data_entrega;
    private String status_entrega;

    public Entrega() {
        this.id_cliente = 0;
        this.id_motora = 0;
        this.data_saida = null;
        this.data_entrega = null;
        this.status_entrega = "";
    }

    public Entrega(int id_cliente, int id_motora, Date data_saida, Date data_entrega, String status_entrega) {
        this.id_cliente = id_cliente;
        this.id_motora = id_motora;
        this.data_saida = data_saida;
        this.data_entrega = data_entrega;
        this.status_entrega = status_entrega;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_motora() {
        return id_motora;
    }

    public void setId_motora(int id_motora) {
        this.id_motora = id_motora;
    }

    public Date getData_saida() {
        return data_saida;
    }

    public void setData_saida(Date data_saida) {
        this.data_saida = data_saida;
    }

    public Date getData_entrega() {
        return data_entrega;
    }

    public void setData_entrega(Date data_entrega) {
        this.data_entrega = data_entrega;
    }

    public String getStatus_entrega() {
        return status_entrega;
    }

    public void setStatus_entrega(String status_entrega) {
        this.status_entrega = status_entrega;
    }
}
