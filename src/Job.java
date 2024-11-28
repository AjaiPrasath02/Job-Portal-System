public class Job {
    private String title;
    private String description;
    private String postedBy;
    private String location;

    public Job(String title, String description, String postedBy,String location) {
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

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Job Title: " + title + "\nDescription: " + description + "\nPosted by: " + postedBy + "\nlocation:"+location;
    }
}
