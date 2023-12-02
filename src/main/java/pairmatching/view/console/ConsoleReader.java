package pairmatching.view.console;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.global.exception.CustomException;
import pairmatching.global.exception.ErrorMessage;

public final class ConsoleReader {
    public static String enterMessage() {
        return Validator.validate(Console.readLine());
    }

    private static class Validator {
        public static String validate(String message) {
            validateBlankInput(message);
            return message;
        }

        private static void validateBlankInput(String message) {
            if (message.length() == 0) {
                throw CustomException.from(ErrorMessage.BLANK_INPUT_ERROR);
            }
        }
    }
}
