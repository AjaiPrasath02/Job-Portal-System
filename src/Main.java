import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
public class Main {
    public static void main(String[] args) {

        Connection connection = null;

        try {
            // Get the database connection
            connection = DatabaseConnection.getConnection();

            // Example: Execute a simple query
            if (connection != null) {
                Statement statement = connection.createStatement();
                String query = "SELECT * FROM city"; // Replace with your table name
                ResultSet resultSet = statement.executeQuery(query);

                // Process the results
                while (resultSet.next()) {
                    System.out.println("ID: " + resultSet.getInt("id")); // Replace 'id' with your column name
                    System.out.println("Name: " + resultSet.getString("name")); // Replace 'name' with your column name
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred while interacting with the database.");
            e.printStackTrace();
        } finally {
            // Close the connection
            DatabaseConnection.closeConnection();
        }
//        Scanner scanner = new Scanner(System.in);
//        List<Job> jobDatabase = new ArrayList<>();
//        System.out.println("Welcome to the Advanced Job Portal!");
//
//        System.out.println("Are you a:");
//        System.out.println("1. Job Seeker");
//        System.out.println("2. Employer");
//
//        int userType = scanner.nextInt();
//        scanner.nextLine(); // Consume newline
//
//        if (userType == 1) {
//            // Job Seeker Flow
//            System.out.print("Enter username: ");
//            String username = scanner.nextLine();
//            System.out.print("Enter password: ");
//            String password = scanner.nextLine();
//            System.out.print("Enter email: ");
//            String email = scanner.nextLine();
//            System.out.print("Enter resume path: ");
//            String resumePath = scanner.nextLine();
//
//            JobSeeker jobSeeker = new JobSeeker(username, password, email, resumePath);
//
//            // Add skills and preferred location
//            System.out.println("Enter skills (comma-separated): ");
//            String skillsInput = scanner.nextLine();
//            String[] skills = skillsInput.split(",");
//            for (String skill : skills) {
//                jobSeeker.addSkill(skill.trim());
//            }
//
//            System.out.println("Enter preferred job location: ");
//            String location = scanner.nextLine();
//            jobSeeker.setPreferredLocation(location);
//
//            while (true) {
//                System.out.println("\nWhat would you like to do?");
//                System.out.println("1. Search jobs");
//                System.out.println("2. Apply for a job");
//                System.out.println("3. View applied jobs");
//                System.out.println("4. View profile");
//                System.out.println("5. Exit");
//
//                int choice = scanner.nextInt();
//                scanner.nextLine(); // Consume newline
//
//                switch (choice) {
//                    case 1:
//                        System.out.print("Enter a keyword to search jobs: ");
//                        String keyword = scanner.nextLine();
//                        jobSeeker.searchJobs(keyword, jobDatabase);
//                        break;
//                    case 2:
//                        System.out.print("Enter job title to apply for: ");
//                        String jobTitle = scanner.nextLine();
//                        boolean jobFound = false;
//                        for (Job job : jobDatabase) {
//                            if (job.getTitle().equalsIgnoreCase(jobTitle)) {
//                                jobSeeker.applyForJob(job);
//                                jobFound = true;
//                                break;
//                            }
//                        }
//                        if (!jobFound) {
//                            System.out.println("Job not found!");
//                        }
//                        break;
//                    case 3:
//                        jobSeeker.viewAppliedJobs();
//                        break;
//                    case 4:
//                        jobSeeker.displayUserDetails();
//                        break;
//                    case 5:
//                        System.out.println("Exiting... Thank you for using the Job Portal!");
//                        return;
//                    default:
//                        System.out.println("Invalid choice. Please try again.");
//                }
//            }
//        } else if (userType == 2) {
//            // Employer Flow
//            System.out.print("Enter username: ");
//            String username = scanner.nextLine();
//            System.out.print("Enter password: ");
//            String password = scanner.nextLine();
//            System.out.print("Enter email: ");
//            String email = scanner.nextLine();
//
//            Employer employer = new Employer(username, password, email);
//
//            while (true) {
//                System.out.println("1. Post a Job");
//                System.out.println("2. View Job Postings");
//                System.out.println("3. Exit");
//                int choice = scanner.nextInt();
//                scanner.nextLine(); // Consume newline
//
//                if (choice == 1) {
//                    System.out.print("Enter job title: ");
//                    String title = scanner.nextLine();
//                    System.out.print("Enter job description: ");
//                    String description = scanner.nextLine();
//                    employer.postJob(title, description);
//                    jobDatabase.add(new Job(title, description, username));
//                } else if (choice == 2) {
//                    employer.displayJobPostings();
//                } else {
//                    break;
//                }
//            }
//        }
//
//        scanner.close();
//        System.out.println("Thank you for using the Advanced Job Portal!");
  }
}
