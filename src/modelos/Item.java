package modelos;

public abstract class Item {
    private String nome;
    private double peso;

    public String getNome() {
        return nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
