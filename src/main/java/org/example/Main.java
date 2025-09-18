package org.example;

import org.example.DAO.*;
import org.example.model.*;

import java.sql.SQLException;
import java.sql.SQLWarning;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner leia = new Scanner(System.in);

    public static void main(String[] args) {
        inicio();
    }

    public static void inicio(){
        boolean sair = false;

        System.out.print("""
                ---------------------- MENU -------------------------------
                    1 - Cadastrar Cliente
                    2 - Cadastrar Motorista
                    3 - Criar Pedido
                    4 - Atribuir Pedido a Motorista (Gerar Entrega)
                    5 - Registrar Evento de Entrega (Histórico)
                    6 - Atualizar Status da Entrega
                    7 - Listar Todas as Entregas com Cliente e Motorista
                    8 - Relatório: Total de Entregas por Motorista
                    9 - Relatório: Clientes com Maior Volume Entregue
                    10 - Relatório: Pedidos Pendentes por Estado
                    11 - Relatório: Entregas Atrasadas por Cidade
                    12 - Buscar Pedido por CPF/CNPJ do Cliente
                    13 - Cancelar Pedido
                    14 - Excluir Entrega (com validação)
                    15 - Excluir Cliente (com verificação de dependência)
                    16 - Excluir Motorista (com verificação de dependência)
                    0 - Sair
                -----------------------------------------------------------
                Selecione uma opção
                >
                """);
        int opcao = leia.nextInt();
        leia.nextLine();

        switch (opcao){
            case 1 ->{
                cadastrarCliente();
            }
            case 2 ->{
                cadastrarMotorista();
            }
            case 3 ->{
                criarPedido();
            }
            case 4 ->{
                gerarEntrega();
            }
            case 5 ->{
                registrarHistorico();
            }
            case 6 ->{
                atualizarEntrega();
            }
            case 7 ->{
                listarEntregas();
            }
            case 8 ->{
                relatorioMaisEntregas();
            }
            case 9 ->{

            }
            case 10 ->{

            }
            case 11 ->{

            }
            case 12 ->{

            }
            case 13 ->{

            }
            case 14 ->{

            }
            case 15 ->{

            }
            case 16 ->{

            }
            case 0 ->{
                sair = true;
            }
        }
        if(!sair){
            inicio();
        }
    }

    public static void cadastrarCliente(){
        var dao = new ClienteDAO();
        System.out.println("---CADASTRAR CLIENTE---");
        System.out.println("Digite o nome do cliente: ");
        String nome = leia.nextLine();
        System.out.println("Digite o cpf/cnpj do cliente: ");
        int cpf_cnpj = leia.nextInt();
        System.out.println("Digite o endereco do cliente: ");
        leia.nextLine();
        String endereco = leia.nextLine();
        System.out.println("Digite a cidade do cliente: ");
        String cidade = leia.nextLine();
        System.out.println("Digite o estado do cliente: ");
        String estado = leia.nextLine();

        try{
            var cliente = new Cliente(nome, cpf_cnpj, endereco, cidade, estado);
            dao.inserirCliente(cliente);
            System.out.println("Cliente cadastrado com sucesso!");

        }catch (SQLException erro){
            erro.printStackTrace();
            System.out.println("Erro ao cadastrar cliente.");
        }
    }

    public static void cadastrarMotorista(){
        var dao = new MotoristaDAO();
        System.out.println("---CADASTRAR MOTORISTA---");
        System.out.println("Digite o nome do motorista: ");
        String nome = leia.nextLine();
        System.out.println("Digite a cnh do motorista: ");
        int cnh = leia.nextInt();
        System.out.println("Digite o veículo do motorista: ");
        leia.nextLine();
        String veiculo = leia.nextLine();
        System.out.println("Digite a cidade base do motorista: ");
        String cidade_base = leia.nextLine();

        try{
            var motorista = new Motorista(nome, cnh, veiculo, cidade_base);
            dao.inserirMotorista(motorista);
            System.out.println("Motorista cadastrado com sucesso!");

        }catch (SQLException erro){
            erro.printStackTrace();
            System.out.println("Erro ao cadastrar motorista.");
        }
    }

    public static void criarPedido(){
        var dao = new PedidoDAO();

        System.out.println("---CRIAR PEDIDO---");
        System.out.println("Digite o ID do cliente que efetuou o pedido: ");
        int id_cliente = leia.nextInt();
        System.out.println("Digite o volume do pedido em m3: ");
        float volume_m3 = leia.nextFloat();
        System.out.println("Digite o peso do pedido em kg: ");
        float peso_kg = leia.nextFloat();
        leia.nextLine();
        System.out.println("Informe o status do pedido (pendente, entregue, cancelado): ");
        String status_pedido = leia.nextLine();

        try {
            var pedido = new Pedido(id_cliente, null, volume_m3, peso_kg, status_pedido);
            dao.inserirPedido(pedido);
            System.out.println("Pedido criado com sucesso!");

        }catch(SQLException erro){
            erro.printStackTrace();
            System.out.println("Erro ao criar pedido.");
        }

    }

    public static void gerarEntrega(){

        LocalDate data_entrega = null;
        LocalDate data_saida = null;

        var dao = new EntregaDAO();

        System.out.println("---GERAR ENTREGA---");

        System.out.println("Digite o ID do pedido da entrega: ");
        int id_pedido = leia.nextInt();

        System.out.println("Digite o ID do motorista que realiza-rá a entrega: ");
        int id_motora = leia.nextInt();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        leia.nextLine();

        try {
            System.out.println("Digite a data de saída: ");
            String data = leia.nextLine();
            data_saida = LocalDate.parse(data);

        } catch (DateTimeParseException e) {
            System.out.println("Formato de data inválido! Por favor, use o formato dd/MM/yyyy.");
        }

        try {
            System.out.println("Digite a data de entrega: ");
            String data2 = leia.nextLine();
            data_entrega = LocalDate.parse(data2);

        } catch (DateTimeParseException e) {
            System.out.println("Formato de data inválido! Por favor, use o formato dd/MM/yyyy.");
        }

        System.out.println("Informe o status da entrega (em-rota, entregue, atrasada): ");
        String status_entrega = leia.nextLine();

        try{
            var entrega = new Entrega(id_pedido, id_motora, data_saida, data_entrega, status_entrega);
            dao.inserirEntrega(entrega);
            System.out.println("Entrega cadastrada com sucesso.");

        }catch(SQLException erro){
            erro.printStackTrace();
            System.out.println("Erro ao cadastrar entrega.");
        }
    }

    public static void registrarHistorico(){
        System.out.println("---REGISTRAR HISTÓRICO---");

        LocalDate data_evento = null;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.println("Digite o ID da entrega: ");
        int id_entrega = leia.nextInt();

        leia.nextLine();

        try {
            System.out.println("Digite a data de entrega: ");
            String dataE = leia.nextLine();
            data_evento = LocalDate.parse(dataE);

        }catch (DateTimeParseException e) {
            System.out.println("Formato de data inválido! Por favor, use o formato dd/MM/yyyy.");
        }

        System.out.println("Descrição da entrega: ");
        String descricao = leia.nextLine();

        try{
            var dao = new HistoricoDAO();

            var historico = new HistoricoEntrega(id_entrega, data_evento, descricao);
            dao.inserirHstorico(historico);
            System.out.println("Histórico adicionado com sucesso!");

        }catch(SQLException erro){
            erro.printStackTrace();
            System.out.println("Erro de inserção.");
        }
    }

    public static void atualizarEntrega(){
        System.out.println("---ATUALIZAR STATUS ENTREGA---");

        List<Integer> idEntregas = new ArrayList<>();
        List<Entrega> entregas = new ArrayList<>();

        var dao = new EntregaDAO();
        try{
            entregas = dao.listarEntrega();
            idEntregas = exibirEntregas(entregas);

        }catch(SQLException erro){
            erro.printStackTrace();
        }
        System.out.println("Digite o id da entrega para edição: ");
        int id = leia.nextInt();
        leia.nextLine();

        if(idEntregas.contains(id)){
            System.out.println("Informe o status da entrega (em-rota, entregue, atrasada):");
            String status = leia.nextLine();

            try{
                var entrega = new Entrega (id, status);
                dao.atualizarEntrega(entrega);
                System.out.println("Atualizado com sucesso!");

            }catch(SQLException erro){
                erro.printStackTrace();
                System.out.println("Erro ao atualizar.");
            }
        }
    }

    public static List<Integer> exibirEntregas(List<Entrega> entregas){
        List<Integer> idEntregas = new ArrayList<>();

        for(Entrega entrega : entregas){
            System.out.println("-----------");
            System.out.println("ID: " + entrega.getId_entrega());
            System.out.println("Status entrega: " + entrega.getStatus_entrega());
            System.out.println("-----------");

            idEntregas.add(entrega.getId_entrega());
        }

        return idEntregas;
    }

    public static void listarEntregas(){
        System.out.println("---LISTAR ENTREGAS---");

        var dao = new EntregaDAO();

        try{
            List<Entrega> entregas = dao.listarEntregaMCP();
            exibirEntregasMCP(entregas);

        }catch(SQLException erro){
            erro.printStackTrace();
            System.out.println("Erro ao listar entregas.");
        }
    }

    public static void exibirEntregasMCP (List<Entrega> entregas){

        for(Entrega entrega : entregas){
            System.out.println("----------------");
            System.out.println("ID da entrega: " + entrega.getId_entrega());
            System.out.println("ID do pedido: " + entrega.getId_pedido());
            System.out.println("ID do motorista: " + entrega.getId_pedido());
            System.out.println("Data saída: " + entrega.getData_saida());
            System.out.println("Data de entrega: " + entrega.getData_entrega());
            System.out.println("Status entrega: " + entrega.getStatus_entrega());
            System.out.println("Nome do motorista: " + entrega.getNome_motorista());
            System.out.println("Nome do cliente: " + entrega.getNome_cliente());
            System.out.println("----------------");

        }
    }

    public static void relatorioMaisEntregas(){
        System.out.println("---RELATORIO DE MOTORISTA COM MAIS ENTREGAS---");

        var dao = new EntregaDAO();

        try{
            List<Motorista> motorista = dao.maisEntregas();
            motoristaMaisEntregas(motorista);
        }catch(SQLException erro){
            erro.printStackTrace();
            System.out.println("Erro ao identificar motorista.");
        }
    }

    public static void motoristaMaisEntregas(List<Motorista> motorista){

        for(Motorista motora : motorista){
            System.out.println("ID do motorista: " + motora.getId_motora());
            System.out.println("Nome: " + motora.getNome());
            System.out.println("CNH: " + motora.getCnh());
            System.out.println("Veículo: " + motora.getVeiculo());
            System.out.println("Cidade base: " + motora.getCidadeBase());
            System.out.println("Total de entregas: " + motora.getTotal_entregas());

        }
    }


}