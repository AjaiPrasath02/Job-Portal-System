

CREATE DATABASE jobportal;

USE jobportal;


CREATE TABLE Users (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    userType ENUM('JobSeeker', 'Employer') NOT NULL
);


CREATE TABLE Jobs (
    jobID INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    postedBy VARCHAR(50) NOT NULL,
    location VARCHAR(100),
    FOREIGN KEY (postedBy) REFERENCES Users(username) ON DELETE CASCADE
);


CREATE TABLE AppliedJobs (
    applicationID INT AUTO_INCREMENT PRIMARY KEY,
    jobTitle VARCHAR(255) NOT NULL,
    jobDescription TEXT NOT NULL,
    postedBy VARCHAR(50) NOT NULL,
    username VARCHAR(50) NOT NULL,
    FOREIGN KEY (username) REFERENCES Users(username) ON DELETE CASCADE
);

CREATE TABLE Skills (
    skillID INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    skill VARCHAR(100) NOT NULL,
    FOREIGN KEY (username) REFERENCES Users(username) ON DELETE CASCADE
);
