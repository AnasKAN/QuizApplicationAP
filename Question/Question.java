package Question;
public class Question {

    private String questionID;
    private String theQuestion;
    private String theAnswer;
    private String choiceOne;
    private String choiceTwo;
    private String choiceThree;
    private String questionHint;
    

    // Constructor 1 - Default Constructor
    public Question() {
    }

    // Constructor 2 - Parameterized Constructor
    public Question(String questionID, String theQuestion, String theAnswer, String choiceOne, String choiceTwo, String choiceThree, String questionHint) {
        this.questionID = questionID;
        this.theQuestion = theQuestion;
        this.theAnswer = theAnswer;
        this.choiceOne = choiceOne;
        this.choiceTwo = choiceTwo;
        this.choiceThree = choiceThree;
        this.questionHint = questionHint;
    }

    // Getter and Setter for questionID
    public String getQuestionID() {
        return questionID;
    }

    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

    // Getter and Setter for theQuestion
    public String getTheQuestion() {
        return theQuestion;
    }

    public void setTheQuestion(String theQuestion) {
        this.theQuestion = theQuestion;
    }

    // Getter and Setter for theAnswer
    public String getTheAnswer() {
        return theAnswer;
    }

    public void setTheAnswer(String theAnswer) {
        this.theAnswer = theAnswer;
    }

    // Getter and Setter for choiceOne
    public String getChoiceOne() {
        return choiceOne;
    }

    public void setChoiceOne(String choiceOne) {
        this.choiceOne = choiceOne;
    }

    // Getter and Setter for choiceTwo
    public String getChoiceTwo() {
        return choiceTwo;
    }

    public void setChoiceTwo(String choiceTwo) {
        this.choiceTwo = choiceTwo;
    }

    // Getter and Setter for choiceThree
    public String getChoiceThree() {
        return choiceThree;
    }

    public void setChoiceThree(String choiceThree) {
        this.choiceThree = choiceThree;
    }

    // Getter and Setter for questionHint
    public String getQuestionHint() {
        return questionHint;
    }

    public void setQuestionHint(String questionHint) {
        this.questionHint = questionHint;
    }

}
