/***************************************
 * Attempt.java
 * Represents a user attempt on a test
 * @author Tyler Eaden
 * @version 1.0
 ****************************************/

import java.util.ArrayList;

public class Attempt {
    private Test test;
    private String[] userAnswers;
    private Boolean graded;
    private ArrayList<Integer> missedQuestions;
    private int points;
    
    public Attempt(Test test) {
        this.test = test;
        this.userAnswers = new String[test.getQuestions().length];
        this.graded = false;
        this.missedQuestions = new ArrayList<Integer>();
        this.points = 0;
    }

    public int getPoints() {
        return this.points;
    }

    public void acceptAnswer(int i, String userAnswer) {
        this.userAnswers[i] = userAnswer;
    }

    public void gradeAnswers() {
        Question[] questions = this.test.getQuestions();
        for (int i = 0; i < questions.length; i++) {
            if (!questions[i].compareAnswer(this.userAnswers[i])) {
                this.missedQuestions.add(i);
            } else {
                this.points++;
            }
        }

        System.out.println("\nYour Score: " + this.points + " / " + questions.length);
        this.graded = true;
    }

    public void printMissedQuestions() {
        if (!this.graded) {
            System.err.println("The test has not yet been graded!");
        } else {
            for (int i = 0; i < this.missedQuestions.size(); i++) {
                int curr = this.missedQuestions.get(i);
                System.out.println("\n#" + (curr + 1) + ": " + this.test.questions[curr].toString());
                System.out.println("Your Answer: " + this.userAnswers[curr] + '\n');
                System.out.println("Correct Answer: " + this.test.questions[curr].getCorrectAnswer());
                System.out.println("-------------\n");
            }
        }
    }
}