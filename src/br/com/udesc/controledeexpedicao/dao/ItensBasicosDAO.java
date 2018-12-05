package br.com.udesc.controledeexpedicao.dao;

import br.com.udesc.controledeexpedicao.modelos.Campista;
import br.com.udesc.controledeexpedicao.modelos.ItemBasico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItensBasicosDAO {
    Connection connection;

    public ItensBasicosDAO(Connection connection) {
        this.connection = connection;
    }

    public void inseriNaMochila(Campista campista, ItemBasico itemBasico) throws SQLException {
        String sql = "insert into itens_mochila (campista_mochila, id_item) values (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, campista.getCpf());
        statement.setLong(2, getItemIDByName(itemBasico.getNome()));

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

    public int getItemIDByName(String nome) throws SQLException {
        int ID = Integer.parseInt(null);
        String sql = "select id_item from itens_basicos where nome_item = " + nome;
        PreparedStatement statement = connection.prepareStatement(sql);

        try {
            ResultSet rs = statement.executeQuery();
            ID = rs.getInt("id_item");
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
        } finally{
            statement.close();
        }

        return ID;
    }

    public int generateID() throws SQLException {
        int ID = 0;
        String sql = "select MAX id_item from itens_mochila";
        PreparedStatement statement = connection.prepareStatement(sql);

        try {
            ResultSet rs = statement.executeQuery();
            ID = rs.getInt("id_item") + 1;
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
        } finally{
            statement.close();
        }

        return ID;
    }

}
