package pairmatching.utils;

import java.util.Arrays;
import java.util.List;

public class Validate {
    private final static String ERROR_MESSAGE = "[ERROR]";

    public static String CheckMissionInfo(String input) {
        List<String> candidateNumAndQ = Arrays.asList(new String[]{"1", "2", "3", "Q"});
        if (!candidateNumAndQ.contains(input)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "보기에 있는 기능 선택만 할 수 있습니다.");
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
        if (input.charAt(0) == ' ') {
            throw new IllegalArgumentException(ERROR_FRONT_BLANK);
        }
    }

    public static void checkInfoCount(String[] input) {
        if (input.length != 3) {
            throw new IllegalArgumentException(ERROR_LESS_INFO);
        }
    }
}
