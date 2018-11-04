package repositorios;

import helpers.LeitorDeArquivo;
import modelos.Item;

import java.util.ArrayList;

public class RepositorioDeItens {
    private ArrayList<Item> listaDeItens = new ArrayList<Item>();

    public RepositorioDeItens(){
        LeitorDeArquivo leitor = new LeitorDeArquivo("data/itens.csv");
        ArrayList<String> linhas= leitor.ler();

        for(int i =0;i<linhas.size();i++){
            String nome = linhas.get(i);

            Item l = new Item(nome);
            listaDeItens.add(l);
        }
    }
    public ArrayList<Item> getTodosOsItens(){
        return this.listaDeItens;
    }

    public Item getItemPorNome(String nome){
        for(int i = 0;i<this.listaDeItens.size();i++){
            Item item = this.listaDeItens.get(i);
            String nomeDoLocal = item.getNome();
            if( nome.equals(nomeDoLocal) ){
                return item;
            }
        }
        return null;
    }

}
