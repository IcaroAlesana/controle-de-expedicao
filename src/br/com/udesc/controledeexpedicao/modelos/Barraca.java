package br.com.udesc.controledeexpedicao.modelos;

public class Barraca {
    private int capacidadePessoas;
    private int culunaDAgua;
    private double peso;
    private boolean avanco;
    
    public Barraca(int capacidadePessoas, int colunaDAgua, double peso, boolean avanco) {
    	this.capacidadePessoas = capacidadePessoas;
    	this.culunaDAgua = colunaDAgua;
    	this.peso = peso;
    	this.avanco = avanco;
    }

	public int getCapacidadePessoas() {
		return capacidadePessoas;
	}

	public int getCulunaDAgua() {
		return culunaDAgua;
	}

	public double getPeso() {
		return peso;
	}

	public boolean temAvanco() {
		return avanco;
	}

}
