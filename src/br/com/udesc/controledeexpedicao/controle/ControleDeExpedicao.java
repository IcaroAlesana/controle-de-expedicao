package br.com.udesc.controledeexpedicao.controle;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.udesc.controledeexpedicao.modelos.Campista;
import br.com.udesc.controledeexpedicao.modelos.Expedicao;
import br.com.udesc.controledeexpedicao.servicos.ServicoDeCampistas;

public class ControleDeExpedicao {
	
	public final static int VERIFICAR_MANTIMENTOS = 1;
    public final static int ADICIONAR_CAMPISTA = 2;
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
            System.out.println( ControleDeExpedicao.VERIFICAR_MANTIMENTOS+") Organizar expedicao");
            System.out.println( ControleDeExpedicao.ADICIONAR_CAMPISTA+") Organizar campista");
            System.out.println( ControleDeExpedicao.VOLTAR+") Voltar ao menu anterior");
            escolha = this.scanner.nextInt();

            switch(escolha){
                case ControleDeExpedicao.VERIFICAR_MANTIMENTOS:
                    this.mantimentosSuficientesGrupo();
                break;
                case ControleDeExpedicao.ADICIONAR_CAMPISTA:
                    servicoDeCampistas.addCampista();
                break;
                case ControleDeExpedicao.VOLTAR:
                    this.voltar();
                break;
            }
        }
    }
    
    public void voltar(){
        System.out.println("programa finalizado");
    }


    public void mantimentosSuficientesGrupo() {
        int espacoEmBarracas = 0;
        ArrayList<Campista> campistas = servicoDeCampistas.getTodosOsCampistas();
        for (Campista campista : campistas) {
            campista.mantimentosSuficientesIndividual(expedicao.getDias());
            if (campista.temBarraca()) {
                espacoEmBarracas += campista.espacoNaBarraca();
            }
        }
        if(espacoEmBarracas < campistas.size()){
            System.out.println("O grupo possui " + espacoEmBarracas + "lugares em barracas, para" + campistas.size() + "campistas.");
        }
    }
}
