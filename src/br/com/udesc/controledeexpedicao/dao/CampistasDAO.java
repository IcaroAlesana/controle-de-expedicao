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
		String sqlCampista = "insert into pessoa (cpf, nome_completo) values (?, ?)";
		PreparedStatement statementCampista = connection.prepareStatement(sqlCampista);

		statementCampista.setString(1, campista.getCpf());
		statementCampista.setString(2, campista.getNome());

		try {
			statementCampista.execute();
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			connection.rollback();
		} finally{
			statementCampista.close();
		}
	}
}
