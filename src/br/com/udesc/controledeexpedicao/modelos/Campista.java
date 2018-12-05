package br.com.udesc.controledeexpedicao.modelos;

import java.time.LocalDate;
import java.util.ArrayList;

import br.com.udesc.controledeexpedicao.exceptions.EspacoInsuficienteException;

public class Campista {
    private String nome;
    private String cpf;
    private LocalDate nascimento;
    private Mochila mochila;
    private Barraca barraca;
    private ArrayList<Utilidade> utilidades;


    public Campista(double capacidadeMochila, String nome) {
        this.nome = nome;
        mochila = new Mochila(capacidadeMochila);
        utilidades = new ArrayList<>();
    }
    public Campista(double capacidadeMochila, String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        mochila = new Mochila(capacidadeMochila);
        utilidades = new ArrayList<>();
    }
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Mochila getMochila() {
        return mochila;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public void addItemBasicoNaMochila(ItemBasico itemBasico) {
        try {
        	mochila.addItemBasico(itemBasico);
        } catch (EspacoInsuficienteException ex) {
        	ex.getMessage();
        }
    }

    public void addMantimentoNaMochila(Mantimento mantimento) {
        try {
			mochila.addMantimento(mantimento);
		} catch (EspacoInsuficienteException ex) {
			ex.getMessage();
		}
    }

    public void addUtilidade(Utilidade utilidade) {
        utilidades.add(utilidade);
    }

    public void addBarraca(int capacidadePessoas, int colunaDAgua, double peso, boolean avanco) {
        barraca = new Barraca(capacidadePessoas, colunaDAgua, peso, avanco);
    }

    public int espacoNaBarraca() {
        return barraca.getCapacidadePessoas();
    }

    public boolean temBarraca() {
        return (barraca != null);
    }

    public boolean comidaSuficienteIndividual(int dias) {
        ArrayList<Mantimento> mantimentosMochila = mochila.getMantimentos();
        int comida = 0;
        for (Mantimento mantimento : mantimentosMochila){
            if(mantimento.getNome().equals("Comida 1 dia")){
                comida ++;
            }
        }
        return comida >= dias;
    }
    public boolean cafeSuficienteIndividual(int dias) {
        ArrayList<Mantimento> mantimentosMochila = mochila.getMantimentos();
        int comida = 0;
        for (Mantimento mantimento : mantimentosMochila){
            if(mantimento.getNome().equals("Cafe 1 dia")){
                comida ++;
            }
        }
        return comida >= dias;
    }
}
