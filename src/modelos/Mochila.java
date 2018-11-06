package modelos;

import java.util.ArrayList;

public class Mochila {
    private double capacidade;
    private ArrayList<ItemMochila> itensMochila;

    public void mostrarItens() {
        for(Item item : this.itensMochila){
            System.out.println(item.getNome());
        }
    }

    public void addItem(ItemMochila itemMochila) {
        itensMochila.add(itemMochila);
    }
}
