/***************************************
 * MultipleChoice.java
 * Represents a multiple choice quiz question
 * @author Tyler Eaden
 * @version 1.0
 ****************************************/

public class MultipleChoice extends Question {
    protected String[] choices;

    public MultipleChoice(String prompt, String correctAnswer, Category category, String[] choices) {
        super(prompt, correctAnswer, category);
        verifyChoices(correctAnswer, choices);
    }

    public Boolean validate(String response) {
        if (response.length() != 1) {
            System.err.println("You must select an answer!");
            return false;
        }

        int choiceIndex = findChoiceIndex(response);
        if (choiceIndex > this.choices.length - 1 || choiceIndex < 0) {
            System.err.println("You must select an answer that is within the given choices!");
            return false;
        }

        return true;
    }

    public Boolean compareAnswer(String response) {
        if (this.choices[findChoiceIndex(response)].equalsIgnoreCase(this.correctAnswer)) {
            return true;
        }
        return false;
    }

    public String toString() {
        String question = this.prompt + '\n' + "Please type the letter of your chosen answer:" + '\n';
        
        for (int i = 0; i < this.choices.length; i++) {
            question += Character.toChars('a' + i)[0] + ". " + this.choices[i] + '\n';
        }

        return question;
    }

    // Converts letter designation of user selected answer choice to int for array indexing
    private int findChoiceIndex(String response) {
        return response.toLowerCase().charAt(0) - 'a';
    }

    // Ensures answer choices supplied to constructor are valid
    private void verifyChoices(String answer, String[] choices) {
        int i, len = choices.length;

        if (len < 2) {
            throw new IllegalArgumentException("A multiple choice question must have multiple choices!");
        }

        for (i = 0; answer.equals(choices[i]) == false && i < len; i++);

        if (i == len) {
            throw new IllegalArgumentException("Specified correct answer must be in choices array!");
        }
        
        this.choices = choices;
    }
}