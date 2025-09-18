package org.example.DAO;

import org.example.model.HistoricoEntrega;
import org.example.util.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HistoricoDAO {

    public void inserirHstorico (HistoricoEntrega historico) throws SQLException {
        String query = "INSERT INTO historicoEntrega(id_entrega, data_evento, descricao) VALUES (?,?,?)";

        try(Connection conn = conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, historico.getId_entrega());
            stmt.setObject(2, historico.getData_evento());
            stmt.setString(3, historico.getDescricao());
            stmt.executeUpdate();
        }
    }
}
