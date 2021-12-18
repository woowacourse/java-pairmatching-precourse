package pairmatching;

public class Validation {
    private final static String REGEX1 = "[1-3]+";
    private final static String REGEX2 = "Q";

    public static void checkInputForm(String input) {
        if(!input.matches(REGEX1) || !input.equals(REGEX2)) {
            throw new IllegalArgumentException();
        }
    }
}
