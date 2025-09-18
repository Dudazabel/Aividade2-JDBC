package org.example.DAO;

import org.example.model.Cliente;
import org.example.model.Pedido;
import org.example.util.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
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

    public List<Pedido> pedidosPendentes() throws SQLException{
        String query = "SELECT c.estado, COUNT(p.id_pedido) AS quantidade_pedidos FROM pedido p JOIN cliente c ON p.id_cliente = c.id_cliente WHERE p.status_pedido = 'pendente' GROUP BY c.estado, p.status_pedido ORDER BY c.estado;";

        List<Pedido> Pendentes = new ArrayList<>();

        try(Connection conn = conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                String estado = rs.getString("estado");
                int quantidade_pedidos = rs.getInt("quantidade_pedidos");

                var pedido = new Pedido(estado, quantidade_pedidos);
                Pendentes.add(pedido);

            }
        }

        return Pendentes;
    }

}
