
/***************************************
 * QuestionLoader.java
 * Loads questions for quiz
 * @author Tyler Eaden
 * @version 1.0
 ****************************************/

import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;

/**
 * Important Note:
 * QuestionLoader heavily uses CSV parsing techniques learned from Project 1
 * Project 1 will be included in the submission files as a reference
 */
public final class QuestionLoader {
    
    /* Citation referenced for final class and private constructor:
    https://stackoverflow.com/questions/56811040/preventing-a-java-class-from-
    being-instantiated-and-inherited */
    private QuestionLoader() {
    }

    public static Question[] LoadQuestions(Category targetCategory) throws FileNotFoundException {
        ArrayList<Question> qList = LoadEssays(targetCategory);
        ArrayList<Question> multList = LoadMultipleChoice(targetCategory);
        qList.addAll(multList);
        Question[] questions = new Question[qList.size()];

        for (int i = 0; i < qList.size(); i++) {
            questions[i] = qList.get(i);
        }

        return questions;
    }

    private static ArrayList<Question> LoadEssays(Category targetCategory) throws FileNotFoundException {
        ArrayList<Question> essays = new ArrayList<Question>();

        Scanner scan;

        scan = new Scanner(new File("Essay.csv"));
        scan.nextLine();
        while (scan.hasNextLine()) {

            String[] qArgs = separateArgs(scan.nextLine());

            String prompt = qArgs[0];
            String correctAnswer = qArgs[1];
            Category category = Category.valueOf(qArgs[2]);
            int maxLength = (qArgs.length > 3) ? Integer.parseInt(qArgs[3]) : 0;

            if (targetCategory == category) {
                Essay essay = (maxLength == 0) ? new ShortAnswer(prompt, correctAnswer, category) : new Essay(prompt, correctAnswer, category, maxLength);
                essays.add(essay);
            }
        }

        scan.close();
        return essays;
    }

    private static ArrayList<Question> LoadMultipleChoice(Category targetCategory) throws FileNotFoundException {
        ArrayList<Question> multChoiceList = new ArrayList<Question>();
        Scanner scan;

        scan = new Scanner(new File("MultipleChoice.csv"));
        scan.nextLine();
        while (scan.hasNextLine()) {

            String[] qArgs = separateArgs(scan.nextLine());

            String prompt = qArgs[0];
            String correctAnswer = qArgs[1];
            Category category = Category.valueOf(qArgs[2]);
            MultipleChoice multChoice;

            if (targetCategory == category) {
                if (qArgs.length > 3) {
                    String[] choices = qArgs[3].split(", ");
                    multChoice = new MultipleChoice(prompt, correctAnswer, category, choices);
                } else {
                    multChoice = new TrueFalse(prompt, correctAnswer, category);
                }

                multChoiceList.add(multChoice);
            }
        }

        scan.close();
        return multChoiceList;
    }

    private static String[] separateArgs(String args) {

        /* Citation Referenced for using regex to split on CSV file
        https://stackoverflow.com/questions/15738918/splitting-a-csv-file-with-quotes-as-text-delimiter-using-string-split/15739087#15739087 */
        String[] newArgs = args.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
        
        for (int i = 0; i < newArgs.length; i++) {
            newArgs[i] = newArgs[i].replace("\"", "");
        }

        return newArgs;
    }
}