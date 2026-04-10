package models;

public class Prestador extends Usuario {

    private String categoria;
    private String descricao;
    private double avaliacao;
    private int totalServicos;

    public Prestador(int id, String nome, String email, String telefone,
                     String categoria, String descricao) {
        super(id, nome, email, telefone);
        this.categoria = categoria;
        this.descricao = descricao;
        this.avaliacao = 0.0;
        this.totalServicos = 0;
    }

    public String getCategoria() { return categoria; }
    public double getAvaliacao() { return avaliacao; }

    public void adicionarAvaliacao(double nota) {
        this.avaliacao = (this.avaliacao * totalServicos + nota) / (totalServicos + 1);
        this.totalServicos++;
    }

    @Override
    public void exibirPerfil() {
        System.out.println("=== models.Prestador ===");
        System.out.println("Nome     : " + getNome());
        System.out.println("Categoria: " + categoria);
        System.out.println("Descricao: " + descricao);
        System.out.printf("Avaliacao: %.1f estrelas%n", avaliacao);
        System.out.println("Servicos : " + totalServicos);
    }
}
