package pairmatching.util.io;

import pairmatching.domain.Level;
import pairmatching.domain.course.Course;
import pairmatching.domain.mission.MissionName;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static pairmatching.util.error.ErrorType.*;

public class Validator {
    private static final int LENGTH = 1;
    private static final int ZERO = 0;
    private static final List<Character> START_CHOOSE_SET = Arrays.asList('1', '2', '3', 'Q');
    private static final String REGEX = "[가-힣]+, [가-힣1-5]+, [가-힣]";

    public static char isValidCharStart(String input) {
        if (input.length() != LENGTH) {
            throw new IllegalArgumentException(NOT_VALID_CHOOSEN.getMessage());
        }
        if (outOfStartChoose(input.charAt(ZERO))) {
            throw new IllegalArgumentException(NOT_VALID_CHOOSEN.getMessage());
        }

        return input.charAt(ZERO);
    }

    private static boolean outOfStartChoose(char c) {
        return !START_CHOOSE_SET.contains(c);
    }

    public static String[] isValidMissionChoosen(String input) {
/*        if (isNotValidRegex(input)) {
            throw new IllegalArgumentException(NOT_VALID_CHOOSEN.getMessage());
        }*/

        String[] splitInfo = input.split(",");

        validCourse(splitInfo[0]);
        validLevel(splitInfo[1].trim());
        validName(splitInfo[2].trim());

        return splitInfo;
    }

/*    private static boolean isNotValidRegex(String input) {
        return !Pattern.matches(REGEX, input);
    }*/

    private static void validCourse(String input) {
        if(Course.BACKEND.isNot(input) && Course.FRONTEND.isNot(input)) {
            throw new IllegalArgumentException(NOT_VALID_CHOOSEN.getMessage());
        }
    }

    private static void validLevel(String input) {
        if(Level.isNotValid(input)) {
            throw new IllegalArgumentException(NOT_VALID_CHOOSEN.getMessage());
        }
    }

    private static void validName(String input) {
        if(MissionName.isNotValid(input)) {
            throw new IllegalArgumentException(NOT_VALID_CHOOSEN.getMessage());
        }
    }

    public static String isValidAnswerRedo(String input) {
        if( !(input.equals("네") || input.equals("아니오")) ) {
            throw new IllegalArgumentException(NOT_VALID_CHOOSEN.getMessage());
        }
        return input;
    }
}
