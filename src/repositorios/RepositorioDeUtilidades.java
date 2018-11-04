package repositorios;

import helpers.LeitorDeArquivo;
import modelos.Utilidade;

import java.util.ArrayList;

public class RepositorioDeUtilidades {
    private ArrayList<Utilidade> listaDeUtilidades = new ArrayList<>();

    public RepositorioDeUtilidades(){
        LeitorDeArquivo leitor = new LeitorDeArquivo("data/utilidades.csv");
        ArrayList<String> linhas= leitor.ler();

        for (String linha : linhas) {
            String[] partes = linha.split(";");
            String nome = partes[0];
            System.out.println(nome);
            double peso = Double.valueOf(partes[1]);
            System.out.println(peso);

            Utilidade l = new Utilidade(nome, peso);
            listaDeUtilidades.add(l);
        }
    }
    public ArrayList<Utilidade> getTodasAsUtilidades(){
        return this.listaDeUtilidades;
    }

    public Utilidade getUtilidadePorNome(String nome){
        for (Utilidade mantimento : this.listaDeUtilidades) {
            String nomeDoLocal = mantimento.getNome();
            if (nome.equals(nomeDoLocal)) {
                return mantimento;
            }
        }
        return null;
    }

}
