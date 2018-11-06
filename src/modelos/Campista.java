package modelos;

import repositorios.RepositorioDeItensBasicos;
import repositorios.RepositorioDeMantimentos;
import repositorios.RepositorioDeUtilidades;

import java.time.LocalDate;
import java.util.ArrayList;

public class Campista {
    private String nome;
    private String cpf;
    private LocalDate nascimento;
    private Mochila mochila;
    private Barraca barraca;
    private ArrayList<Utilidade> utilidades;
    private RepositorioDeMantimentos repositorioDeMantimentos;
    private RepositorioDeItensBasicos repositorioDeItensBasicos;
    private RepositorioDeUtilidades repositorioDeUtilidades;

    public Campista() {
        repositorioDeMantimentos = new RepositorioDeMantimentos();
        repositorioDeItensBasicos = new RepositorioDeItensBasicos();
        repositorioDeUtilidades = new RepositorioDeUtilidades();

    }

    public void addItemBasicoNaMochila(String nome) {
        ItemMochila itemMochila = repositorioDeItensBasicos.getItemBasicoPorNome(nome);
        mochila.addItem(itemMochila);
    }

    public void addMantimentoNaMochila(String nome) {
        ItemMochila itemMochila = repositorioDeMantimentos.getMantimentoPorNome(nome);
        mochila.addItem(itemMochila);
    }

    public void addUtilidade(String nome) {
        Utilidade utilidade = repositorioDeUtilidades.getUtilidadePorNome(nome);
        utilidades.add(utilidade);
    }


}
