package modelos;

public class KitBasico extends Item{
    private String nome;
    private double peso;
    private double volume;

    public KitBasico(String nome, double peso, double volume) {
        this.nome = nome;
        this.peso = peso;
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }
}
