/***************************************
 * Test.java
 * Represents a quiz
 * @author Tyler Eaden
 * @version 1.0
 ****************************************/

public class Test {
    protected Question[] questions;

    public Test(Question[] q) {
        this.questions = q;
    }

    public Question[] getQuestions() {
        return this.questions;
    }
}