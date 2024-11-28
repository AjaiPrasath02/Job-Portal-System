import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Employer extends User {

    public Employer(String username, String password, String email) {
        super(username, password, email);
        saveUserToDatabase();
    }

    private void saveUserToDatabase() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO Users (username, password, email, userType) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, getUsername());
            stmt.setString(2, getPassword());
            stmt.setString(3, getEmail());
            stmt.setString(4, "Employer");
            stmt.executeUpdate();
            System.out.println("Employer details saved successfully!");
        } catch (SQLException e) {
            System.out.println("Failed to save employer details.");
            e.printStackTrace();
        }
    }

    public void postJob(String title, String description, String location) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO Jobs (title, description, postedBy, location) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, title);
            stmt.setString(2, description);
            stmt.setString(3, getUsername());
            stmt.setString(4, location);
            stmt.executeUpdate();
            System.out.println("Job posted successfully: " + title);
        } catch (SQLException e) {
            System.out.println("Failed to post job.");
            e.printStackTrace();
        }
    }

    public void displayJobPostings() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT title, description, location FROM Jobs WHERE postedBy = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, getUsername());

            ResultSet rs = stmt.executeQuery();
            System.out.println("Job Postings by " + getUsername() + ":");
            boolean found = false;
            while (rs.next()) {
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Description: " + rs.getString("description"));
                System.out.println("Location: " + rs.getString("location"));
                System.out.println("--------------------");
                found = true;
            }
            if (!found) {
                System.out.println("No jobs posted yet.");
            }
        } catch (SQLException e) {
            System.out.println("Failed to fetch job postings.");
            e.printStackTrace();
        }
    }

    @Override
    public void displayUserDetails() {
        System.out.println("Employer: " + getUsername() + ", Email: " + getEmail());
    }
}
