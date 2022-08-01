/***************************************
 * ShortAnswerTester.java
 * Runs white-box tests for ShortAnswer class
 * @author Tyler Eaden
 * @version 1.0
 ****************************************/

public class ShortAnswerTester {

    public static void main(String args[]) {

        // Instantiate test parameters
        String prompt = "What is this test about?";

        String correctAnswer = "nothing";

        Category category = Category.FUNDAMENTALS;

        int maxLength = 20;

        // Instantiate object for testing
        ShortAnswer testShortAnswer = new ShortAnswer(prompt, correctAnswer, category);

        // Test getters
        System.out.println("Expect getPrompt to return correct value: " + testShortAnswer.getPrompt().equals(prompt));
        System.out.println("Expect getCorrectAnswer to return correct value: " + testShortAnswer.getCorrectAnswer().equals(correctAnswer));
        System.out.println("Expect getCategory to return correct value: " + (testShortAnswer.getCategory() == category));
        System.out.println("Expect getMaxLength to return correct value: " + (testShortAnswer.getMaxLength() == maxLength));
        System.out.println("Expect toString to return correct value: " + testShortAnswer.toString().equals(prompt + " (" + maxLength + " word maximum)"));

        // Test validate
        String bigString = "hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello";

        System.out.println("Expect 0 response length to succeed: " + testShortAnswer.validate(""));
        System.out.println("Expect one word response to succeed: " + testShortAnswer.validate("hello"));
        System.out.println("Expect massive response length to fail: " + !testShortAnswer.validate(bigString));
        System.out.println("Expect space to succeed: " + testShortAnswer.validate(" "));
        System.out.println("Expect punctuation mark to succeed: " + testShortAnswer.validate("."));

        // Test compareAnswer
        System.out.println("Expect no   thing to succeed: " + testShortAnswer.compareAnswer("no   thing"));
        System.out.println("Expect NOTHING to succeed: " + testShortAnswer.compareAnswer("NOTHING"));
        System.out.println("Expect no Thing z to fail: " + !testShortAnswer.compareAnswer("no Thing z"));
    }
}