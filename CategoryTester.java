/***************************************
 * CategoryTester.java
 * Runs white-box tests for Category class
 * @author Tyler Eaden
 * @version 1.0
 ****************************************/

public class CategoryTester {

    public static void main(String args[]) {

        // Instantiate objects for testing
        Category fundamentals = Category.FUNDAMENTALS;
        Category java = Category.JAVA;
        Category c = Category.C;
        Category javascript = Category.JAVASCRIPT;

        // Test that toString reflects display name
        System.out.println("FUNDAMENTALS display name is correct: " + fundamentals.toString().equals("Fundamentals"));
        System.out.println("JAVA display name is correct: " + java.toString().equals("Java"));
        System.out.println("C display name is correct: " + c.toString().equals("C"));
        System.out.println("JAVASCRIPT display name is correct: " + javascript.toString().equals("JavaScript"));
    }
}