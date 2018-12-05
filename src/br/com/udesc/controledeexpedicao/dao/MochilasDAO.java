package br.com.udesc.controledeexpedicao.dao;

import br.com.udesc.controledeexpedicao.modelos.Campista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MochilasDAO {
    Connection connection;

    public MochilasDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserir(Campista campista) throws SQLException {

        String sqlMochila = "insert into mochila (cpf, capacidade) values (?, ?)";
        PreparedStatement statementMochila = connection.prepareStatement(sqlMochila);

        statementMochila.setString(1, campista.getCpf());
        statementMochila.setDouble(2, campista.getMochila().getCapacidade());

        try {
            statementMochila.execute();
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
        } finally{
            statementMochila.close();
        }
    }

}
