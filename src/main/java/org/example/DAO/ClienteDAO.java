package org.example.DAO;

import org.example.model.Cliente;
import org.example.util.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ClienteDAO {

    public void inserirCliente(Cliente cliente)throws SQLException {

        String query = "INSERT INTO cliente(nome, cpf_cnpj, endereco, cidade, estado) VALUES (?,?,?,?,?)";

        try(Connection conn = conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setString(1, cliente.getNome());
            stmt.setInt(2, cliente.getCpf_cnpj());
            stmt.setString(3, cliente.getEndereco());
            stmt.setString(4, cliente.getCidade());
            stmt.setString(5, cliente.getEstado());
            stmt.executeUpdate();

        }
    }
}
