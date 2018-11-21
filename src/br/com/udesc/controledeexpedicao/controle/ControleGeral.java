package br.com.udesc.controledeexpedicao.controle;

import java.util.Scanner;

import br.com.udesc.controledeexpedicao.repositorios.RepositorioDeItensBasicos;
import br.com.udesc.controledeexpedicao.repositorios.RepositorioDeMantimentos;
import br.com.udesc.controledeexpedicao.repositorios.RepositorioDeUtilidades;
import br.com.udesc.controledeexpedicao.servicos.ServicoDeCampistas;

public class ControleGeral{
	
    public final static int ORGANIZAR_EXPEDICAO = 1;
    public final static int ORGANIZAR_CAMPISTA = 2;
    public final static int SAIR = 0;
    

	private RepositorioDeItensBasicos repositorioDeItensBasicos;
	private RepositorioDeMantimentos repositorioDeMantimentos;
	private RepositorioDeUtilidades repositorioDeUtilidades;
	
	private ServicoDeCampistas servicoDeCampistas;
    
    private ControleDeCampista controleDeCampista;
    private ControleDeExpedicao controleDeExpedicao;
    

    private Scanner scanner;
    
    public ControleGeral(){
    	this.scanner = new Scanner(System.in);    	

    	repositorioDeItensBasicos = new RepositorioDeItensBasicos();
    	repositorioDeMantimentos = new RepositorioDeMantimentos();
    	repositorioDeUtilidades = new RepositorioDeUtilidades();
    	
    	servicoDeCampistas = new ServicoDeCampistas(scanner);
    	
    	controleDeCampista = new ControleDeCampista(repositorioDeMantimentos, repositorioDeItensBasicos, repositorioDeUtilidades, scanner);
    	controleDeExpedicao = new ControleDeExpedicao(servicoDeCampistas);
    }
    
    public void iniciar() {
    	int escolha = -1;
        while(escolha != ControleGeral.SAIR){
            System.out.println("Escolha algo:");
            System.out.println( ControleGeral.ORGANIZAR_EXPEDICAO+") Organizar expedicao");
            System.out.println( ControleGeral.ORGANIZAR_CAMPISTA+") Organizar campista");
            System.out.println( ControleGeral.SAIR+") Sair");
            escolha = this.scanner.nextInt();

            switch(escolha){
                case ControleGeral.ORGANIZAR_EXPEDICAO:
                    this.controleDeExpedicao.iniciar();
                break;
                case ControleGeral.ORGANIZAR_CAMPISTA:
                    this.controleDeCampista.iniciar();
                break;
                case ControleGeral.SAIR:
                    this.encerrar();
                break;
            }
        }
    }
    
    public void encerrar(){
        System.out.println("programa finalizado");
    }
}
