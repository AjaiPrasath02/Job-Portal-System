import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JobSeeker extends User {
    private String resumePath;
    private String preferredLocation;

    public JobSeeker(String username, String password, String email, String resumePath) {
        super(username, password, email);
        this.resumePath = resumePath;
        this.preferredLocation = "";
        saveUserToDatabase();
    }

    public String getResumePath() {
        return resumePath;
    }

    public void setResumePath(String resumePath) {
        this.resumePath = resumePath;
    }

    public String getPreferredLocation() {
        return preferredLocation;
    }

    public void setPreferredLocation(String preferredLocation) {
        this.preferredLocation = preferredLocation;
    }

    private void saveUserToDatabase() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO Users (username, password, email, userType) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, getUsername());
            stmt.setString(2, getPassword());
            stmt.setString(3, getEmail());
            stmt.setString(4, "JobSeeker");
            stmt.executeUpdate();
            System.out.println("Job seeker details saved successfully!");
        } catch (SQLException e) {
            System.out.println("Failed to save job seeker details.");
            e.printStackTrace();
        }
    }

    public void searchJobs(String keyword, String location) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM Jobs WHERE (title LIKE ? OR description LIKE ?) AND location LIKE ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, "%" + keyword + "%");
            stmt.setString(2, "%" + keyword + "%");
            stmt.setString(3, "%" + location + "%");

            ResultSet rs = stmt.executeQuery();
            System.out.println("Jobs matching keyword '" + keyword + "' and location '" + location + "':");
            boolean found = false;
            while (rs.next()) {
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Description: " + rs.getString("description"));
                System.out.println("Posted By: " + rs.getString("postedBy"));
                System.out.println("Location: " + rs.getString("location"));
                System.out.println("--------------------");
                found = true;
            }
            if (!found) {
                System.out.println("No jobs found for the given keyword and location.");
            }
        } catch (SQLException e) {
            System.out.println("Failed to search jobs.");
            e.printStackTrace();
        }
    }

    public void applyForJob(Job job) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO AppliedJobs (jobTitle, jobDescription, postedBy, username) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, job.getTitle());
            stmt.setString(2, job.getDescription());
            stmt.setString(3, job.getPostedBy());
            stmt.setString(4, getUsername());
            stmt.executeUpdate();
            System.out.println("Applied for job: " + job.getTitle());
        } catch (SQLException e) {
            System.out.println("Failed to apply for job.");
            e.printStackTrace();
        }
    }

    public void viewAppliedJobs() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM AppliedJobs WHERE username = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, getUsername());

            ResultSet rs = stmt.executeQuery();
            System.out.println("Jobs applied by " + getUsername() + ":");
            boolean found = false;
            while (rs.next()) {
                System.out.println("Title: " + rs.getString("jobTitle"));
                System.out.println("Description: " + rs.getString("jobDescription"));
                System.out.println("Posted By: " + rs.getString("postedBy"));
                System.out.println("--------------------");
                found = true;
            }
            if (!found) {
                System.out.println("No jobs applied yet.");
            }
        } catch (SQLException e) {
            System.out.println("Failed to fetch applied jobs.");
            e.printStackTrace();
        }
    }

    public void addSkill(String skill) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO Skills (username, skill) VALUES (?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, getUsername());
            stmt.setString(2, skill.trim());
            stmt.executeUpdate();
            System.out.println("Skill added: " + skill.trim());
        } catch (SQLException e) {
            System.out.println("Failed to add skill.");
            e.printStackTrace();
        }
    }

    public void displaySkills() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT skill FROM Skills WHERE username = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, getUsername());

            ResultSet rs = stmt.executeQuery();
            System.out.println("Skills for " + getUsername() + ":");
            boolean found = false;
            while (rs.next()) {
                System.out.println("- " + rs.getString("skill"));
                found = true;
            }
            if (!found) {
                System.out.println("No skills added yet.");
            }
        } catch (SQLException e) {
            System.out.println("Failed to fetch skills.");
            e.printStackTrace();
        }
    }

    @Override
    public void displayUserDetails() {
        System.out.println("Job Seeker: " + getUsername() + ", Email: " + getEmail());
        System.out.println("Resume Path: " + resumePath);
        System.out.println("Preferred Location: " + preferredLocation);
    }
}
