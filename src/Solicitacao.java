import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Solicitacao {

    private String protocolo;
    private Cliente cliente;
    private Servico servico;
    private Status status;
    private String descricao;
    private String dataCriacao;

    public Solicitacao(String protocolo, Cliente cliente, Servico servico, String descricao) {
        this.protocolo = protocolo;
        this.cliente = cliente;
        this.servico = servico;
        this.descricao = descricao;
        this.status = Status.ABERTA;
        this.dataCriacao = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }

    public String getProtocolo() { return protocolo; }
    public Status getStatus() { return status; }

    /** clean code: uso de enum garante que so valores validos sejam aceitos */
    public void atualizarStatus(Status novoStatus) {
        this.status = novoStatus;
        System.out.println("Status atualizado para: " + novoStatus);
    }

    public void exibirDetalhes() {
        System.out.println("--------------------------------");
        System.out.println("Protocolo : " + protocolo);
        System.out.println("Cliente   : " + cliente.getNome());
        System.out.println("Servico   : " + servico.getNome());
        System.out.println("Descricao : " + descricao);
        System.out.println("Status    : " + status);
        System.out.println("Criado em : " + dataCriacao);
        System.out.println("--------------------------------");
    }
}
