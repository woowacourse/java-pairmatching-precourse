package pairmatching;

public class Validation {
    private final static String REGEX1 = "1";
    private final static String REGEX2 = "2";
    private final static String REGEX3 = "3";
    private final static String REGEXQ = "Q";

    public static int checkInputForm(String input) {
        if(input.equals(REGEX1) || input.equals(REGEX2) || input.equals(REGEX3) || input.equals(REGEXQ)) {
            return 0;
        }
        throw new IllegalArgumentException();
    }
}
