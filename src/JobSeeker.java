import java.util.ArrayList;
import java.util.List;

public class JobSeeker extends User implements JobSeekerActions {
    private String resumePath;
    private List<Job> appliedJobs;
    private List<String> skills; // New field for skills
    private String preferredLocation; // New field for preferred location

    // Constructor
    public JobSeeker(String username, String password, String email, String resumePath) {
        super(username, password, email);
        this.resumePath = resumePath;
        this.appliedJobs = new ArrayList<>();
        this.skills = new ArrayList<>();
        this.preferredLocation = "";
    }

    // Getters and Setters
    public String getResumePath() {
        return resumePath;
    }

    public void setResumePath(String resumePath) {
        this.resumePath = resumePath;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void addSkill(String skill) {
        skills.add(skill.trim());
    }

    public String getPreferredLocation() {
        return preferredLocation;
    }

    public void setPreferredLocation(String preferredLocation) {
        this.preferredLocation = preferredLocation;
    }

    // Search jobs
    @Override
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
    @Override
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
        System.out.println("Skills: " + skills);
        System.out.println("Preferred Location: " + preferredLocation);
    }
}
