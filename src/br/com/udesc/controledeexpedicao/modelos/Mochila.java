package br.com.udesc.controledeexpedicao.modelos;

import java.util.ArrayList;

import br.com.udesc.controledeexpedicao.exceptions.EspacoInsuficienteException;

public class Mochila {
    private double capacidade;
    private ArrayList<ItemBasico> itensBasicos;
    private ArrayList<Mantimento> mantimentos;

    public Mochila(double capacidade) {
        this.capacidade = capacidade;
        itensBasicos = new ArrayList<>();
        mantimentos = new ArrayList<>();
    }

    public void mostrarItens() {
        System.out.println("Itens basicos: ");
        for(Item item : itensBasicos){
            System.out.println(item.getNome());
        }

        System.out.println("Mantimentos: ");
        for(Item item : mantimentos){
            System.out.println(item.getNome());
        }
    }

    public double getCapacidade() {
        return capacidade;
    }

    public void addItemBasico(ItemBasico itemBasico) {
        try {
            if (!dentroDaCapacidade(itemBasico.getVolume())) {
                throw new EspacoInsuficienteException(capacidade, volumeOcupado());
            }
            itensBasicos.add(itemBasico);
        } catch (EspacoInsuficienteException e) {
        }
    }
    
    public void addMantimento(Mantimento mantimento) {
        try {
            if (!dentroDaCapacidade(mantimento.getVolume())) {
                throw new EspacoInsuficienteException(capacidade, volumeOcupado());
            }
            mantimentos.add(mantimento);
        } catch (EspacoInsuficienteException e) {
        }
    }

    public ArrayList<ItemBasico> getItensBasicos() {
        return itensBasicos;
    }
    
    public ArrayList<Mantimento> getMantimentos() {
        return mantimentos;
    }
    
    public double volumeOcupado() {
    	double volumeOcupado = 0;
        for(ItemMochila itemMochila : itensBasicos){
            volumeOcupado += itemMochila.getVolume();
        }
        for(ItemMochila itemMochila : mantimentos){
            volumeOcupado += itemMochila.getVolume();
        }
        
        return volumeOcupado;
    }

    public boolean dentroDaCapacidade(Double volume) {
        double volumeOcupado = this.volumeOcupado();

        return (volumeOcupado + volume) <= capacidade;
    }
}
