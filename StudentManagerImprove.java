/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dung.assignment1;
    import java.util.*;

/**
 *
 * @author Admin
 */
public class StudentManagerImprove {

    private Map<String, Student> students;

    public StudentManagerImprove() {
        students = new HashMap<>();
    }

    public void addStudent(String id, String name, int age, double score) {
        if (students.containsKey(id)) {
            System.out.println("Student with ID " + id + " already exists.");
            return;
        }
        Student student = new Student(id, name, age, score);
        students.put(id, student);
        System.out.println("Student added: " + student);
    }

    public void updateStudent(String editId, String newId, String newName, int newAge, double newScore) {
        if (!students.containsKey(editId)) {
            System.out.println("Student with ID " + editId + " not found.");
            return;
        }
        Student student = students.get(editId);
        student.setId(newId);
        student.setName(newName);
        student.setAge(newAge);
        student.setScore(newScore);
        students.put(newId, student);
        if (!newId.equals(editId)) {
            students.remove(editId);
        }
        System.out.println("Student updated: " + student);
    }

    public Student getStudent(String id) {
        if (!students.containsKey(id)) {
            System.out.println("Student with ID " + id + " not found.");
            return null;
        }
        return students.get(id);
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student student : students.values()) {
            System.out.println(student);
        }
    }

    public void displayAllStudentsWithRanks() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        List<Student> sortedStudents = new ArrayList<>(students.values());
        sortedStudents.sort(Comparator.comparingDouble(Student::getScore).reversed());
        int rank = 1;
        for (Student student : sortedStudents) {
            System.out.println("Rank " + rank + ": " + student);
            rank++;
        }
    }

    public List<Student> searchStudentsByName(String name) {
        List<Student> result = new ArrayList<>();
        for (Student student : students.values()) {
            if (student.getName().equalsIgnoreCase(name)) {
                result.add(student);
            }
        }
        return result;
    }

    public void sortStudentsByScore() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        List<Student> sortedStudents = new ArrayList<>(students.values());
        sortedStudents.sort(Comparator.comparingDouble(Student::getScore).reversed());
        System.out.println("Students sorted by score:");
        for (Student student : sortedStudents) {
            System.out.println(student);
        }
    }

    public void removeStudent(String id) {
        if (students.containsKey(id)) {
            students.remove(id);
            System.out.println("Student with ID " + id + " removed.");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }
    public boolean studentExists(String id) {
    return students.containsKey(id);
}

}


