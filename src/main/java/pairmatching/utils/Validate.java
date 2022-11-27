package pairmatching.utils;

import java.util.Arrays;
import java.util.List;

public class Validate {
    private final static String ERROR_MESSAGE = "[ERROR]";

    public static String validateCheckNumber(String input) {
        List<String> candidateNumAndQ = Arrays.asList(new String[]{"1", "2", "3", "Q"});
        if (!candidateNumAndQ.contains(input)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "보기에 있는 기능 선택만 할 수 있습니다.");
        }
        return input;
    }
}
