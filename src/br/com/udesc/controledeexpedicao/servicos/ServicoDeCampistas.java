package br.com.udesc.controledeexpedicao.servicos;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.udesc.controledeexpedicao.modelos.Campista;

public class ServicoDeCampistas {

    private ArrayList<Campista> campistas;
    private Scanner scanner;

    public ServicoDeCampistas (Scanner scanner) {
    	campistas = new ArrayList<>();
    	this.scanner = scanner;
    }
    
    public void addCampista() {
    	scanner.nextLine();
    	System.out.println("Qual o nome do Campista?");
    	String nome = scanner.nextLine();
    	
    	System.out.println("Qual a capacidade da mochila do campista?");
    	double capacidadeMochila = scanner.nextDouble();    	
    	scanner.nextLine();
    	
    	Campista campista = new Campista(capacidadeMochila, nome);
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
    
    public ArrayList<Campista> getTodosOsCampistas() {
    	return this.campistas;
    }
}
