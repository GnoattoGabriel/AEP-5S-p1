package services;

import models.Cliente;
import models.Status;
import models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Sistema {

    private List<Usuario> usuarios;
    private List<Servico> servicos;
    private List<Solicitacao> solicitacoes;
    private int proximoIdCliente = 1;

    public Sistema() {
        this.usuarios = new ArrayList<>();
        this.servicos = new ArrayList<>();
        this.solicitacoes = new ArrayList<>();
    }

    public int gerarIdCliente() {
        return proximoIdCliente++;
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("models.Usuario cadastrado: " + usuario.getNome());
    }

    public void cadastrarServico(Servico servico) {
        servicos.add(servico);
        System.out.println("services.Servico cadastrado: " + servico.getNome());
    }

    public Solicitacao cadastrarSolicitacao(Cliente cliente, Servico servico, String descricao) {
        String protocolo = gerarProtocolo();
        Solicitacao solicitacao = new Solicitacao(protocolo, cliente, servico, descricao);
        solicitacoes.add(solicitacao);
        cliente.incrementarPedidos();
        System.out.println("\nservices.Solicitacao criada! Protocolo: " + protocolo);
        return solicitacao;
    }

    public void consultarProtocolo(String protocolo) {
        Solicitacao encontrada = buscarPorProtocolo(protocolo);
        if (encontrada != null) {
            encontrada.exibirDetalhes();
        } else {
            System.out.println("Protocolo nao encontrado: " + protocolo);
        }
    }

    public void listarServicos() {
        if (servicos.isEmpty()) {
            System.out.println("Nenhum servico cadastrado.");
            return;
        }
        System.out.println("\n=== Servicos disponiveis ===");
        for (Servico s : servicos) {
            s.exibirDetalhes();
        }
    }

    public void listarServicosPorCategoria(String categoria) {
        System.out.println("\n=== Servicos: " + categoria + " ===");
        boolean encontrou = false;
        for (Servico s : servicos) {
            if (s.getPrestador().getCategoria().equalsIgnoreCase(categoria)) {
                s.exibirDetalhes();
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum servico encontrado para: " + categoria);
        }
    }

    public void atualizarStatus(String protocolo, Status novoStatus) {
        Solicitacao solicitacao = buscarPorProtocolo(protocolo);
        if (solicitacao != null) {
            solicitacao.atualizarStatus(novoStatus);
        } else {
            System.out.println("Protocolo invalido: " + protocolo);
        }
    }

    private String gerarProtocolo() {
        return "CL-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    private Solicitacao buscarPorProtocolo(String protocolo) {
        for (Solicitacao s : solicitacoes) {
            if (s.getProtocolo().equalsIgnoreCase(protocolo)) {
                return s;
            }
        }
        return null;
    }

    public List<Servico> getServicos() { return servicos; }
    public List<Solicitacao> getSolicitacoes() { return solicitacoes; }

}
