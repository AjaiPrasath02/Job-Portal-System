public class Job {
    private String title;
    private String description;
    private String postedBy;

    public Job(String title, String description, String postedBy) {
        this.title = title;
        this.description = description;
        this.postedBy = postedBy;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPostedBy() {
        return postedBy;
    }

    @Override
    public String toString() {
        return "Job Title: " + title + "\nDescription: " + description + "\nPosted by: " + postedBy;
    }
}
