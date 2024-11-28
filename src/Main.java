import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Advanced Job Portal!");

        System.out.println("Are you a:");
        System.out.println("1. Job Seeker");
        System.out.println("2. Employer");

        int userType = scanner.nextInt();
        scanner.nextLine();

        if (userType == 1) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            System.out.print("Enter email: ");
            String email = scanner.nextLine();
            System.out.print("Enter resume path: ");
            String resumePath = scanner.nextLine();

            JobSeeker jobSeeker = new JobSeeker(username, password, email, resumePath);

            System.out.println("Enter preferred job location: ");
            String preferredLocation = scanner.nextLine();
            jobSeeker.setPreferredLocation(preferredLocation);

            while (true) {
                System.out.println("\nWhat would you like to do?");
                System.out.println("1. Search jobs");
                System.out.println("2. Apply for a job");
                System.out.println("3. View applied jobs");
                System.out.println("4. Add a skill");
                System.out.println("5. View skills");
                System.out.println("6. View profile");
                System.out.println("7. Exit");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter a keyword to search for jobs: ");
                        String keyword = scanner.nextLine();
                        System.out.print("Enter a preferred location (leave empty for all locations): ");
                        String location = scanner.nextLine();
                        jobSeeker.searchJobs(keyword, location);
                        break;
                    case 2:
                        System.out.print("Enter the title of the job you want to apply for: ");
                        String jobTitle = scanner.nextLine();
                        System.out.print("Enter the job description: ");
                        String jobDescription = scanner.nextLine();
                        System.out.print("Enter the name of the employer who posted the job: ");
                        String postedBy = scanner.nextLine();
                        Job job = new Job(jobTitle, jobDescription, postedBy, preferredLocation);
                        jobSeeker.applyForJob(job);
                        break;
                    case 3:
                        jobSeeker.viewAppliedJobs();
                        break;
                    case 4:
                        System.out.print("Enter a skill to add: ");
                        String skill = scanner.nextLine();
                        jobSeeker.addSkill(skill);
                        break;
                    case 5:
                        jobSeeker.displaySkills();
                        break;
                    case 6:
                        jobSeeker.displayUserDetails();
                        break;
                    case 7:
                        System.out.println("Exiting... Thank you for using the Job Portal!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else if (userType == 2) {

            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            System.out.print("Enter email: ");
            String email = scanner.nextLine();

            Employer employer = new Employer(username, password, email);

            while (true) {
                System.out.println("\nWhat would you like to do?");
                System.out.println("1. Post a job");
                System.out.println("2. View your job postings");
                System.out.println("3. Exit");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter job title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter job description: ");
                        String description = scanner.nextLine();
                        System.out.print("Enter job location: ");
                        String location = scanner.nextLine();
                        employer.postJob(title, description,location);
                        break;
                    case 2:
                        employer.displayJobPostings();
                        break;
                    case 3:
                        System.out.println("Exiting... Thank you for using the Job Portal!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Invalid option. Please restart the application.");
        }

        scanner.close();
    }
}
