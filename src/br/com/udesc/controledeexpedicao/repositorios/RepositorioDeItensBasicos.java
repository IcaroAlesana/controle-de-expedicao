package br.com.udesc.controledeexpedicao.repositorios;

import java.util.ArrayList;

import br.com.udesc.controledeexpedicao.helpers.LeitorDeArquivo;
import br.com.udesc.controledeexpedicao.modelos.ItemBasico;

public class RepositorioDeItensBasicos {
    private ArrayList<ItemBasico> listaDeItensBasicos = new ArrayList<>();

    public RepositorioDeItensBasicos(){
        LeitorDeArquivo leitor = new LeitorDeArquivo("data/kits.csv");
        ArrayList<String> linhas= leitor.ler();

        for (String linha : linhas) {
            String[] partes = linha.split(";");
            String nome = partes[0];
            double peso = Double.valueOf(partes[1]);
            double volume = Double.valueOf(partes[2]);

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
    
    public void imprimeListaDeItensBasicos() {
    	for (ItemBasico itemBasico : listaDeItensBasicos) {
    		System.out.println(itemBasico.getNome());
    	}
    }
}
