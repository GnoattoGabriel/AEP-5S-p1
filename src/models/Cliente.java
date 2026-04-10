package models;

public class Cliente extends Usuario {

    private String endereco;
    private int totalPedidos;

    public Cliente(int id, String nome, String email, String telefone, String endereco) {
        super(id, nome, email, telefone);
        this.endereco = endereco;
        this.totalPedidos = 0;
    }

    public String getEndereco() { return endereco; }

    public void incrementarPedidos() {
        this.totalPedidos++;
    }

    @Override
    public void exibirPerfil() {
        System.out.println("=== models.Cliente ===");
        System.out.println("Nome    : " + getNome());
        System.out.println("Endereco: " + endereco);
        System.out.println("Pedidos : " + totalPedidos);
    }
}
