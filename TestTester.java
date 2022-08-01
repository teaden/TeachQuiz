/***************************************
 * TestTester.java
 * Runs whitebox & integration tests for Test class
 * @author Tyler Eaden
 * @version 1.0
 ****************************************/

public class TestTester {

    public static void main(String args[]) {

        // Instantiate test parameters
        String mCprompt = "What is this test about?";
        String mCcorrectAnswer = "taco";
        Category mCcategory = Category.FUNDAMENTALS;
        String[] mChoices = new String[] { "taco", "burrito", "hamburger", "pizza" };

        String tFprompt = "What is this test about?";
        String tFcorrectAnswer = "true";
        Category tFcategory = Category.FUNDAMENTALS;

        String ePrompt = "What is this test about?";
        String eCorrectAnswer = "It was a dark and stormy night; the rain fell in torrents, except at occasional intervals, when it was checked by a violent gust of wind which swept up the streets (for it is in London that our scene lies), rattling along the house-tops, and fiercely agitating the scanty flame of the lamps that struggled against the darkness.";
        Category eCategory = Category.FUNDAMENTALS;
        int eMaxLength = 350;

        String sAprompt = "What is this test about?";
        String sAcorrectAnswer = "nothing";
        Category sAcategory = Category.FUNDAMENTALS;
        int sAmaxLength = 20;

        // Instantiate objects for testing
        MultipleChoice testMultChoice = new MultipleChoice(mCprompt, mCcorrectAnswer, mCcategory, mChoices);
        TrueFalse testTrueFalse = new TrueFalse(tFprompt, tFcorrectAnswer, tFcategory);
        Essay testEssay = new Essay(ePrompt, eCorrectAnswer, eCategory, eMaxLength);
        ShortAnswer testShortAnswer = new ShortAnswer(sAprompt, sAcorrectAnswer, sAcategory);

        Question[] questions = new Question[] { testMultChoice, testTrueFalse, testEssay, testShortAnswer };
        Test test = new Test(questions);

        // Test getters
        Question[] testQuestions = test.getQuestions();
        System.out.println("Expect length to be 4: " + (testQuestions.length == 4));


        // Test Polymorphism: MultipleChoice as Question
        Question mCq = testQuestions[0];

        // Test getters
        System.out.println("Expect getPrompt to return correct value: " + mCq.getPrompt().equals(mCprompt));
        System.out.println("Expect getCorrectAnswer to return correct value: " + mCq.getCorrectAnswer().equals(mCcorrectAnswer));
        System.out.println("Expect getCategory to return correct value: " + (mCq.getCategory() == mCcategory));
        System.out.println("Expect toString to return correct value: " + mCq.toString().equals(mCprompt + '\n' + "Please type the letter of your chosen answer:\na. taco\nb. burrito\nc. hamburger\nd. pizza\n"));

        // Test validate
        System.out.println("Expect in-range answer to succeed: " + mCq.validate("a"));
        System.out.println("Expect no answer to fail: " + !mCq.validate(""));
        System.out.println("Expect more than one char to fail: " + !mCq.validate("hello"));
        System.out.println("Expect out-of-range answer to fail: " + !mCq.validate("z"));

        // // Test compareAnswer
        System.out.println("Expect a to succeed: " + mCq.compareAnswer("a"));
        System.out.println("Expect b to fail: " + !mCq.compareAnswer("b"));
        System.out.println("Expect c to fail: " + !mCq.compareAnswer("c"));
        System.out.println("Expect d to fail: " + !mCq.compareAnswer("d"));


        // Test Polymorphism: TrueFalse as Question
        Question tFq = testQuestions[1];

        // Test getters
        System.out.println("Expect getPrompt to return correct value: " + tFq.getPrompt().equals(tFprompt));
        System.out.println("Expect getCorrectAnswer to return correct value: " + tFq.getCorrectAnswer().equals(tFcorrectAnswer));
        System.out.println("Expect getCategory to return correct value: " + (tFq.getCategory() == tFcategory));
        System.out.println("Expect toString to return correct value: " + tFq.toString().equals(tFprompt + '\n' + "Please type the letter of your chosen answer:\na. true\nb. false\n"));

        // Test validate
        System.out.println("Expect in-range answer to succeed: " + tFq.validate("a"));
        System.out.println("Expect no answer to fail: " + !tFq.validate(""));
        System.out.println("Expect more than one char to fail: " + !tFq.validate("hello"));
        System.out.println("Expect out-of-range answer to fail: " + !tFq.validate("z"));

        // // Test compareAnswer
        System.out.println("Expect a to succeed: " + tFq.compareAnswer("a"));
        System.out.println("Expect b to fail: " + !tFq.compareAnswer("b"));


        // Test Polymorphism: Essay as Question
        Question eQ = testQuestions[2];

        // Test getters
        System.out.println("Expect getPrompt to return correct value: " + eQ.getPrompt().equals(ePrompt));
        System.out.println("Expect getCorrectAnswer to return correct value: " + eQ.getCorrectAnswer().equals(eCorrectAnswer));
        System.out.println("Expect getCategory to return correct value: " + (eQ.getCategory() == eCategory));
        System.out.println("Expect toString to return correct value: " + eQ.toString().equals(ePrompt + " (" + eMaxLength + " word maximum)"));

        // Test validate
        String bigString = "hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello, hello";

        System.out.println("Expect 0 response length to succeed: " + eQ.validate(""));
        System.out.println("Expect one word response to fail: " + !eQ.validate("hello"));
        System.out.println("Expect massive response length to fail: " + !eQ.validate(bigString));
        System.out.println("Expect space to succeed: " + eQ.validate(" "));
        System.out.println("Expect punctuation mark to succeed: " + eQ.validate("."));

        // Test compareAnswer
        System.out.println("Expect less than a 10% similarity in tokens to fail: " + !eQ.compareAnswer("It"));
        System.out.println("Expect less than a 10% similarity in tokens to fail: " + eQ.compareAnswer(
                "It was a dark and stormy night; the rain fell in torrents, except at occasional intervals"));


        // Test Polymoprhism: ShortAnswer as Question
        Question sAq = testQuestions[3];

        // Test getters
        System.out.println("Expect getPrompt to return correct value: " + sAq.getPrompt().equals(sAprompt));
        System.out.println("Expect getCorrectAnswer to return correct value: " + sAq.getCorrectAnswer().equals(sAcorrectAnswer));
        System.out.println("Expect getCategory to return correct value: " + (sAq.getCategory() == sAcategory));
        System.out.println("Expect toString to return correct value: " + sAq.toString().equals(sAprompt + " (" + sAmaxLength + " word maximum)"));

        // Test validate

        System.out.println("Expect 0 response length to succeed: " + sAq.validate(""));
        System.out.println("Expect one word response to succeed: " + sAq.validate("hello"));
        System.out.println("Expect massive response length to fail: " + !sAq.validate(bigString));
        System.out.println("Expect space to succeed: " + sAq.validate(" "));
        System.out.println("Expect punctuation mark to succeed: " + sAq.validate("."));

        // Test compareAnswer
        System.out.println("Expect no   thing to succeed: " + sAq.compareAnswer("no   thing"));
        System.out.println("Expect NOTHING to succeed: " + sAq.compareAnswer("NOTHING"));
        System.out.println("Expect no Thing z to fail: " + !sAq.compareAnswer("no Thing z"));
    }
}