package org.example.DAO;

import org.example.model.Entrega;
import org.example.util.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EntregaDAO {

    public void inserirEntrega(Entrega entrega) throws SQLException{
        String query = "INSERT INTO entrega(id_pedido, id_motora, data_saida, data_entrega, status_entrega) VALUES (?,?,?,?,?)";

        try(Connection conn = conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, entrega.getId_pedido());
            stmt.setInt(2, entrega.getId_motora());
            stmt.setObject(3, entrega.getData_saida());
            stmt.setObject(4, entrega.getData_entrega());
            stmt.setString(5, entrega.getStatus_entrega());
            stmt.executeUpdate();
        }
    }
}
