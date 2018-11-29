package br.com.udesc.controledeexpedicao.controle;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.udesc.controledeexpedicao.modelos.Campista;
import br.com.udesc.controledeexpedicao.modelos.Expedicao;
import br.com.udesc.controledeexpedicao.servicos.ServicoDeCampistas;

public class ControleDeExpedicao {

    public final static int ADICIONAR_CAMPISTA = 1;
	public final static int VERIFICAR_MANTIMENTOS = 2;
    public final static int VOLTAR = 0;
	
    private Scanner scanner;
    
    private Expedicao expedicao;
    
    private ServicoDeCampistas servicoDeCampistas;

    public ControleDeExpedicao(ServicoDeCampistas servicoDeCampistas, Scanner scanner, Expedicao expedicao) {
    	
    	this.scanner = scanner;
    	
    	this.expedicao = expedicao;
    	
        this.servicoDeCampistas = servicoDeCampistas;
    }
    
    public void iniciar() {
    	int escolha = -1;
        while(escolha != ControleDeExpedicao.VOLTAR){
            System.out.println("Escolha algo:");
            System.out.println( ControleDeExpedicao.ADICIONAR_CAMPISTA+") Adicionar campista");
            System.out.println( ControleDeExpedicao.VERIFICAR_MANTIMENTOS+") Verificar mantimentos do grupo");
            System.out.println( ControleDeExpedicao.VOLTAR+") Voltar ao menu anterior");
            escolha = this.scanner.nextInt();
            scanner.nextLine();

            switch(escolha){
                case ControleDeExpedicao.VERIFICAR_MANTIMENTOS:
                    this.mantimentosSuficientesGrupo();
                break;
                case ControleDeExpedicao.ADICIONAR_CAMPISTA:
                    adicionarCampista();
                break;
                case ControleDeExpedicao.VOLTAR:
                    this.voltar();
                break;
            }
        }
    }
    
    public void voltar(){
    }

    public void adicionarCampista() {
        System.out.println("Qual o nome do Campista?");
        String nome = scanner.nextLine();
        System.out.println("Qual a capacidade da mochila do campista?");
        double capacidadeMochila = scanner.nextDouble();
        scanner.nextLine();
        servicoDeCampistas.addCampista(capacidadeMochila,nome);
    }


    public void mantimentosSuficientesGrupo() {
        int espacoEmBarracas = 0;
        ArrayList<Campista> campistas = servicoDeCampistas.getTodosOsCampistas();
        boolean ok = true;
        for (Campista campista : campistas) {
            boolean comida = campista.comidaSuficienteIndividual(expedicao.getDias());
            boolean cafe = campista.cafeSuficienteIndividual(expedicao.getDias());
            if (campista.temBarraca()) {
                espacoEmBarracas += campista.espacoNaBarraca();
            }
            if (comida == false) {
                System.out.println("O campista" + campista.getNome()+ "nao possui comida suficiente.");
                ok = false;
            }
            if (cafe == false) {
                System.out.println("O campista" + campista.getNome()+ "nao possui cafe suficiente.");
                ok = false;
            }
        }
        if(espacoEmBarracas < campistas.size()){
            System.out.println("O grupo possui " + espacoEmBarracas + "lugares em barracas, para" + campistas.size() + "campistas.");
            ok = false;
        }

        if (ok == true) {
            System.out.println("O grupo esta preparado para a expedicao.");
        }
    }
}
