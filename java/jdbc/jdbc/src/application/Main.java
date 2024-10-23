package application;

import dataBase.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        Connection conn = null; //Faz a conexao
        Statement state = null; //Faz a consulta
        ResultSet resultSet = null; //Armazena o resultado da consulta

        try {
            conn = DB.getConnection();

            state = conn.createStatement();
            resultSet = state.executeQuery("SELECT * FROM departments");

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("Id")
                        + ", " + resultSet.getString("Name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DB.closeResultSet(resultSet);
            DB.closeStatement(state);
            DB.closeConnection();
        }
    }
}