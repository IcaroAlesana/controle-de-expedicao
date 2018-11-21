package br.com.udesc.controledeexpedicao.controle;

import java.util.Scanner;

import br.com.udesc.controledeexpedicao.modelos.Campista;
import br.com.udesc.controledeexpedicao.modelos.ItemBasico;
import br.com.udesc.controledeexpedicao.modelos.Mantimento;
import br.com.udesc.controledeexpedicao.modelos.Utilidade;
import br.com.udesc.controledeexpedicao.repositorios.RepositorioDeItensBasicos;
import br.com.udesc.controledeexpedicao.repositorios.RepositorioDeMantimentos;
import br.com.udesc.controledeexpedicao.repositorios.RepositorioDeUtilidades;

public class ControleDeCampista {
    private RepositorioDeMantimentos repositorioDeMantimentos;
    private RepositorioDeItensBasicos repositorioDeItensBasicos;
    private RepositorioDeUtilidades repositorioDeUtilidades;
    private Scanner scanner;

    public ControleDeCampista(RepositorioDeMantimentos repositorioDeMantimentos, RepositorioDeItensBasicos repositorioDeItensBasicos,
                              RepositorioDeUtilidades repositorioDeUtilidades, Scanner scanner) {
        this.repositorioDeMantimentos = repositorioDeMantimentos;
        this.repositorioDeItensBasicos = repositorioDeItensBasicos;
        this.repositorioDeUtilidades = repositorioDeUtilidades;
        this.scanner = scanner;
    }
    
    public void iniciar() {
    	
    }

    public void addItemBasicoMochilaCampista(Campista campista, String nome) {
        ItemBasico itemBasico = repositorioDeItensBasicos.getItemBasicoPorNome(nome);
        campista.addItemBasicoNaMochila(itemBasico);

    }

    public void addMantimentoMochilaCampista(Campista campista, String nome) {
        Mantimento mantimento = repositorioDeMantimentos.getMantimentoPorNome(nome);
        campista.addMantimentoNaMochila(mantimento);
    }

    public void addUtilidadeCampista(Campista campista, String nome) {
        Utilidade utilidade = repositorioDeUtilidades.getUtilidadePorNome(nome);
        campista.addUtilidade(utilidade);
    }

    public void addBarracaCampista(Campista campista) {
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
        campista.addBarraca(capacidadePessoas, colunaDAgua, peso, avanco);
    }
}
