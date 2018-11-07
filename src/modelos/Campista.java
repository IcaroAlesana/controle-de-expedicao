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
        mochila = new Mochila();
        utilidades = new ArrayList<>();

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
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

    public void addBarraca() {
        barraca = new Barraca();
    }

    public boolean temBarraca() {
        return (barraca != null);
    }

    public void mantimentosSuficientes(int dias) {
        ArrayList<ItemMochila> itensMochila = mochila.getItensMochila();
        for (ItemMochila itemMochila : itensMochila){
            itemMochila.
        }

    }
}
