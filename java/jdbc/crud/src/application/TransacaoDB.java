package application;

import db.DB;
import db.DbException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TransacaoDB {

    public static void main(String[] args) {

        Connection conn = null;
        Statement state = null;

        try {
            conn = DB.getConnection();

            conn.setAutoCommit(false);

            state = conn.createStatement();

            int rows1 = state.executeUpdate("UPDATE sellers SET basesalary = 2090 "
                    + "WHERE departmentid = 2");

            if (false) {
                throw new SQLException("Fake error!");
            }

            int rows2 = state.executeUpdate("UPDATE sellers SET basesalary = 3090 "
                    + "WHERE departmentid = 3");

            conn.commit();

            System.out.println("Rows1 " + rows1);
            System.out.println("Rows2 " + rows2);
        } catch (SQLException e) {
            try {
                conn.rollback();
                throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
            } catch (SQLException e1) {
                throw new DbException("Error trying to rollback! Caused by: " + e1.getMessage());
            }
        }
    }
}
