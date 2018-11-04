package repositorios;

import helpers.LeitorDeArquivo;
import modelos.Item;

import java.util.ArrayList;

public class RepositorioDeItens {
    private ArrayList<Item> listaDeItens = new ArrayList<>();

    public RepositorioDeItens(){
        LeitorDeArquivo leitor = new LeitorDeArquivo("data/itens.csv");
        ArrayList<String> linhas= leitor.ler();

        for (String linha : linhas) {
            String[] partes = linha.split(";");
            String nome = partes[0];
            int peso = Integer.parseInt(partes[1]);
            double tamanho = Double.valueOf(partes[2]);

            Item l = new Item(nome, peso, tamanho);
            listaDeItens.add(l);
        }
    }
    public ArrayList<Item> getTodosOsItens(){
        return this.listaDeItens;
    }

    public Item getItemPorNome(String nome){
        for (Item item : this.listaDeItens) {
            String nomeDoLocal = item.getNome();
            if (nome.equals(nomeDoLocal)) {
                return item;
            }
        }
        return null;
    }

}
