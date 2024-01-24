package Quiz;
import java.util.Vector;

import Question.Question;

public class Quiz {

    private String quizID;
    private String quizName;
    private short quizTakingTime;
    private String quizEntryCode;
    private Vector <Question> questions;


    // Constructor 1 - Default Constructor
    public Quiz() {
        this.questions = new Vector<>();
    }

    // Constructor 2 - Parameterized Constructor
    public Quiz(String quizID, String quizName, short quizTakingTime, String quizEntryCode, Vector<Question> questions) {
        this.quizID = quizID;
        this.quizName = quizName;
        this.quizTakingTime = quizTakingTime;
        this.quizEntryCode = quizEntryCode;
        this.questions = questions;
    }

    // Getter and Setter for quizID
    public String getQuizID() {
        return quizID;
    }

    public void setQuizID(String quizID) {
        this.quizID = quizID;
    }

    // Getter and Setter for quizName
    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    // Getter and Setter for quizTakingTime
    public short getQuizTakingTime() {
        return quizTakingTime;
    }

    public void setQuizTakingTime(short quizTakingTime) {
        this.quizTakingTime = quizTakingTime;
    }

    // Getter and Setter for quizEntryCode
    public String getQuizEntryCode() {
        return quizEntryCode;
    }

    public void setQuizEntryCode(String quizEntryCode) {
        this.quizEntryCode = quizEntryCode;
    }

    // Getter and Setter for questions
    public Vector<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Vector<Question> questions) {
        this.questions = questions;
    }
    
}
