package br.com.udesc.controledeexpedicao.exceptions;

public class ItemNaoEncontradoException extends RuntimeException {

	public ItemNaoEncontradoException() {
		System.out.println("Item não encontrado");
	}
}
