/***************************************
 * ShortAnswer.java
 * Represents a short answer quiz question
 * @author Tyler Eaden
 * @version 1.0
 ****************************************/

public class ShortAnswer extends Essay {

    public ShortAnswer(String prompt, String correctAnswer, Category category) {
        super(prompt, correctAnswer, category, 20);
    }

    public Boolean validate(String response) {
        return compareAnsLength(response);
    }

    // Accurately compares user response against correct answer by removing white space
    public Boolean compareAnswer(String response) {
        String trimmedResponse = removeSpace(response);
        String trimmedCorrectAnswer = removeSpace(this.correctAnswer);

        return trimmedResponse.equalsIgnoreCase(trimmedCorrectAnswer);
    }

    // Returns new version of a String without white space
    private String removeSpace(String response) {
        return response.replace(" ", "");
    }
}