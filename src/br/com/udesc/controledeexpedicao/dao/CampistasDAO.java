package br.com.udesc.controledeexpedicao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.udesc.controledeexpedicao.modelos.Campista;

public class CampistasDAO {
	Connection connection;
	
	public CampistasDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void inserir(Campista campista) throws SQLException {
		String sqlA = "insert into pessoa (cpf, nome_completo) values (?, ?)";
		PreparedStatement statement = connection.prepareStatement(sqlA);
		String sqlB = "insert into mochila (cpf, )";
		
		statement.setString(1, campista.getCpf());
		statement.setString(2, campista.getNome());

		try {
			statement.execute();
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			connection.rollback();
		} finally{
			statement.close();
		}
	}
}
