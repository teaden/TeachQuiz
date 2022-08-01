/***************************************
 * Question.java
 * Represents a generic quiz question
 * 
 * @author Tyler Eaden
 * @version 1.0
 ****************************************/

// Note: I am not testing this class since it is abstract
abstract public class Question {
    protected String prompt;
    protected String correctAnswer;
    protected Category category;

    public Question(String prompt, String correctAnswer, Category category) {
        this.prompt = prompt;
        this.correctAnswer = correctAnswer;
        this.category = category;
    }

    // Ensures user response to question is properly formatted before comparison
    public abstract Boolean validate(String response);

    // Compares user response to question against correct answer
    public abstract Boolean compareAnswer(String answer);

    public String getPrompt() {
        return this.prompt;
    }

    public String getCorrectAnswer() {
        return this.correctAnswer;
    }

    public Category getCategory() {
        return this.category;
    }

    public String toString() {
        return "Category: " + this.category.toString() + '\n' + this.prompt;
    }
}