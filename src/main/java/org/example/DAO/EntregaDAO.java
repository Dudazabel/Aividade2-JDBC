package org.example.DAO;

import org.example.model.Entrega;
import org.example.model.Motorista;
import org.example.util.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public List<Entrega> listarEntrega() throws SQLException{
        String query = "SELECT id_entrega, status_entrega FROM entrega";

        List<Entrega> entregas = new ArrayList<>();

        try(Connection conn = conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                int id_entrega = rs.getInt("id_entrega");
                String status_entrega = rs.getString("status_entrega");

                var entrega = new Entrega(id_entrega, status_entrega);
                entregas.add(entrega);
            }
        }

        return entregas;
    }

    public void atualizarEntrega(Entrega entrega) throws SQLException{
        String query = "UPDATE entrega SET id_entrega = ?, status_entrega = ? WHERE id_entrega LIKE ?";

        try(Connection conn = conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, entrega.getId_entrega());
            stmt.setString(2, entrega.getStatus_entrega());
            stmt.setInt(3, entrega.getId_entrega());
            stmt.executeUpdate();
        }

    }

    public List<Entrega> listarEntregaMCP() throws SQLException{
        String query = " SELECT e.*, m.nome AS nome_motorista, c.nome AS nome_cliente FROM entrega e JOIN motorista m ON e.id_motora = m.id_motora JOIN pedido p ON e.id_pedido = p.id_pedido JOIN cliente c ON p.id_cliente = c.id_cliente";

        List<Entrega> entregas = new ArrayList<>();

        try(Connection conn = conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                int id_entrega = rs.getInt("id_entrega");
                int id_pedido = rs.getInt("id_pedido");
                int id_motora = rs.getInt("id_motora");
                LocalDate data_saida = rs.getObject("data_saida", LocalDate.class);
                LocalDate data_entrega = rs.getObject("data_entrega", LocalDate.class);
                String status_entrega = rs.getString("status_entrega");
                String nome_motorista = rs.getString("nome_motorista");
                String nome_cliente = rs.getString("nome_cliente");

                var entrega = new Entrega(id_entrega, id_pedido, id_motora, data_saida, data_entrega, status_entrega, nome_motorista, nome_cliente );
                entregas.add(entrega);
            }
        }

        return entregas;
    }

    public List<Motorista> maisEntregas() throws SQLException{
        String query = "SELECT m.id_motora, m.nome, m.cnh, m.veiculo, m.cidade_base, COUNT(e.id_entrega) AS total_entregas FROM motorista m LEFT JOIN entrega e ON e.id_motora = m.id_motora GROUP BY m.id_motora, m.nome, m.cnh, m.veiculo, m.cidade_base ORDER BY total_entregas DESC LIMIT 1";

        List<Motorista> motorista = new ArrayList<>();

        try(Connection conn = conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();

            rs.next();
            int id_motora = rs.getInt("id_motora");
            String nome = rs.getString("nome");
            int cnh = rs.getInt("cnh");
            String veiculo = rs.getString("veiculo");
            String cidade_base = rs.getString("cidade_base");
            int total_entregas = rs.getInt("total_entregas");

            var motora = new Motorista(id_motora, nome, cnh, veiculo, cidade_base, total_entregas);
            motorista.add(motora);
        }

        return motorista;
    }
}
