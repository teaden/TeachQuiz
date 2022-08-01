/***************************************
 * AttemptTest.java
 * Runs whitebox & integration tests for Attempt class
 * @author Tyler Eaden
 * @version 1.0
 ****************************************/

public class AttemptTester {

    public static void main(String args[]) {

        // Instantiate test parameters
        Question mCq = new MultipleChoice("What is the best activity", "running", Category.FUNDAMENTALS, new String[]{"dancing", "sports", "fishing", "running"});
        Question sAq = new ShortAnswer("What is your favorite city?", "Tokyo", Category.FUNDAMENTALS);

        // Instantiate objects for testing
        Test test = new Test(new Question[]{mCq, sAq});
        Attempt attempt = new Attempt(test);

        // Test getters
        System.out.println("Expect ungraded attempt points to be 0: " + (attempt.getPoints() == 0));

        // Test has-a methods

        // Accepts running for multiple-choice question answer
        attempt.acceptAnswer(0, "b");
        attempt.printMissedQuestions();

        // Accepts Tokyo for short answer question answer
        attempt.acceptAnswer(1, "Tokyo");

        attempt.gradeAnswers();

        System.out.println("Expect graded attempt points to be 1: " + (attempt.getPoints() == 1));
    }
}