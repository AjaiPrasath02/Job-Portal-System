import java.util.ArrayList;
import java.util.List;

public class JobSeeker extends User {
    private String resumePath;
    private List<Job> appliedJobs;

    // Constructor
    public JobSeeker(String username, String password, String email, String resumePath) {
        super(username, password, email);
        this.resumePath = resumePath;
        this.appliedJobs = new ArrayList<>();
    }

    public String getResumePath() {
        return resumePath;
    }

    public void setResumePath(String resumePath) {
        this.resumePath = resumePath;
    }

    // Search jobs
    public void searchJobs(String keyword, List<Job> jobs) {
        System.out.println("Jobs matching keyword '" + keyword + "':");
        boolean found = false;
        for (Job job : jobs) {
            if (job.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                    job.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(job);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No jobs found for the given keyword.");
        }
    }

    // Apply for a job
    public void applyForJob(Job job) {
        if (!appliedJobs.contains(job)) {
            appliedJobs.add(job);
            System.out.println("Applied for job: " + job.getTitle());
        } else {
            System.out.println("You have already applied for this job.");
        }
    }

    // View applied jobs
    public void viewAppliedJobs() {
        if (appliedJobs.isEmpty()) {
            System.out.println("No jobs applied yet.");
        } else {
            System.out.println("Jobs applied by " + getUsername() + ":");
            for (Job job : appliedJobs) {
                System.out.println(job);
            }
        }
    }

    @Override
    public void displayUserDetails() {
        System.out.println("Job Seeker: " + getUsername() + ", Email: " + getEmail());
    }
}
