/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dung.assignment1;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class StudentManagerMethodImprove {
       public static void main(String[] args) {
        StudentManagerImprove manager = new StudentManagerImprove();
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            displayMenu();
            int choice = getChoice(sc);
            
            switch (choice) {
                case 1 -> addStudents(sc, manager);
                case 2 -> manager.displayAllStudents();
                case 3 -> manager.displayAllStudentsWithRanks();
                case 4 -> searchStudentsByName(sc, manager);
                case 5 -> editStudent(sc, manager);
                case 6 -> manager.sortStudentsByScore();
                case 7 -> removeStudent(sc, manager);
                case 8 -> exitProgram(sc);
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n1. Add Student");
        System.out.println("2. Display all students");
        System.out.println("3. Display all students with rank");
        System.out.println("4. Search for students by name");
        System.out.println("5. Edit a student's information");
        System.out.println("6. Sort students by score");
        System.out.println("7. Remove a student by ID");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getChoice(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Enter a number: ");
            sc.next(); // Consume invalid input
        }
        int choice = sc.nextInt();
        sc.nextLine();  // Consume newline
        return choice;
    }

    private static void addStudents(Scanner sc, StudentManagerImprove manager) {
        System.out.print("Enter number of students to add: ");
        int n = getValidInt(sc);

        for (int i = 0; i < n; i++) {
            String id = getNonEmptyInput(sc, "Enter ID for student: ");
            String name = getNonEmptyInput(sc, "Enter name for student: ");
            System.out.print("Enter age for student: ");
            int age = getValidInt(sc);
            System.out.print("Enter score for student: ");
            double score = getValidDouble(sc);

            manager.addStudent(id, name, age, score);
        }
    }

    private static void searchStudentsByName(Scanner sc, StudentManagerImprove manager) {
        System.out.print("Enter name to search: ");
        String name = sc.nextLine();
        List<Student> results = manager.searchStudentsByName(name);
        if (results.isEmpty()) {
            System.out.println("No students found with name " + name);
        } else {
            System.out.println("Search results:");
            for (Student student : results) {
                System.out.println(student);
            }
        }
    }

    private static void editStudent(Scanner sc, StudentManagerImprove manager) {
        System.out.print("Enter ID of student to edit: ");
        String editId = sc.nextLine();
        System.out.print("Enter new ID: ");
        String newId = getNonEmptyInput(sc, "Enter ID for student: ");
        System.out.print("Enter new name: ");
        String newName = getNonEmptyInput(sc, "Enter name for student: ");
        System.out.print("Enter new age: ");
        int newAge = getValidInt(sc);
        System.out.print("Enter new score: ");
        double newScore = getValidDouble(sc);

        manager.updateStudent(editId, newId, newName, newAge, newScore);
    }

     private static void removeStudent(Scanner sc, StudentManagerImprove manager) {
        System.out.print("Enter ID of student to remove: ");
        String id = sc.nextLine();
        if (!manager.studentExists(id)) {
            System.out.println("Student with ID " + id + " not found.");
            return;
                    
        }
        manager.removeStudent(id);
    }

    private static void exitProgram(Scanner sc) {
           try (sc) {
               System.out.println("Exiting...");
           }
        System.exit(0);
    }

    private static int getValidInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Enter an integer: ");
            sc.next(); // Consume invalid input
        }
        int value = sc.nextInt();
        sc.nextLine();  // Consume newline
        return value;
    }

    private static double getValidDouble(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.print("Invalid input. Enter a number with decimal points: ");
            sc.next(); // Consume invalid input
        }
        double value = sc.nextDouble();
        sc.nextLine();  // Consume newline
        return value;
    }
    private static String getNonEmptyInput(Scanner sc, String prompt) {
    System.out.print(prompt);
    String input = sc.nextLine().trim();
    while (input.isEmpty()) {
        System.out.print("Input cannot be empty. " + prompt);
        input = sc.nextLine().trim();
    }
    return input;
}

}
