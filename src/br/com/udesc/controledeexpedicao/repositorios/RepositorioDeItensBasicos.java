package repositorios;

import helpers.LeitorDeArquivo;
import modelos.ItemBasico;

import java.util.ArrayList;

public class RepositorioDeItensBasicos {
    private ArrayList<ItemBasico> listaDeItensBasicos = new ArrayList<>();

    public RepositorioDeItensBasicos(){
        LeitorDeArquivo leitor = new LeitorDeArquivo("data/kits.csv");
        ArrayList<String> linhas= leitor.ler();

        for (String linha : linhas) {
            String[] partes = linha.split(";");
            String nome = partes[0];
            System.out.println(nome);
            double peso = Double.valueOf(partes[1]);
            System.out.println(peso);
            double volume = Double.valueOf(partes[2]);
            System.out.println(volume);

            ItemBasico l = new ItemBasico(nome, peso, volume);
            listaDeItensBasicos.add(l);
        }
    }
    public ArrayList<ItemBasico> getTodosOsItensBasicos(){
        return this.listaDeItensBasicos;
    }

    public ItemBasico getItemBasicoPorNome(String nome){
        for (ItemBasico itemBasico : this.listaDeItensBasicos) {
            String nomeDoLocal = itemBasico.getNome();
            if (nome.equals(nomeDoLocal)) {
                return itemBasico;
            }
        }
        return null;
    }
}
