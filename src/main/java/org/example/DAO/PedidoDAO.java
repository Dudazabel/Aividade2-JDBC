package org.example.DAO;

import org.example.model.Pedido;
import org.example.util.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PedidoDAO {

    public void inserirPedido(Pedido pedido) throws SQLException {
        String query = "INSERT INTO pedido(id_cliente, data_pedido, volume_m3, peso_kg, status_pedido) VALUES (?,NOW(),?,?,?)";

        try(Connection conn = conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, pedido.getId_cliente());
            stmt.setFloat(2, pedido.getVolume_m3());
            stmt.setFloat(3, pedido.getPeso_kg());
            stmt.setString(4, pedido.getStatus_pedido());
            stmt.executeUpdate();

        }
    }
}
