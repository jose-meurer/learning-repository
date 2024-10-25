package application;

import db.DB;
import db.DbException;

import java.sql.*;
import java.time.Instant;
import java.util.Calendar;
import java.util.TimeZone;

public class InserirDB {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement state = null;

        try {
            conn = DB.getConnection();

            String query = "INSERT INTO sellers "
                    + "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
                    + "VALUES (?, ?, ?, ?, ?)"; //? = placeholder

            state = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            Instant instant = Instant.parse("2024-10-23T00:00:00Z");
            Timestamp timestamp = Timestamp.from(instant);
            Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));

            state.setString(1, "Lucio");
            state.setString(2, "lucio@gmail.com");

//            state.setDate(3,
//                    new java.sql.Date(LocalDate.parse("19/06/1990", dateFormatter).atStartOfDay().atZone(ZoneId.of("GMT-3"))
//                            .toInstant().toEpochMilli()));
//            state.setDate(3, new Date(Instant.parse("2024-10-23T00:01:00Z").toEpochMilli()));
            state.setTimestamp(3, Timestamp.from(instant));
//            state.setDate(3, new Date(Timestamp.from(instant).getTime()));

            state.setDouble(4, 5200.0);
            state.setInt(5, 2);

            int rowsAffected = state.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet resultSet = state.getGeneratedKeys();
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    System.out.println("Done! Id = " + id);
                }
            } else {
                System.out.println("No rown affected!");
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(state);
            DB.closeConnection();
        }
    }
}
