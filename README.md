https://github.com/AjaiPrasath02/Job-Portal-System.git

# Advanced Job Portal System

* The Advanced Job Portal System is a Java-based application that bridges the gap between job seekers and employers.
* It allows users to register, search for jobs, post job openings, manage job applications, and track skills efficiently.

---

## Features

### For Job Seekers:
- **Search Jobs:** Look for jobs by entering keywords and location preferences.
- **Apply for Jobs:** Submit applications for job postings directly.
- **View Applied Jobs:** Keep track of jobs you’ve applied for.
- **Skills Management:** Add and view your skills to enhance your profile.
- **Profile Management:** View and update your job seeker profile details.

### For Employers:
- **Post Jobs:** Add job openings with titles, descriptions, and locations.
- **View Job Postings:** View and manage all jobs you’ve posted.

---

## Technologies Used
- **Java:** Backend application logic.
- **MySQL:** Relational database for storing user and job-related data.
- **JDBC:** Java Database Connectivity for integrating Java and MySQL.
- **IntelliJ IDEA:** Recommended IDE for project development.

---

Step 1: Clone the Repository

Clone the project to your local machine:
git clone https://github.com/AjaiPrasath02/Job-Portal-System.git
cd Job-Portal-System


Step 2: Initialize the Database
Open your MySQL Workbench.
Navigate to the sql directory in the project.
Run the sql_commands.sql file to set up the database.

Step 4: Configure the Database Connection
Open the DatabaseConnection.java file in the project.
Update the following fields with your MySQL credentials:

private static final String URL = "jdbc:mysql://localhost:3306/jobportal?autoReconnect=true&useSSL=false";
private static final String USER = "your_mysql_username"; // Replace with your username
private static final String PASSWORD = "your_mysql_password"; // Replace with your password

Step 5: Run the Application
Open the project in your IntelliJ IDEA (or any IDE of your choice).
Compile and run the Main.java file.
Follow the console prompts to explore the application as a job seeker or employer.
