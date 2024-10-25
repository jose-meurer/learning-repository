package application;

import db.DB;
import db.DbException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AtualizarDB {
    public static void main(String[] args) {

        Connection conn = null;
        conn = DB.getConnection();
        PreparedStatement state = null;
        try {
            conn = DB.getConnection();

            String query = "UPDATE sellers SET baseSalary = baseSalary + ? "
                    + "WHERE (departmentId = ?)";
            state = conn.prepareStatement(query);
            state.setDouble(1, 150.0);
            state.setInt(2, 2);

            int rowsAffected = state.executeUpdate();
            System.out.println("Done! Rows affected: " + rowsAffected);

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(state);
            DB.closeConnection();
        }
    }
}
