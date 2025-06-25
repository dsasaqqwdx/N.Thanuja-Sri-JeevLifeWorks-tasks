package ui;

import model.Student;
import service.StudentService;
import service.StudentServiceImpl;
import util.CSVExporter;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class StudentManagementApp {

    private static final StudentService studentService = new StudentServiceImpl();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean runApp = true;

        while (runApp) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Export to CSV");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addStudent(scanner);
                case 2 -> viewStudents();
                case 3 -> updateStudent(scanner);
                case 4 -> deleteStudent(scanner);
                case 5 -> exportCSV();
                case 6 -> runApp = false;
                default -> System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Course: ");
        String course = scanner.nextLine();

        studentService.addStudent(new Student(id, name, email, course));
        System.out.println("Student added successfully.");
    }

    private static void viewStudents() {
        List<Student> students = studentService.getAllStudents();
        students.forEach(System.out::println);
    }

    private static void updateStudent(Scanner scanner) {
        System.out.print("Enter Student ID to Update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Optional<Student> optionalStudent = studentService.getStudentById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            System.out.print("Enter New Name: ");
            student.setName(scanner.nextLine());
            System.out.print("Enter New Email: ");
            student.setEmail(scanner.nextLine());
            System.out.print("Enter New Course: ");
            student.setCourse(scanner.nextLine());

            studentService.updateStudent(student);
            System.out.println("Student updated.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void deleteStudent(Scanner scanner) {
        System.out.print("Enter Student ID to Delete: ");
        int id = scanner.nextInt();
        studentService.deleteStudent(id);
        System.out.println("Student deleted.");
    }

    private static void exportCSV() {
        List<Student> students = studentService.getAllStudents();
        CSVExporter.exportToCSV(students, "students.csv");
    }
}
