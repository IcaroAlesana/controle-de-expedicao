package modelos;

import repositorios.RepositorioDeItensBasicos;
import repositorios.RepositorioDeMantimentos;
import repositorios.RepositorioDeUtilidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Campista {
    private String nome;
    private String cpf;
    private LocalDate nascimento;
    private Mochila mochila;
    private Barraca barraca;
    private ArrayList<Utilidade> utilidades;
    private Scanner scanner;
    private RepositorioDeMantimentos repositorioDeMantimentos;
    private RepositorioDeItensBasicos repositorioDeItensBasicos;
    private RepositorioDeUtilidades repositorioDeUtilidades;

    public Campista(RepositorioDeMantimentos repositorioDeMantimentos, RepositorioDeItensBasicos repositorioDeItensBasicos,
                    RepositorioDeUtilidades repositorioDeUtilidades, double capacidadeMochila, String nome, Scanner scanner) {
        this.repositorioDeMantimentos = repositorioDeMantimentos;
        this.repositorioDeItensBasicos = repositorioDeItensBasicos;
        this.repositorioDeUtilidades = repositorioDeUtilidades;
        this.scanner = scanner;
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
    	System.out.println("Quantas pessoas a barraca suporta?");
    	int capacidadePessoas = scanner.nextInt();
    	System.out.println("Qual a coluna d'agua?");
    	int colunaDAgua = scanner.nextInt();
    	System.out.println("Qual o peso da barraca?");
    	double peso = scanner.nextDouble();
    	boolean avanco = false;
    	System.out.println("A barraca possui avanco para gaurdar equipamentos do lado de fora? Digite S para sim, ou N para nao.");
    	if (scanner.next().equals("S")) {
    		avanco = true;
    	}
        barraca = new Barraca(capacidadePessoas, colunaDAgua, peso, avanco);
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
