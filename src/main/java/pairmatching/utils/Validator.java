package pairmatching.utils;

import static pairmatching.model.enums.Option.*;

public class Validator {
    private final static String ERROR_INPUT_OPTION = "[ERROR] 잘못된 번호를 선택하셨습니다.";

    public Validator() {
    }

    public boolean isValidOption(String input) {
        if (MATCH_PAIR.getValue().equals(input)
                || SELECT_PAIR.getValue().equals(input)
                || INITIAL_PAIR.getValue().equals(input)
                || QUIT.getValue().equalsIgnoreCase(input)) {
            return true;
        }
        throw new IllegalArgumentException(ERROR_INPUT_OPTION);
    }

}
