package br.com.udesc.controledeexpedicao.controle;

import br.com.udesc.controledeexpedicao.exceptions.EspacoInsuficienteException;
import br.com.udesc.controledeexpedicao.modelos.*;
import br.com.udesc.controledeexpedicao.repositorios.RepositorioDeItensBasicos;
import br.com.udesc.controledeexpedicao.repositorios.RepositorioDeMantimentos;
import br.com.udesc.controledeexpedicao.repositorios.RepositorioDeUtilidades;


import java.util.Scanner;

public class ControleDeCampista {
    private RepositorioDeMantimentos repositorioDeMantimentos;
    private RepositorioDeItensBasicos repositorioDeItensBasicos;
    private RepositorioDeUtilidades repositorioDeUtilidades;
    private Scanner scanner;
    private Campista campista;

    public ControleDeCampista(RepositorioDeMantimentos repositorioDeMantimentos, RepositorioDeItensBasicos repositorioDeItensBasicos,
                              RepositorioDeUtilidades repositorioDeUtilidades, Scanner scanner) {
        this.repositorioDeMantimentos = repositorioDeMantimentos;
        this.repositorioDeItensBasicos = repositorioDeItensBasicos;
        this.repositorioDeUtilidades = repositorioDeUtilidades;
        this.scanner = scanner;

    }

    public void addItemBasicoMochilaCampista(String nome) {
        ItemBasico itemBasico = repositorioDeItensBasicos.getItemBasicoPorNome(nome);
        campista.addItemBasicoNaMochila(itemBasico);

    }

    public void addMantimentoMochilaCampista(String nome) {
        Mantimento mantimento = repositorioDeMantimentos.getMantimentoPorNome(nome);
        campista.addMantimentoNaMochila(mantimento);
    }

    public void addUtilidadeCampista(String nome) {
        Utilidade utilidade = repositorioDeUtilidades.getUtilidadePorNome(nome);
        campista.addUtilidade(utilidade);
    }

    public void addBarracaCampista() {
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
