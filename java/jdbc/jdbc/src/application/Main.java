package application;

import dataBase.DB;
import dataBase.DbException;

import java.sql.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class Main {

    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {

        inserirDadosDB();
        consultaDB();

    }

    private static void inserirDadosDB() {

        Connection conn = null;
        PreparedStatement state = null;

        try {
            conn = DB.getConnection();

            String query = "INSERT INTO sellers "
                    + "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
                    + "VALUES (?, ?, ?, ?, ?)"; //? = placeholder

            state = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            Instant instant = Instant.parse("2024-10-23T00:01:00Z");

            state.setString(1, "Maria");
            state.setString(2, "joao@gmail.com");
            state.setDate(3,
                    new java.sql.Date(LocalDate.parse("19/06/1930", dateFormatter).atStartOfDay().atZone(ZoneId.of("GMT-3"))
                            .toInstant().toEpochMilli()));
//            state.setDate(3, new Date(Instant.parse("2024-10-23T00:01:00Z").toEpochMilli())); //Isso funciona com UTC
//            state.setTimestamp(3, new Timestamp(instant.toEpochMilli()));
            state.setDouble(4, 5200.0);
            state.setInt(5, 2);

            int rowsAffected = state.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet resultSet = state.getGeneratedKeys();
                while(resultSet.next()) {
                    int id = resultSet.getInt(1);
                    System.out.println("Done! Id = " + id);
                }
            }else {
                System.out.println("No rown affected!");
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    private static void consultaDB() {

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
            throw new RuntimeException(e);
        } finally {
            DB.closeResultSet(resultSet);
            DB.closeStatement(state);
            DB.closeConnection();
        }
    }
}