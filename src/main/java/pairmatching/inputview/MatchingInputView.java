package pairmatching.inputview;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.vo.MatchingCommand;
import pairmatching.vo.RematchingCommand;

public class MatchingInputView extends AbstractInputView {
    public static MatchingCommand getCommand() {
        String input = readInput();
        String[] validatedInputArray = Validator.validate(input);

        Course course = Course.findByName(validatedInputArray[0]);
        Level level = Level.findByName(validatedInputArray[1]);
        String missionName = validatedInputArray[2];

        return MatchingCommand.of(course, level, missionName);
    }

    public static RematchingCommand getReMatchingCommand() {
        return RematchingCommand.findByCommand(readInput());
    }

    private static class Validator {

        public static final String NOT_VALID_LENGTH_MESSAGE = ",로 구분된 3개의 값이 아님";
        public static final int VALUE_AMOUNT = 3;
        public static final String COMMA = ",";
        public static final String SPACE = " ";
        public static final String BLANK = "";

        public static String[] validate(String target) {
            target = target.replaceAll(SPACE, BLANK);
            String[] splitedTarget = target.split(COMMA);
            hasValidSize(splitedTarget);

            return splitedTarget;
        }

        private static void hasValidSize(String[] splitedTarget) {
            if (splitedTarget.length != VALUE_AMOUNT) {
                throw new IllegalArgumentException(NOT_VALID_LENGTH_MESSAGE);
            }
        }
    }
}
