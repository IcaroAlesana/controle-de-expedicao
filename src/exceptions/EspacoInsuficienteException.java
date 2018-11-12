package exceptions;

public class EspacoInsuficienteException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EspacoInsuficienteException (){
		System.out.println("Mochila nao possui espaco para o item.");
	}

}
