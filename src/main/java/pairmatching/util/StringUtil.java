package pairmatching.util;

import static pairmatching.Constant.*;

public class StringUtil {
    public static String[] splitUsingComma(String input) {
        return input.split(DELEMETER_USING_COMMA, -1);
    }
}
