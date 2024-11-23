import java.util.List;

public interface EmployerActions {
    void postJob(String title, String description);
    List<Job> getJobPostings();
}
