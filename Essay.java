/***************************************
 * Essay.java
 * Represents an essay quiz question
 * 
 * @author Tyler Eaden
 * @version 1.0
 ****************************************/

public class Essay extends Question {
    protected int maxLength;

    public Essay(String prompt, String correctAnswer, Category category, int maxLength) {
        super(prompt, correctAnswer, category);
        if (!checkStrLength(correctAnswer, maxLength)) {
            throw new IllegalArgumentException("Your supplied answer is longer than the maximum length specified!");
        }

        this.maxLength = maxLength;
    }

    /**
     * Ensures length of user response does not exceed maxLength
     * Ensures responses use spaces and/or punctuation for compareAnswer
     * tokenization
     */
    public Boolean validate(String response) {
        if (!compareAnsLength(response)) {
            return false;
        }

        if (response.length() > 0 && splitResponse(response, "\\w+").length == 0) {
            System.err.println("Please reformat your answer with proper spaces and punctuation.");
            return false;
        }

        return true;
    }

    // Returns true if user response and correct answer match by 10% or more
    public Boolean compareAnswer(String response) {
        long matchPercent;
        int matchCount = 0;
        String[] responseTokens = splitResponse(response, "\\W+");
        String[] answerTokens = splitResponse(this.correctAnswer, "\\W+");

        for (String responseToken : responseTokens) {
            for (String answerToken : answerTokens) {
                if (responseToken.equalsIgnoreCase(answerToken)) {
                    matchCount++;
                }
            }
        }

        matchPercent = Math.round(matchCount * 100.0 / answerTokens.length);

        return (matchPercent >= 10) ? true : false;
    }

    public int getMaxLength() {
        return this.maxLength;
    }

    public String toString() {
        String essay = this.prompt + " (" + this.maxLength + " word maximum)";
        return essay;
    }

    // Adds validation message to response length comparision and allows use by
    // child class
    protected Boolean compareAnsLength(String response) {
        if (!checkStrLength(response, this.maxLength)) {
            System.err.println("Your response had too many words! Please enter a new response.");
            return false;
        }

        return true;
    }

    // Reusable user response or correct answer length to maxLength comparison
    // functionality
    private Boolean checkStrLength(String answer, int maxLength) {
        return answer.length() <= maxLength;
    }

    /*
     * Citation for regex that catches non-word literals:
     * https://stackoverflow.com/questions/7384791/splitting-strings-through-regular
     * -expressions-by-punctuation-and-whitespace-etc
     */
    private String[] splitResponse(String response, String regex) {
        return response.split(regex);
    }
}