/***************************************
 * TrueFalseTester.java
 * Runs white-box tests for MultipleChoice class
 * @author Tyler Eaden
 * @version 1.0
 ****************************************/

public class TrueFalseTester {

    public static void main(String args[]) {

        // Instantiate test parameters
        String prompt = "What is this test about?";

        String correctAnswer = "true";

        Category category = Category.FUNDAMENTALS;;

        // Instantiate object for testing
        TrueFalse testTrueFalse = new TrueFalse(prompt, correctAnswer, category);

        // Test getters
        System.out.println("Expect getPrompt to return correct value: " + testTrueFalse.getPrompt().equals(prompt));
        System.out.println("Expect getCorrectAnswer to return correct value: " + testTrueFalse.getCorrectAnswer().equals(correctAnswer));
        System.out.println("Expect getCategory to return correct value: " + (testTrueFalse.getCategory() == category));
        System.out.println("Expect toString to return correct value: " + testTrueFalse.toString().equals(prompt + '\n' + "Please type the letter of your chosen answer:\na. true\nb. false\n"));

        // Test validate
        System.out.println("Expect in-range answer to succeed: " + testTrueFalse.validate("a"));
        System.out.println("Expect no answer to fail: " + !testTrueFalse.validate(""));
        System.out.println("Expect more than one char to fail: " + !testTrueFalse.validate("hello"));
        System.out.println("Expect out-of-range answer to fail: " + !testTrueFalse.validate("z"));

        // // Test compareAnswer
        System.out.println("Expect a to succeed: " + testTrueFalse.compareAnswer("a"));
        System.out.println("Expect b to fail: " + !testTrueFalse.compareAnswer("b"));
    }
}