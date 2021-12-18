package pairmatching.utils;

public class Validator {
    private final static String MATCH_PAIR = "1";
    private final static String SELECT_PAIR = "2";
    private final static String INITIAL_PAIR = "3";
    private final static String QUIT = "Q";
    private final static String ERROR_INPUT_OPTION = "[ERROR] 잘못된 번호를 선택하셨습니다.";

    public Validator() {
    }

    public boolean isValidOption(String input) {
        if (MATCH_PAIR.equals(input)
                || SELECT_PAIR.equals(input)
                || INITIAL_PAIR.equals(input)
                || QUIT.equalsIgnoreCase(input)) {
            return true;
        }
        throw new IllegalArgumentException(ERROR_INPUT_OPTION);
    }

}
