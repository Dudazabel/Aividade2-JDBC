package org.example.DAO;

import org.example.model.Cliente;
import org.example.model.Pedido;
import org.example.util.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

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

    public List<Cliente> clienteMaiorVolume() throws SQLException{
        String query = "SELECT c.id_cliente, c.nome, c.cpf_cnpj, c.endereco, c.cidade, c.estado, p.volume_m3 FROM cliente c JOIN pedido p ON c.id_cliente = p.id_cliente WHERE p.volume_m3 = (SELECT MAX(volume_m3)FROM pedido)";
    }
}
