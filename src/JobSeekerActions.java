import java.util.List;

public interface JobSeekerActions {
    void searchJobs(String keyword, List<Job> jobs);
    void applyForJob(Job job);
}
