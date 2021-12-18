package pairmatching.utils;

import java.util.Arrays;
import java.util.List;

import static pairmatching.utils.Constants.BLANK;
import static pairmatching.utils.Constants.NUM_OF_ITEM;
import static pairmatching.utils.ExceptionMessage.*;

public class Validator {
    public static String checkAvailableSelect(String input) {
        List<String> candidate = Arrays.asList(new String[]{"1", "2", "3", "Q"});
        if (!candidate.contains(input)) {
            throw new IllegalArgumentException(ERROR_INVALID_SELECT);
        }
        return input;
    }

    public static void checkEachInfo(String input) {
        checkEmptyValue(input);
        checkFrontBlank(input);
    }

    private static void checkEmptyValue(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_INPUT);
        }
    }

    private static void checkFrontBlank(String input) {
        if (input.charAt(0) == BLANK) {
            throw new IllegalArgumentException(ERROR_FRONT_BLANK);
        }
    }

    public static void checkInfoCount(String[] input) {
        if (input.length != NUM_OF_ITEM) {
            throw new IllegalArgumentException(ERROR_LESS_INFO);
        }
    }

    public static String checkRematchAnswer(String input) {
        List<String> candidate = Arrays.asList(new String[]{"네", "아니요"});
        if (!candidate.contains(input)) {
            throw new IllegalArgumentException(ERROR_INVALID_SELECT);
        }
        return input;
    }
}
