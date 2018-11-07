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

    public Campista(RepositorioDeMantimentos repositorioDeMantimentos, RepositorioDeItensBasicos repositorioDeItensBasicos,
                    RepositorioDeUtilidades repositorioDeUtilidades, double capacidadeMochila, String nome) {
        this.repositorioDeMantimentos = repositorioDeMantimentos;
        this.repositorioDeItensBasicos = repositorioDeItensBasicos;
        this.repositorioDeUtilidades = repositorioDeUtilidades;
        mochila = new Mochila(capacidadeMochila);
        utilidades = new ArrayList<>();

    }

    public String getNome() {
        return nome;
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
        ItemBasico itemBasico = repositorioDeItensBasicos.getItemBasicoPorNome(nome);
        mochila.addItemBasico(itemBasico);
    }

    public void addMantimentoNaMochila(String nome) {
        Mantimento mantimento = repositorioDeMantimentos.getMantimentoPorNome(nome);
        mochila.addMantimento(mantimento);
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

    public void mantimentosSuficientesIndividual(int dias) {
        ArrayList<Mantimento> mantimentosMochila = mochila.getMantimentos();
        int comida = 0;
        for (Mantimento mantimento : mantimentosMochila){
            if(mantimento.getNome().equals("Comida 1 dia")){
                comida ++;
            }
            if(comida < dias){
                System.out.println(nome + " nao possui comida suficiente.");
            }
        }

    }
}
