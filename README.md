# Student Management System

## Overview
This Java-based Student Management System is a console application designed to manage student records and their examination details. The system allows administrators to add new students, record examination marks for multiple subjects, and view both student information and examination results.

## Features

### Student Management
- Add new students with details:
  - Name
  - Roll Number
  - Date of Birth
  - Email
  - Student ID
  - Course
- View individual student details

### Examination Management
- Record examination marks for 5 subjects per student
- Automatic grade calculation (A+, A, B+, B, C, D, F)
- Percentage calculation for each subject
- Overall performance calculation
- View comprehensive examination results

### Data Storage
- In-memory storage using ArrayList for students
- HashMap to associate examination results with student roll numbers

## How to Use

1. **Main Menu Options**:
   - `1. Add New Student`: Create a new student record
   - `2. Add Examination Details`: Record exam marks for an existing student
   - `3. View Student Details`: Display information for a specific student
   - `4. View Examination Results`: Show exam results for a student
   - `5. Exit`: Close the application

2. **Adding a Student**:
   - Enter all required personal information
   - Student will be added to the system

3. **Adding Exam Details**:
   - Enter the student's roll number
   - Input marks (0-100) for 5 subjects
   - System automatically calculates grades and percentages

4. **Viewing Information**:
   - Use the student's roll number to retrieve:
     - Personal details
     - Examination results with grades

## Technical Details

### Classes
- **Student**: Stores personal information and displays details
- **Subject**: Manages subject name, marks, grade, and percentage
- **Examination**: Handles multiple subjects, calculates overall performance
- **StudentManagementSystem**: Main class with menu system and program flow

### Data Structures
- `ArrayList<Student>`: Stores all student records
- `HashMap<Integer, Examination>`: Maps roll numbers to examination results

### Input Validation
- Marks are validated to be between 0-100
- Roll number checking ensures students exist before adding exams

## Requirements
- Java JDK 8 or later
- Standard Java libraries only (no external dependencies)

## How to Run
1. Compile the Java file:
   ```bash
   javac StudentManagementSystem.java
   ```
2. Run the compiled program:
   ```bash
   java StudentManagementSystem
   ```

