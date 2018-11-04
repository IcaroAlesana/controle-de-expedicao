package principal;

import modelos.Item;
import repositorios.RepositorioDeItens;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        RepositorioDeItens rep = new RepositorioDeItens();
        ArrayList<Item> itens =  rep.getTodosOsItens();
        int i=0;
        while(itens.get(i) != null){
            System.out.println(itens.get(i).getNome());
            i++;
        }
    }
}
