package br.com.udesc.controledeexpedicao.repositorios;

import java.util.ArrayList;

import br.com.udesc.controledeexpedicao.helpers.LeitorDeArquivo;
import br.com.udesc.controledeexpedicao.modelos.Utilidade;

public class RepositorioDeUtilidades {
    private ArrayList<Utilidade> listaDeUtilidades = new ArrayList<>();

    public ArrayList<Utilidade> getListaDeUtilidades() {
        return listaDeUtilidades;
    }

    public RepositorioDeUtilidades(){
        LeitorDeArquivo leitor = new LeitorDeArquivo("data/utilidades.csv");
        ArrayList<String> linhas= leitor.ler();

        for (String linha : linhas) {
            String[] partes = linha.split(";");
            String nome = partes[0];
            double peso = Double.valueOf(partes[1]);

            Utilidade u = new Utilidade(nome, peso);
            listaDeUtilidades.add(u);
        }
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
