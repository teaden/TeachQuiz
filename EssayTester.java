/***************************************
 * EssayTester.java
 * Runs white-box tests for Essay class
 * @author Tyler Eaden
 * @version 1.0
 ****************************************/

public class EssayTester {

    public static void main(String args[]) {

        // Instantiate test parameters
        String prompt = "What is this test about?";

        String correctAnswer = "It was a dark and stormy night; the rain fell in torrents, except at occasional intervals, when it was checked by a violent gust of wind which swept up the streets (for it is in London that our scene lies), rattling along the house-tops, and fiercely agitating the scanty flame of the lamps that struggled against the darkness.";

        Category category = Category.FUNDAMENTALS;

        int maxLength = 350;

        // Instantiate object for testing
        Essay testEssay = new Essay(prompt, correctAnswer, category, maxLength);

        // Test getters
        System.out.println("Expect getPrompt to return correct value: " + testEssay.getPrompt().equals(prompt));
        System.out.println("Expect getCorrectAnswer to return correct value: " + testEssay.getCorrectAnswer().equals(correctAnswer));
        System.out.println("Expect getCategory to return correct value: " + (testEssay.getCategory() == category));
        System.out.println("Expect getMaxLength to return correct value: " + (testEssay.getMaxLength() == maxLength));
        System.out.println("Expect toString to return correct value: " + testEssay.toString().equals(prompt + " (" + maxLength + " word maximum)"));

        // Test validate
        String bigString = "hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello";

        System.out.println("Expect 0 response length to succeed: " + testEssay.validate(""));
        System.out.println("Expect one word response to fail: " + !testEssay.validate("hello"));
        System.out.println("Expect massive response length to fail: " + !testEssay.validate(bigString));
        System.out.println("Expect space to succeed: " + testEssay.validate(" "));
        System.out.println("Expect punctuation mark to succeed: " + testEssay.validate("."));

        // Test compareAnswer
        System.out.println("Expect less than a 10% similarity in tokens to fail: " + !testEssay.compareAnswer("It"));
        System.out.println("Expect less than a 10% similarity in tokens to fail: " + testEssay.compareAnswer("It was a dark and stormy night; the rain fell in torrents, except at occasional intervals"));
    }
}