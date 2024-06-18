/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package dung.assignment1;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
// Main.java
public class Assignment1 {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Add number of student: ");
        n = sc.nextInt();
        sc.nextLine();
        
        // Adding students
        for(int i = 0;i< n; i++){
            System.out.println("Add ID for student: ");
            String id = sc.next();
            System.out.println("Add name for student: ");
            String name = sc.next();
            System.out.println("Add age for student: ");
            int age = sc.nextInt();
            
            System.out.println("Add score for student: ");
            double score = sc.nextDouble();
            
            manager.addStudent(id, name, age, score);
        }
        
//        manager.addStudent(new Student("1", "Alice", 20, 8.55f));
//        manager.addStudent(new Student("2", "Bob", 22, 9.00f));
//        manager.addStudent(new Student("3", "Charlie", 21, 7.83f));

        // Displaying all students
        System.out.println("All Students:");
        manager.displayAllStudents();
        
        // Displaying all student with rank
        System.out.println("All Students with rank:");
        manager.displayAllStudentsWithRanks();
        
            // Searching for students by name
        System.out.println("Search results for name: ");
        String name = sc.next();
        for (Student searchbyname : manager.searchStudentsByName(name)) {
            System.out.println(searchbyname);
            
        }
       
           
        // Editing a student's information
        System.out.println("Edit student with ID: ");
        String editId = sc.next();
        System.out.println("Enter new ID: ");
        String newId = sc.next();
        System.out.println("Enter new name: ");
        String newName = sc.next();
        System.out.println("Enter new age: ");
        int newAge = sc.nextInt();
        System.out.println("Enter new score: ");
        double newScore = sc.nextDouble();

        manager.updateStudent(editId, newId, newName, newAge, newScore);

        // Displaying all students after editing
        System.out.println("All Students after editing:");
        manager.displayAllStudents();
        
        // Sorting students by score
        System.out.println("Sorting student by score: ");
        manager.sortStudentsByScore();
        manager.displayAllStudents();
        
        // Removing a student by ID
        System.out.println("Delete student with ID:");
        String id = sc.next();
        manager.removeStudent(id);

        // Displaying all students after removal
        System.out.println("All Students after removal:");
        manager.displayAllStudents();
        
      
    }
}
