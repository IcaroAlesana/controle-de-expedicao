package modelos;

public class Mantimento extends Item {
    private String nome;
    private double peso;
    private double tamanho;

    public Mantimento(String nome, double peso, double tamanho) {
        this.nome = nome;
        this.peso = peso;
        this.tamanho = tamanho;
    }

    public double getTamanho() {
        return tamanho;
    }
}
