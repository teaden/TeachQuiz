/***************************************
 * Category.java
 * Represents a category or topic for a quiz question
 * @author Tyler Eaden
 * @version 1.0
 ****************************************/

/* Citation referenced for Enum definition:
https://coderanch.com/t/469226/java/Java-enums-space-display-values */
public enum Category {
    FUNDAMENTALS("Fundamentals"),
    JAVA("Java"),
    C("C"),
    JAVASCRIPT("JavaScript");

    private final String display;

    Category(final String display) {
        this.display = display;
    }

    public String toString() {
        return this.display;
    }
}