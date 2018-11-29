package br.com.udesc.controledeexpedicao.controle;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.udesc.controledeexpedicao.exceptions.ItemNaoEncontradoException;
import br.com.udesc.controledeexpedicao.modelos.Campista;
import br.com.udesc.controledeexpedicao.modelos.Expedicao;
import br.com.udesc.controledeexpedicao.modelos.ItemBasico;
import br.com.udesc.controledeexpedicao.modelos.Mantimento;
import br.com.udesc.controledeexpedicao.modelos.Utilidade;
import br.com.udesc.controledeexpedicao.repositorios.RepositorioDeItensBasicos;
import br.com.udesc.controledeexpedicao.repositorios.RepositorioDeMantimentos;
import br.com.udesc.controledeexpedicao.repositorios.RepositorioDeUtilidades;
import br.com.udesc.controledeexpedicao.servicos.ServicoDeCampistas;

import javax.swing.text.Utilities;

public class ControleDeCampista {
	
	public final static int VERIFICAR_MANTIMENTOS = 1;
    public final static int ADICIONAR_ITEM_BASICO = 2;
    public final static int ADICIONAR_MANTIMENTO = 3;
    public final static int ADICIONAR_UTILIDADE = 4;
    public final static int ADICIONAR_BARRACA = 5;
    public final static int VOLTAR = 0;
    
    private Expedicao expedicao;
    
    private ServicoDeCampistas servicoDeCampistas;
	
    private RepositorioDeMantimentos repositorioDeMantimentos;
    private RepositorioDeItensBasicos repositorioDeItensBasicos;
    private RepositorioDeUtilidades repositorioDeUtilidades;
    private Scanner scanner;
    
    

    public ControleDeCampista(RepositorioDeMantimentos repositorioDeMantimentos, RepositorioDeItensBasicos repositorioDeItensBasicos,
                              RepositorioDeUtilidades repositorioDeUtilidades, Scanner scanner, ServicoDeCampistas servicoDeCampistas, Expedicao expedicao) {
        this.repositorioDeMantimentos = repositorioDeMantimentos;
        this.repositorioDeItensBasicos = repositorioDeItensBasicos;
        this.repositorioDeUtilidades = repositorioDeUtilidades;
        this.scanner = scanner;
        
        this.servicoDeCampistas = servicoDeCampistas;
        
        this.expedicao = expedicao;
    }
    
    public void iniciar() {
        System.out.println("Campistas:");
        servicoDeCampistas.imprimeCampistas();
    	System.out.println("Digite o nome do campista");
    	Campista campista = servicoDeCampistas.getCampistaPorNome(scanner.nextLine());
    	int escolha = -1;
        while(escolha != ControleDeCampista.VOLTAR){
            System.out.println("Escolha algo:");
            System.out.println( ControleDeCampista.VERIFICAR_MANTIMENTOS+") Verificar mantimentos do campista");
            System.out.println( ControleDeCampista.ADICIONAR_ITEM_BASICO+") Colocar item basico na mochila do campista");
            System.out.println( ControleDeCampista.ADICIONAR_MANTIMENTO+") Colocar mantimento na mochila do campista");
            System.out.println( ControleDeCampista.ADICIONAR_UTILIDADE+") Adicionar utilidade que campista irá carregar");
            System.out.println( ControleDeCampista.ADICIONAR_BARRACA+") Adicionar barraca que campista irá carregar");
            System.out.println( ControleDeCampista.VOLTAR+") Voltar ao menu anterior");
            escolha = this.scanner.nextInt();
            scanner.nextLine();

            switch(escolha){
                case ControleDeCampista.VERIFICAR_MANTIMENTOS:
                	verificarMantimentos(campista);
                break;
                case ControleDeCampista.ADICIONAR_ITEM_BASICO:
                	repositorioDeItensBasicos.imprimeListaDeItensBasicos();
                	System.out.println("Escreva o nome do item que deseja adicionar a mochila do campista");
                	String nomeItem = scanner.nextLine();
                	addItemBasicoMochilaCampista(campista, nomeItem);
                break;
                case ControleDeCampista.ADICIONAR_MANTIMENTO:
                    repositorioDeMantimentos.imprimeListaDeMantimentos();
                    System.out.println("Escreva o nome do mantimento que deseja adicionar a mochila do campista");
                    String nomeMantimento = scanner.nextLine();
                    addMantimentoMochilaCampista(campista, nomeMantimento);
                break;
                case ControleDeCampista.ADICIONAR_UTILIDADE:
                    imprimeListaDeUtilidades();
                    System.out.println("Escreve o nome da utilidade que o campista deve carregar");
                    String nomeUtilidade = scanner.nextLine();
                    addUtilidadeCampista(campista, nomeUtilidade);
                break;
                case ControleDeCampista.ADICIONAR_BARRACA:
                    addBarracaCampista(campista);
                case ControleDeCampista.VOLTAR:
                    this.voltar();
                break;
            }
        }
    }
    
    public void voltar(){
    }

    public void verificarMantimentos(Campista campista){
        boolean comida = campista.comidaSuficienteIndividual(expedicao.getDias());
        boolean cafe = campista.cafeSuficienteIndividual(expedicao.getDias());
        if (comida == false) {
            System.out.println("Nao possui comida suficiente");
        }
        if (cafe == false){
            System.out.println("Nao possui cafe suficiente");
        }

        if (comida == true && cafe == true) {
            System.out.println("Esta preparado para a expedicao");
        }
    }

    private void imprimeListaDeUtilidades(){
        System.out.println("Lista de utilidades:");
        for (Utilidade utilidade : repositorioDeUtilidades.getListaDeUtilidades()) {
            System.out.println(utilidade.getNome());
        }
    }

    public void addItemBasicoMochilaCampista(Campista campista, String nome) {
        ItemBasico itemBasico = repositorioDeItensBasicos.getItemBasicoPorNome(nome);
        try {
            if(itemBasico == null){
                throw new ItemNaoEncontradoException();
            }
            campista.addItemBasicoNaMochila(itemBasico);
        } catch (ItemNaoEncontradoException e) {
        }
    }

    public void addMantimentoMochilaCampista(Campista campista, String nome) {
        Mantimento mantimento = repositorioDeMantimentos.getMantimentoPorNome(nome);
        try {
            if(mantimento == null) {
                throw new ItemNaoEncontradoException();
            }
            campista.addMantimentoNaMochila(mantimento);
        }  catch (ItemNaoEncontradoException e) {
        }
    }

    public void addUtilidadeCampista(Campista campista, String nome) {
        Utilidade utilidade = repositorioDeUtilidades.getUtilidadePorNome(nome);
        try {
            if(utilidade == null) {
                throw new ItemNaoEncontradoException();
            }
            campista.addUtilidade(utilidade);
        }  catch (ItemNaoEncontradoException e) {
        }
    }

    public void addBarracaCampista(Campista campista) {
        System.out.println("Quantas pessoas a barraca suporta?");
        int capacidadePessoas = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Qual a coluna d'agua?");
        int colunaDAgua = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Qual o peso da barraca?");
        double peso = scanner.nextDouble();
        boolean avanco = false;
        System.out.println("A barraca possui avanco para gaurdar equipamentos do lado de fora? Digite S para sim, ou N para nao.");
        if (scanner.next().equals("S")) {
            avanco = true;
        }
        campista.addBarraca(capacidadePessoas, colunaDAgua, peso, avanco);
    }
}
