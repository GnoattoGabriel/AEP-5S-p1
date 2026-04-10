package ui;

import models.Cliente;
import models.Prestador;
import services.Servico;
import services.Sistema;
import models.Status;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static Sistema sistema = new Sistema();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        popularDadosIniciais();
        menu();
    }

    private static void menu() {
        boolean rodando = true;
        while (rodando) {
            exibirMenu();
            int opcao = lerOpcao();

            switch (opcao) {
                case 1 -> cadastrarSolicitacao();
                case 2 -> consultarProtocolo();
                case 3 -> sistema.listarServicos();
                case 4 -> atualizarStatus();
                case 5 -> {
                    System.out.println("\nSaindo do sistema.");
                    rodando = false;
                }
                default -> System.out.println("Opcao invalida.");
            }
        }
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n==============================");
        System.out.println("       CONECTA LOCAL");
        System.out.println("==============================");
        System.out.println("1. Nova solicitacao");
        System.out.println("2. Consultar protocolo");
        System.out.println("3. Listar servicos");
        System.out.println("4. Atualizar status");
        System.out.println("5. Sair");
        System.out.print("Escolha: ");
    }

    private static void cadastrarSolicitacao() {
        System.out.println("\n=== Nova Solicitacao ===");
        sistema.listarServicos();

        System.out.print("ID do servico: ");
        int idServico = lerOpcao();

        Servico servicoEscolhido = buscarServicoPorId(idServico);
        if (servicoEscolhido == null) {
            System.out.println("Servico nao encontrado.");
            return;
        }

        System.out.print("Seu nome: ");
        String nomeCliente = scanner.nextLine().trim();

        System.out.print("Seu e-mail: ");
        String emailCliente = scanner.nextLine().trim();

        System.out.print("Descricao do que precisa: ");
        String descricao = scanner.nextLine().trim();

        Cliente cliente = new Cliente(
                sistema.gerarIdCliente(),
                nomeCliente, emailCliente, "", ""
        );

        sistema.cadastrarSolicitacao(cliente, servicoEscolhido, descricao);
    }

    private static void consultarProtocolo() {
        System.out.print("\nDigite o protocolo: ");
        String protocolo = scanner.nextLine().trim();
        sistema.consultarProtocolo(protocolo);
    }

    private static void atualizarStatus() {
        System.out.print("\nProtocolo: ");
        String protocolo = scanner.nextLine().trim();

        System.out.println("Novo status:");
        System.out.println("1. ABERTA");
        System.out.println("2. EM_ANDAMENTO");
        System.out.println("3. FINALIZADA");
        System.out.println("4. CANCELADA");
        System.out.print("Escolha: ");
        int opcao = lerOpcao();

        Status novoStatus = switch (opcao) {
            case 1 -> Status.ABERTA;
            case 2 -> Status.EM_ANDAMENTO;
            case 3 -> Status.FINALIZADA;
            case 4 -> Status.CANCELADA;
            default -> null;
        };

        if (novoStatus != null) {
            sistema.atualizarStatus(protocolo, novoStatus);
        } else {
            System.out.println("Status invalido.");
        }
    }

    private static int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static Servico buscarServicoPorId(int id) {
        for (Servico s : sistema.getServicos()) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    private static void cadastrarPrestadoresIniciais(){
        Prestador maria = new Prestador(1, "Maria Silva", "maria@email.com", "(44) 99999-1111",
                "Diarista", "Limpeza residencial e comercial");
        Prestador joao = new Prestador(2, "Joao Costa", "joao@email.com", "(44) 99999-2222",
                "Pedreiro", "Construcao, reforma e acabamento");
        Prestador ana = new Prestador(3, "Ana Souza", "ana@email.com", "(44) 99999-3333",
                "Manicure", "Manicure e pedicure a domicilio");

        sistema.cadastrarUsuario(maria);
        sistema.cadastrarUsuario(joao);
        sistema.cadastrarUsuario(ana);

        sistema.cadastrarServico(new Servico(1, "Faxina completa", "Limpeza geral do imovel", 180.00, maria));
        sistema.cadastrarServico(new Servico(2, "Limpeza semanal", "Manutencao semanal do imovel", 90.00, maria));
        sistema.cadastrarServico(new Servico(3, "Reforma de banheiro", "Troca de revestimento e hidraulica", 1200.00, joao));
        sistema.cadastrarServico(new Servico(4, "Pequenos reparos", "Consertos gerais em alvenaria", 250.00, joao));
        sistema.cadastrarServico(new Servico(5, "Manicure + pedicure", "Atendimento completo em domicilio", 70.00, ana));

    }

    private static void popularDadosIniciais() {

        cadastrarPrestadoresIniciais();

    }
}
