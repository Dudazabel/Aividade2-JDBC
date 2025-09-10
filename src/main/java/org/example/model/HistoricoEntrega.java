package org.example.model;

import javax.xml.crypto.Data;

public class HistoricoEntrega {

    private int id_entrega;
    private Data data_evento;
    private String descricao;

    public HistoricoEntrega() {
        this.id_entrega = 0;
        this.data_evento = null;
        this.descricao = "";
    }

    public HistoricoEntrega(int id_entrega, Data data_evento, String descricao) {
        this.id_entrega = id_entrega;
        this.data_evento = data_evento;
        this.descricao = descricao;
    }

    public int getId_entrega() {
        return id_entrega;
    }

    public void setId_entrega(int id_entrega) {
        this.id_entrega = id_entrega;
    }

    public Data getData_evento() {
        return data_evento;
    }

    public void setData_evento(Data data_evento) {
        this.data_evento = data_evento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
