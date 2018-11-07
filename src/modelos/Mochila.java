package modelos;

import java.util.ArrayList;

public class Mochila {
    private double capacidade;
    private ArrayList<ItemBasico> itensBasicos;
    private ArrayList<Mantimento> mantimentos;

    public Mochila(int capacidade) {
        this.capacidade = capacidade;
        itensBasicos = new ArrayList<>();
        mantimentos = new ArrayList<>();
    }

    public void mostrarItens() {
        System.out.println("Itens basicos: ");
        for(ItemMochila itemMochila : itensBasicos){
            System.out.println(itemMochila.getNome());
        }

        System.out.println("Mantimentos: ");
        for(ItemMochila itemMochila : mantimentos){
            System.out.println(itemMochila.getNome());
        }
    }

    public void addItem(ItemBasico itemMochilaBasico) {
        itensBasicos.add(itemMochilaBasico);
    }

    public ArrayList<ItemBasico> getItensMochila() {
        return itensBasicos;
    }

    public boolean dentroDaCapacidade() {
        double volumeTotal = 0;
        for(ItemMochila itemMochila : itensBasicos){
            volumeTotal += itemMochila.getVolume();
        }

        System.out.println("Mantimentos: ");
        for(ItemMochila itemMochila : mantimentos){
            volumeTotal += itemMochila.getVolume();
        }

        return volumeTotal < capacidade;
    }
}
