package application;

import db.DB;
import db.DbException;
import db.DbIntegrityException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeletarDB {

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement state = null;

        try {
            conn = DB.getConnection();


            String query = "DELETE FROM sellers WHERE id = ?";
            state = conn.prepareStatement(query);

            state.setInt(1, 2);

            int rowsAffected = state.executeUpdate();

            System.out.println("Done! Rows affected: " + rowsAffected);


        } catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        }
        finally {
            DB.closeStatement(state);
            DB.closeConnection();
        }
    }
}
