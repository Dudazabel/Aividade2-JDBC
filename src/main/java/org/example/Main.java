package org.example;

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

            }
            case 3 ->{

            }
            case 4 ->{

            }
            case 5 ->{

            }
            case 6 ->{

            }
            case 7 ->{

            }
            case 8 ->{

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
        System.out.println("---CADASTRAR CLIENTE---");

    }


}