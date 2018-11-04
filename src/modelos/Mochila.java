package modelos;

import java.util.ArrayList;

public class Mochila {
    private double capacidade;
    private ArrayList<Item> itens;

    public void mostrarItens() {
        for(Item item : this.itens){
            System.out.println(item.getNome());
        }
    }

    public void addItem(Item item) {
        itens.add(item);
    }
}
