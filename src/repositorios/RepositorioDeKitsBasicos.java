package repositorios;

import helpers.LeitorDeArquivo;
import modelos.KitBasico;

import java.util.ArrayList;

public class RepositorioDeKitsBasicos {
    private ArrayList<KitBasico> listaDeKitsBasicos = new ArrayList<>();

    public RepositorioDeKitsBasicos(){
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

            KitBasico l = new KitBasico(nome, peso, volume);
            listaDeKitsBasicos.add(l);
        }
    }
    public ArrayList<KitBasico> getTodosOsKits(){
        return this.listaDeKitsBasicos;
    }

    public KitBasico getKitPorNome(String nome){
        for (KitBasico kitBasico : this.listaDeKitsBasicos) {
            String nomeDoLocal = kitBasico.getNome();
            if (nome.equals(nomeDoLocal)) {
                return kitBasico;
            }
        }
        return null;
    }
}
