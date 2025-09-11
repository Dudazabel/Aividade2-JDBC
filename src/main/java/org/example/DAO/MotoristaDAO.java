package org.example.DAO;

import org.example.model.Motorista;
import org.example.util.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MotoristaDAO {

    public void inserirMotorista(Motorista motorista)throws SQLException {
        String query = "INSERT INTO motorista(nome, cnh, veiculo, cidade_base) VALUES (?,?,?,?)";

        try(Connection conn = conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setString(1, motorista.getNome());
            stmt.setInt(2, motorista.getCnh());
            stmt.setString(3, motorista.getVeiculo());
            stmt.setString(4, motorista.getCidadeBase());
            stmt.executeUpdate();

        }
    }
}
