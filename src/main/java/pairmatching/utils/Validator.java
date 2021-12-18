package pairmatching.utils;

import java.util.Arrays;
import java.util.List;

import static pairmatching.utils.ExceptionMessage.ERROR_INVALID_SELECT;

public class Validator {
    public static String checkAvailableSelect(String input) {
        List<String> candidate = Arrays.asList(new String[]{"1", "2", "3", "Q"});
        if (!candidate.contains(input)) {
            throw new IllegalArgumentException(ERROR_INVALID_SELECT);
        }
        return input;
    }
}
