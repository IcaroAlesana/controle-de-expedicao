package br.com.udesc.controledeexpedicao.modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import br.com.udesc.controledeexpedicao.exceptions.EspacoInsuficienteException;
import br.com.udesc.controledeexpedicao.repositorios.RepositorioDeItensBasicos;
import br.com.udesc.controledeexpedicao.repositorios.RepositorioDeMantimentos;
import br.com.udesc.controledeexpedicao.repositorios.RepositorioDeUtilidades;

public class Campista {
    private String nome;
    private String cpf;
    private LocalDate nascimento;
    private Mochila mochila;
    private Barraca barraca;
    private ArrayList<Utilidade> utilidades;


    public Campista(double capacidadeMochila, String nome) {
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
