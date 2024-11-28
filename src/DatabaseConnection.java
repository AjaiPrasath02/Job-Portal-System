import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/jobportal?autoReconnect=true&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "****";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error connecting to the database.");
            e.printStackTrace();
            return null;
        }
    }
}
