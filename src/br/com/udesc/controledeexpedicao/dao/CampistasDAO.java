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
		String sql = "insert into pessoa (cpf, nome_completo, idade) values (?, ?, ?)";		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		/*statement.setString(1, cpf);
		statement.setString(2, nome);
		statement.setInt(3, idade);*/
		
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
