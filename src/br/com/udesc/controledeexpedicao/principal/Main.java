package br.com.udesc.controledeexpedicao.principal;

import java.sql.SQLException;

import br.com.udesc.controledeexpedicao.controle.ControleGeral;

public class Main {

    public static void main(String[] args) throws SQLException {
    	
    	ControleGeral controleGeral = new ControleGeral();
    	controleGeral.iniciar();
    }
}
