package modelos;

public class Item {
    private String nome;
    private int peso;
    private double tamanho;

    public Item(String nome, int peso, double tamanho) {
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

    public int getPeso() {
        return peso;
    }

    public double getTamanho() {
        return tamanho;
    }
}
