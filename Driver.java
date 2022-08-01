/***************************************
 * Driver.java
 * Generates and grades quizzes on various computer science topics
 * @author Tyler Eaden
 * @version 1.0
 ****************************************/

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("Please type one of the below numbers to choose a topic for your quiz:");
                Category[] categories = Category.values();
                for (int i = 0; i < categories.length; i++) {
                    System.out.println((i + 1) + ". " + categories[i]);
                }

                System.out.print("\nYour answer: ");
                int catNum = scan.nextInt() - 1;
                while (catNum + 1 > categories.length || catNum < 0) {

                    for (int i = 0; i < categories.length; i++) {
                        System.out.println((i + 1) + ". " + categories[i]);
                    }

                    System.err.println("\nPlease enter a number in range");
                    System.out.print("Your answer: ");
                    catNum = scan.nextInt() - 1;
                }
                scan.nextLine();

                // Generate test based on user's selected category and initiate attempt
                Test test = new Test(QuestionLoader.LoadQuestions(categories[catNum]));
                Attempt attempt = new Attempt(test);

                // Begin test
                Question[] testQuestions = test.getQuestions();
                for (int i = 0; i < testQuestions.length; i++) {
                    Question current = testQuestions[i];
                    System.out.println('\n' + current.toString());
                    System.out.print("Your answer: ");
                    
                    String response = scan.nextLine();

                    // Ensure answer is properly validated before it is accepted
                    while (!current.validate(response)) {
                        System.out.println("\n\n" + current.toString());
                        System.out.print("Your answer: ");
                        response = scan.nextLine();
                    }
                    attempt.acceptAnswer(i, response);
                }

                // Grade the completed test
                attempt.gradeAnswers();

                char c;
                if (attempt.getPoints() < testQuestions.length) {
                    System.out.println("\nWould you like to see the answers you missed? (Y/y) (N/n)");
                    System.out.print("Your answer: ");
                    c = scan.next().toLowerCase().charAt(0);
    
                    if (c == 'y') {
                        attempt.printMissedQuestions();
                    }
                }

                System.out.println("Would you like to play again? (Y/y) (N/n)");
                System.out.print("Your answer: ");
                c = scan.next().toLowerCase().charAt(0);

                if (c != 'y') {
                    break;
                }

            }
        } catch (FileNotFoundException e) {
            System.err.println("CSV Database Files Not Found!");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch(InputMismatchException e) {
            System.err.println("Please enter input of the appropriate type!");
        } catch(Exception e) {
            System.err.println(e);
        } finally {
            scan.close();
        }
    }
}