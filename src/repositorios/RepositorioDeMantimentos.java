package repositorios;

import helpers.LeitorDeArquivo;
import modelos.Mantimento;

import java.util.ArrayList;

public class RepositorioDeMantimentos {
    private ArrayList<Mantimento> listaDeMantimentos = new ArrayList<>();

    public RepositorioDeMantimentos(){
        LeitorDeArquivo leitor = new LeitorDeArquivo("data/mantimentos.csv");
        ArrayList<String> linhas= leitor.ler();

        for (String linha : linhas) {
            String[] partes = linha.split(";");
            String nome = partes[0];
            System.out.println(nome);
            double peso = Double.valueOf(partes[1]);
            System.out.println(peso);
            double tamanho = Double.valueOf(partes[2]);
            System.out.println(tamanho);

            Mantimento l = new Mantimento(nome, peso, tamanho);
            listaDeMantimentos.add(l);
        }
    }
    public ArrayList<Mantimento> getTodosOsMantimentos(){
        return this.listaDeMantimentos;
    }

    public Mantimento getMantimentoPorNome(String nome){
        for (Mantimento mantimento : this.listaDeMantimentos) {
            String nomeDoLocal = mantimento.getNome();
            if (nome.equals(nomeDoLocal)) {
                return mantimento;
            }
        }
        return null;
    }

}
