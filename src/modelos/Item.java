package modelos;

public class Item {
    private String nome;
    private int peso;
    private int tamanho;

    public Item(String nome, int peso, int tamanho) {
        this.nome = nome;
        this.peso = peso;
        this.tamanho = tamanho;
    }
    public Item(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
