import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private String dob;
    private String email;
    private String studentId;
    private String course;

    public Student(String name, int rollNumber, String dob, String email, String studentId, String course) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.dob = dob;
        this.email = email;
        this.studentId = studentId;
        this.course = course;
    }

    // Getters
    public String getName() { return name; }
    public int getRollNumber() { return rollNumber; }
    public String getDob() { return dob; }
    public String getEmail() { return email; }
    public String getStudentId() { return studentId; }
    public String getCourse() { return course; }

    // Display student details
    public void displayDetails() {
        System.out.println("\nStudent Details:");
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Date of Birth: " + dob);
        System.out.println("Email: " + email);
        System.out.println("Student ID: " + studentId);
        System.out.println("Course: " + course);
    }
}

class Subject {
    private String name;
    private int marks;
    private String grade;
    private double percentage;

    public Subject(String name, int marks) {
        this.name = name;
        this.marks = marks;
        calculateGradeAndPercentage();
    }

    private void calculateGradeAndPercentage() {
        this.percentage = (marks / 100.0) * 100;
        
        if (marks >= 90) grade = "A+";
        else if (marks >= 80) grade = "A";
        else if (marks >= 70) grade = "B+";
        else if (marks >= 60) grade = "B";
        else if (marks >= 50) grade = "C";
        else if (marks >= 40) grade = "D";
        else grade = "F";
    }

    // Getters
    public String getName() { return name; }
    public int getMarks() { return marks; }
    public String getGrade() { return grade; }
    public double getPercentage() { return percentage; }

    public void displaySubjectDetails() {
        System.out.println("\nSubject: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
        System.out.println("Percentage: " + percentage + "%");
    }
}

class Examination {
    private ArrayList<Subject> subjects;
    private double overallPercentage;
    private String overallGrade;

    public Examination() {
        subjects = new ArrayList<>();
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
        calculateOverallPerformance();
    }

    private void calculateOverallPerformance() {
        double totalMarks = 0;
        for (Subject subject : subjects) {
            totalMarks += subject.getMarks();
        }
        overallPercentage = (totalMarks / (subjects.size() * 100)) * 100;
        
        if (overallPercentage >= 90) overallGrade = "A+";
        else if (overallPercentage >= 80) overallGrade = "A";
        else if (overallPercentage >= 70) overallGrade = "B+";
        else if (overallPercentage >= 60) overallGrade = "B";
        else if (overallPercentage >= 50) overallGrade = "C";
        else if (overallPercentage >= 40) overallGrade = "D";
        else overallGrade = "F";
    }

    public void displayExamResults() {
        System.out.println("\n--- Examination Results ---");
        for (Subject subject : subjects) {
            subject.displaySubjectDetails();
        }
        System.out.println("\nOverall Performance:");
        System.out.println("Percentage: " + overallPercentage + "%");
        System.out.println("Grade: " + overallGrade);
    }
}

public class StudentManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static HashMap<Integer, Examination> examinations = new HashMap<>(); // Store exams by roll number
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n========================Student Management System=======================");
            
            System.out.println("1. Add New Student");
            System.out.println("2. Add Examination Details");
            System.out.println("3. View Student Details");
            System.out.println("4. View Examination Results");
            System.out.println("5. $$ Exit $$");
            System.out.print("\n***Enter Your Choice***\n");
            
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    addExaminationDetails();
                    break;
                case 3:
                    viewStudentDetails();
                    break;
                case 4:
                    viewExaminationResults();
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.println("\n================Enter Student Details:==============");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Roll Number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        System.out.print("Date of Birth (DD/MM/YYYY): ");
        String dob = scanner.nextLine();
        
        System.out.print("Email: ");
        String email = scanner.nextLine();
        
        System.out.print("Student ID: ");
        String studentId = scanner.nextLine();
        
        System.out.print("Course: ");
        String course = scanner.nextLine();
        
        Student student = new Student(name, rollNumber, dob, email, studentId, course);
        students.add(student);
        System.out.println("...Student added successfully!...");
    }

    private static void addExaminationDetails() {
        if (students.isEmpty()) {
            System.out.println("No students available. Please add a student first.");
            return;
        }
        
        System.out.print("Enter student roll number to add examination details: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        Student student = findStudentByRollNumber(rollNumber);
        if (student == null) {
            System.out.println("!!!Error  Student not found with roll number: " + rollNumber);
            return;
        }
        
        Examination examination = new Examination();
        
        System.out.println("\nEnter marks for 5 subjects (Out of 100):");
        for (int i = 1; i <= 5; i++) {
            System.out.print("Subject " + i + " name: ");
            String subjectName = scanner.nextLine();
            
            System.out.print("Marks for " + subjectName + ": ");
            int marks = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks!!. Please enter between 0-100.");
                i--; // Retry this subject
                continue;
            }
            
            examination.addSubject(new Subject(subjectName, marks));
        }
        
        // Store the examination in the HashMap
        examinations.put(rollNumber, examination);
        System.out.println("\n Congratulation... Examination details added successfully for " + student.getName());
        examination.displayExamResults();
    }

    private static void viewStudentDetails() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        
        System.out.print("Enter student roll number to view details: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        Student student = findStudentByRollNumber(rollNumber);
        if (student == null) {
            System.out.println("Error!!! Student not found with roll number: " + rollNumber);
            return;
        }
        
        student.displayDetails();
    }

    private static void viewExaminationResults() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        
        System.out.print("Enter student roll number to view examination results: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        Student student = findStudentByRollNumber(rollNumber);
        if (student == null) {
            System.out.println("Student not found with roll number: " + rollNumber);
            return;
        }
        
        Examination examination = examinations.get(rollNumber);
        if (examination == null) {
            System.out.println("Error!! No examination results found for " + student.getName());
            return;
        }
        
        System.out.println("\nExamination results for " + student.getName() + ":");
        examination.displayExamResults();
    }

    private static Student findStudentByRollNumber(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }
}
