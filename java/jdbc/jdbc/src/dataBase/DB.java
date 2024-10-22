package dataBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {

    private static Connection connection = null;

    //Faz a ponte de conexao ao banco
    public static Connection getConnection() {
        if(connection == null) {

            try {
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                System.out.println(props);
                connection = DriverManager.getConnection(url, props);
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
        return connection;
    }

    //Fecha a conexao ao banco
    public static void closeConnection() {
        if(connection != null) {
            try {
                connection.close();
            }
            catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    //Carregar os dados do file db.properties
    private static Properties loadProperties() {
        try (FileInputStream fs = new FileInputStream("db.properties")) {

            Properties props = new Properties();
            props.load(fs);
            System.out.println(props);
            return props;

        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }
}
