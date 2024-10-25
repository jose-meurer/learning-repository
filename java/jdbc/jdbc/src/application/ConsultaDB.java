package application;

import dataBase.DB;
import dataBase.DbException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConsultaDB {
    public static void main(String[] args) {

        Connection conn = null; //Faz a conexao
        Statement state = null; //Faz a consulta
        ResultSet resultSet = null; //Armazena o resultado da consulta

        try {
            conn = DB.getConnection();

            state = conn.createStatement();
            resultSet = state.executeQuery("SELECT * FROM sellers");

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("Id")
                        + ", " + resultSet.getString("Name")
                        + ", " + resultSet.getTimestamp("birthdate").toInstant());
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(resultSet);
            DB.closeStatement(state);
            DB.closeConnection();
        }
    }
}
