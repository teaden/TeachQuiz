/***************************************
 * TrueFalse.java
 * Represents a true or false quiz question
 * @author Tyler Eaden
 * @version 1.0
 ****************************************/

public class TrueFalse extends MultipleChoice {

    public TrueFalse(String prompt, String correctAnswer, Category category) {
        super(prompt, correctAnswer, category, new String[]{"true", "false"});
    }
}