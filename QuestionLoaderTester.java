import java.io.FileNotFoundException;

/***************************************
 * QuestionLoaderTester.java
 * Runs white-box tests for QuestionLoader class
 * @author Tyler Eaden
 * @version 1.0
 ****************************************/

public class QuestionLoaderTester {

    public static void main(String args[]) {
        try {
            Question[] funQuestions = QuestionLoader.LoadQuestions(Category.FUNDAMENTALS);
            Question[] javaQuestions = QuestionLoader.LoadQuestions(Category.JAVA);
            Question[] cQuestions = QuestionLoader.LoadQuestions(Category.C);
            Question[] jSquestions = QuestionLoader.LoadQuestions(Category.JAVASCRIPT);

            // Expect to have all records from database
            System.out.println("Expect 10 Fundamental questions: " + (funQuestions.length == 10));
            System.out.println("Expect 11 Java questions: " + (javaQuestions.length == 11));
            System.out.println("Expect 8 C questions: " + (cQuestions.length == 8));
            System.out.println("Expect 8 JavaScript questions: " + (jSquestions.length == 8));
        } catch (FileNotFoundException e) {
            System.err.println("Loading database files failed during QuestionLoaderTesting");
        }
    }
}