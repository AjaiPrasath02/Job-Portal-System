import java.util.ArrayList;
import java.util.List;

public class Employer extends User {
    private List<Job> jobPostings;

    // Constructor
    public Employer(String username, String password, String email) {
        super(username, password, email);
        this.jobPostings = new ArrayList<>();
    }

    // Post a job
    public void postJob(String title, String description) {
        Job job = new Job(title, description, getUsername());
        jobPostings.add(job);
        System.out.println("Job posted successfully: " + title);
    }

    // Display job postings
    public void displayJobPostings() {
        System.out.println("Job Postings by " + getUsername() + ":");
        if (jobPostings.isEmpty()) {
            System.out.println("No jobs posted yet.");
        } else {
            for (Job job : jobPostings) {
                System.out.println(job);
            }
        }
    }

    @Override
    public void displayUserDetails() {
        System.out.println("Employer: " + getUsername() + ", Email: " + getEmail());
    }
}
