package org.example.DAO;

import org.example.model.Cliente;
import org.example.util.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    public List<Cliente> clienteMaiorVolume() throws SQLException{
        String query = "SELECT c.id_cliente, c.nome, c.cpf_cnpj, c.endereco, c.cidade, c.estado, p.volume_m3 FROM cliente c JOIN pedido p ON c.id_cliente = p.id_cliente WHERE p.volume_m3 = (SELECT MAX(volume_m3)FROM pedido)";

        List<Cliente> clientes = new ArrayList<>();

        try(Connection conn = conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();

            rs.next();
            int id = rs.getInt("id_cliente");
            String nome = rs.getString("nome");
            int cpf_cnpj= rs.getInt("cpf_cnpj");
            String endereco = rs.getString("endereco");
            String cidade = rs.getString("cidade");
            String estado = rs.getString("estado");
            int volume = rs.getInt("volume_m3");

            var cliente = new Cliente(id, nome, cpf_cnpj, endereco, cidade, estado, volume);
            clientes.add(cliente);
        }

        return clientes;
    }
}
