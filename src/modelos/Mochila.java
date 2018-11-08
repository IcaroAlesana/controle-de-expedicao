package modelos;

import java.util.ArrayList;

public class Mochila {
    private double capacidade;
    private ArrayList<ItemBasico> itensBasicos;
    private ArrayList<Mantimento> mantimentos;

    public Mochila(double capacidade) {
        this.capacidade = capacidade;
        itensBasicos = new ArrayList<>();
        mantimentos = new ArrayList<>();
    }

    public void mostrarItens() {
        System.out.println("Itens basicos: ");
        for(Item item : itensBasicos){
            System.out.println(item.getNome());
        }

        System.out.println("Mantimentos: ");
        for(Item item : mantimentos){
            System.out.println(item.getNome());
        }
    }

    public void addItemBasico(ItemBasico itemBasico) {
        itensBasicos.add(itemBasico);
    }
    
    public void addMantimento(Mantimento mantimento) {
    	mantimentos.add(mantimento);
    }

    public ArrayList<ItemBasico> getItensBasicos() {
        return itensBasicos;
    }
    
    public ArrayList<Mantimento> getMantimentos() {
        return mantimentos;
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
