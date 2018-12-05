package br.com.udesc.controledeexpedicao.principal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.udesc.controledeexpedicao.controle.ControleGeral;
import br.com.udesc.controledeexpedicao.database.Database;

public class Main {

    public static void main(String[] args) throws SQLException {
    	
    	/*ControleGeral controleGeral = new ControleGeral();
    	controleGeral.iniciar();*/

        Database database = new Database();
    	Connection connection = database.getConnection();

        String sql = "insert into pessoa (cpf, nome_completo, idade) values (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);


    }
}
