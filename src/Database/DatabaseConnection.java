package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/movie_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "aldebaran1711";

    public static void main(String[] args) {
        Connection connection = null;

        try {
            connection = getConnected();
            System.out.println("Successfully connected to movie_db!");
        }catch (SQLException ie) {
            ie.printStackTrace();
        }catch (ClassNotFoundException ie) {
            ie.printStackTrace();
        } finally {
            closeConnection(connection);
            System.out.println("Connection successfully closed!");
        }
    }

    private static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ie) {
            ie.printStackTrace();
            System.out.println("Failed to closed database movie_db connection");
        }
    }

    public static Connection getConnected() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
    }


}
