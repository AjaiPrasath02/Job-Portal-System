import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/world";
    private static final String USER = "root"; // Replace with your MySQL username
    private static final String PASSWORD = "Ajai@2004"; // Replace with your MySQL password
    private static Connection connection = null;

    // Method to establish a connection
    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Load the MySQL JDBC driver (optional for modern Java)
                Class.forName("com.mysql.cj.jdbc.Driver");
                // Establish the connection
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Database connection established.");
            } catch (ClassNotFoundException e) {
                System.out.println("MySQL JDBC Driver not found.");
                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("Error connecting to the database.");
                e.printStackTrace();
            }
        }
        return connection;
    }

    // Optional: Method to close the connection
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            System.out.println("Error closing the connection.");
            e.printStackTrace();
        }
    }
}
