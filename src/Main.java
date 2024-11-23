import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Job> jobDatabase = new ArrayList<>();
        System.out.println("Welcome to the Advanced Job Portal!");

        System.out.println("Are you a:");
        System.out.println("1. Job Seeker");
        System.out.println("2. Employer");

        int userType = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (userType == 1) {
            // Job Seeker Flow
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            System.out.print("Enter email: ");
            String email = scanner.nextLine();
            System.out.print("Enter resume path: ");
            String resumePath = scanner.nextLine();

            JobSeeker jobSeeker = new JobSeeker(username, password, email, resumePath);

            while (true) {
                System.out.println("1. Search Jobs");
                System.out.println("2. Apply for Job");
                System.out.println("3. View Applied Jobs");
                System.out.println("4. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (choice == 1) {
                    System.out.print("Enter keyword: ");
                    String keyword = scanner.nextLine();
                    jobSeeker.searchJobs(keyword, jobDatabase);
                } else if (choice == 2) {
                    System.out.print("Enter job title to apply for: ");
                    String title = scanner.nextLine().trim();
                    boolean jobFound = false;

                    for (Job job : jobDatabase) {
                        if (job.getTitle().equalsIgnoreCase(title)) {
                            jobSeeker.applyForJob(job);
                            jobFound = true;
                            break;
                        }
                    }

                    if (!jobFound) {
                        System.out.println("Job not found! Please check the job title and try again.");
                    }
                } else if (choice == 3) {
                    jobSeeker.viewAppliedJobs();
                } else {
                    break;
                }
            }
        } else if (userType == 2) {
            // Employer Flow
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            System.out.print("Enter email: ");
            String email = scanner.nextLine();

            Employer employer = new Employer(username, password, email);

            while (true) {
                System.out.println("1. Post a Job");
                System.out.println("2. View Job Postings");
                System.out.println("3. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (choice == 1) {
                    System.out.print("Enter job title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter job description: ");
                    String description = scanner.nextLine();
                    employer.postJob(title, description);
                    jobDatabase.add(new Job(title, description, username));
                } else if (choice == 2) {
                    employer.displayJobPostings();
                } else {
                    break;
                }
            }
        }

        scanner.close();
        System.out.println("Thank you for using the Advanced Job Portal!");
    }
}
