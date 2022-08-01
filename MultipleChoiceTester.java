/***************************************
 * MultipleChoiceTester.java
 * Runs white-box tests for MultipleChoice class
 * @author Tyler Eaden
 * @version 1.0
 ****************************************/

public class MultipleChoiceTester {

    public static void main(String args[]) {

        // Instantiate test parameters
        String prompt = "What is this test about?";

        String correctAnswer = "taco";

        Category category = Category.FUNDAMENTALS;

        String[] choices = new String[] { "taco", "burrito", "hamburger", "pizza" };

        // Instantiate object for testing
        MultipleChoice testMultChoice = new MultipleChoice(prompt, correctAnswer, category, choices);

        // Test getters
        System.out.println("Expect getPrompt to return correct value: " + testMultChoice.getPrompt().equals(prompt));
        System.out.println("Expect getCorrectAnswer to return correct value: " + testMultChoice.getCorrectAnswer().equals(correctAnswer));
        System.out.println("Expect getCategory to return correct value: " + (testMultChoice.getCategory() == category));
        System.out.println("Expect toString to return correct value: " + testMultChoice.toString().equals(prompt + '\n' + "Please type the letter of your chosen answer:\na. taco\nb. burrito\nc. hamburger\nd. pizza\n"));

        // Test validate
        System.out.println("Expect in-range answer to succeed: " + testMultChoice.validate("a"));
        System.out.println("Expect no answer to fail: " + !testMultChoice.validate(""));
        System.out.println("Expect more than one char to fail: " + !testMultChoice.validate("hello"));
        System.out.println("Expect out-of-range answer to fail: " + !testMultChoice.validate("z"));

        // // Test compareAnswer
        System.out.println("Expect a to succeed: " + testMultChoice.compareAnswer("a"));
        System.out.println("Expect b to fail: " + !testMultChoice.compareAnswer("b"));
        System.out.println("Expect c to fail: " + !testMultChoice.compareAnswer("c"));
        System.out.println("Expect d to fail: " + !testMultChoice.compareAnswer("d"));
    }
}