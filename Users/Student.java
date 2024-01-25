package Users;

import java.util.HashMap;

public class Student extends User{

    private HashMap<String, Short> studentGrade;

    // Constructor 1 - Default Constructor
    public Student() {
        this.studentGrade = new HashMap<>();
    }

    // Constructor 2 - Parameterized Constructor
    public Student(String personID, String firstName, String lastName, String email, String password) {
        super(personID, firstName, lastName, email, password, Role.STUDENT);
        this.studentGrade = new HashMap<>();
    }

    // Getter and Setter for studentGrade
    public HashMap<String, Short> getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(HashMap<String, Short> studentGrade) {
        this.studentGrade = studentGrade;
    }

    // Method to add a grade for a quiz
    public void addGrade(String quizID, short grade) {
        studentGrade.put(quizID, grade);
    }

    // Method to get a grade for a quiz
    public Short getGrade(String quizID) {
        return studentGrade.get(quizID);
    }

    
}
