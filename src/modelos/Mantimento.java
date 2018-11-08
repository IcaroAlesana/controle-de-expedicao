package modelos;

public class Mantimento extends Item implements ItemMochila {
		
	private double volume;
	
    public Mantimento(String nome, double peso, double volume) {
        setNome(nome);
        setPeso(peso);
        setVolume(volume);
    }

	@Override
	public double getVolume() {
		return volume;
	}

	@Override
	public void setVolume(double volume) {
		this.volume = volume;
	}
}
