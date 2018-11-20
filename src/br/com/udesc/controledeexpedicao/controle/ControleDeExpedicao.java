package br.com.udesc.controledeexpedicao.controle;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.udesc.controledeexpedicao.modelos.Campista;
import br.com.udesc.controledeexpedicao.repositorios.RepositorioDeItensBasicos;
import br.com.udesc.controledeexpedicao.repositorios.RepositorioDeMantimentos;
import br.com.udesc.controledeexpedicao.repositorios.RepositorioDeUtilidades;

public class ControleDeExpedicao {
	private RepositorioDeItensBasicos repositorioDeItensBasicos;
	private RepositorioDeMantimentos repositorioDeMantimentos;
	private RepositorioDeUtilidades repositorioDeUtilidades;
	private Scanner scanner = new Scanner(System.in);
    private ArrayList<Campista> campistas;
    private int dias;

    public ControleDeExpedicao() {
        campistas = new ArrayList<>();
    }


    public void mantimentosSuficientesGrupo() {
        for (Campista campista : campistas) {
            campista.mantimentosSuficientesIndividual(dias);
        }
    }
    
    public void addCampista() {
    	System.out.println("Qual o nome do Campista?");
    	String nome = scanner.nextLine();
    	System.out.println("Qual a capacidade da mochila do campista?");
    	double capacidadeMochila = scanner.nextDouble();
    	
    	Campista campista = new Campista(repositorioDeMantimentos, repositorioDeItensBasicos,
                    repositorioDeUtilidades, capacidadeMochila, nome, scanner);
    	campistas.add(campista);
    }

    public Campista getCampistaPorNome(String nome) {
        for (Campista campista : campistas) {
            String nomeDoCampista = campista.getNome();
            if (nome.equals(nomeDoCampista)) {
                return campista;
            }
        }
        return null;
    }

    public Campista getCampistaPorCPF(String cpf) {
        for (Campista campista : campistas) {
            String cpfDoCampista = campista.getCpf();
            if (cpf.equals(cpfDoCampista)) {
                return campista;
            }
        }
        return null;
    }
}
