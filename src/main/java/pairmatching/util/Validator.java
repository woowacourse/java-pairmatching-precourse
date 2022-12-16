package pairmatching.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static pairmatching.util.Constants.*;

public class Validator {
    private final static String ERROR_PREFIX = "[ERROR] ";

    public void validateSelectFunctionValue(String func) {
        List<String> functions = Arrays.asList(FUNC_MATCH, FUNC_SHOW, FUNC_RESET, FUNC_QUIT);
        if(!functions.contains(func)) {
            throw new IllegalArgumentException(ERROR_PREFIX + "존재하지 않는 기능입니다.");
        }
    }
}
