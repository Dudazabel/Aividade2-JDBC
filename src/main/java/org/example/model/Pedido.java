package org.example.model;

import java.sql.Date;
import java.time.LocalDate;

public class Pedido {

    private int id_cliente;
    private LocalDate data_pedido;
    private Float volume_m3;
    private Float peso_kg;
    private String status_pedido;

    public Pedido() {
        this.id_cliente = 0;
        this.data_pedido = null;
        this.volume_m3 = null;
        this.peso_kg = null;
        this.status_pedido = "";
    }

    public Pedido(int id_cliente, LocalDate data_pedido, Float volume_m3, Float peso_kg, String status_pedido) {
        this.id_cliente = id_cliente;
        this.data_pedido = data_pedido;
        this.volume_m3 = volume_m3;
        this.peso_kg = peso_kg;
        this.status_pedido = status_pedido;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public LocalDate getData_pedido() {
        return data_pedido;
    }

    public void setData_pedido(LocalDate data_pedido) {
        this.data_pedido = data_pedido;
    }

    public Float getVolume_m3() {
        return volume_m3;
    }

    public void setVolume_m3(Float volume_m3) {
        this.volume_m3 = volume_m3;
    }

    public Float getPeso_kg() {
        return peso_kg;
    }

    public void setPeso_kg(Float peso_kg) {
        this.peso_kg = peso_kg;
    }

    public String getStatus_pedido() {
        return status_pedido;
    }

    public void setStatus_pedido(String status_pedido) {
        this.status_pedido = status_pedido;
    }
}
