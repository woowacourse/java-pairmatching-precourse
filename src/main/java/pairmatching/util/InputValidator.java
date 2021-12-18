package pairmatching.util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static pairmatching.util.Constants.*;

public class InputValidator {

    public void functions(String userInput) {
        boolean regex = Pattern.matches(FUNCTION_PATTERN, userInput);
        if (!regex) {
            throw new IllegalArgumentException(WRONG_FUNCTION_PATTERN);
        }
    }

    public void CLM(String userInput) {
        String tmp1 = userInput.replace(" ", "");
        List<String> tmp2 = Arrays.asList(tmp1.split(","));
        try {
            String course = tmp2.get(0);
            String level = tmp2.get(1);
            String mission = tmp2.get(2);
            if (!COURSES.contains(course) | !LEVELS.contains(level) | !MISSIONS.get(level).contains(mission)) {
                throw new IllegalArgumentException(WRONG_CLM_PATTERN);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
                throw new IllegalArgumentException(WRONG_CLM_PATTERN);
            }
    }
}
