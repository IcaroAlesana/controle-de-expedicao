package br.com.udesc.controledeexpedicao.repositorios;

import java.util.ArrayList;

import br.com.udesc.controledeexpedicao.helpers.LeitorDeArquivo;
import br.com.udesc.controledeexpedicao.modelos.Mantimento;

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
            double volume = Double.valueOf(partes[2]);
            System.out.println(volume);

            Mantimento l = new Mantimento(nome, peso, volume);
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
