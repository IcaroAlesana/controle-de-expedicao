package br.com.udesc.controledeexpedicao.database;

import java.sql.Connection;
import java.sql.SQLException;
import org.postgresql.ds.PGSimpleDataSource;


public class Database{
	
	private PGSimpleDataSource dataSource;
	
	public Database() {
		dataSource = new PGSimpleDataSource();
		dataSource.setURL("jdbc:postgresql://"+ HardcodedDatabaseConfig.DB_HOST +":"+HardcodedDatabaseConfig.DB_PORT+"/"+HardcodedDatabaseConfig.DB_NAME);
		dataSource.setUser(HardcodedDatabaseConfig.DB_USER);
		dataSource.setPassword(HardcodedDatabaseConfig.DB_PASSWORD);
	}

	public Connection getConnection() throws SQLException{
		Connection connection = dataSource.getConnection();
		
		return connection;
	}
}
