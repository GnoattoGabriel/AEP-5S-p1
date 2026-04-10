public class Servico {

    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private Prestador prestador;

    public Servico(int id, String nome, String descricao, double preco, Prestador prestador) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.prestador = prestador;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public double getPreco() { return preco; }
    public Prestador getPrestador() { return prestador; }

    public void exibirDetalhes() {
        System.out.println("  [" + id + "] " + nome
                + " - R$ " + String.format("%.2f", preco)
                + " | Prestador: " + prestador.getNome()
                + " (" + prestador.getCategoria() + ")");
    }
}
