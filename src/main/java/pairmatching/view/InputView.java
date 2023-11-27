package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.pair.PairOption;
import pairmatching.message.ExceptionMessage;
import pairmatching.message.ViewMessage;

public class InputView {
    public static String readMenu() {
        System.out.println(ViewMessage.INPUT_MENU_MESSAGE);
        String input = readString();
        return input;
    }

    private static String readString() {
        String input = Console.readLine().trim();
        validateBlank(input);
        return input;
    }

    private static void validateBlank(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT);
        }
    }

    public static String readRematch() {
        System.out.println(ViewMessage.INPUT_REMATCH_MESSAGE);
        return readString();
    }

    public static PairOption readOption() {
        System.out.println(ViewMessage.INPUT_OPTION_PRE_MESSAGE);
        System.out.println(ViewMessage.INPUT_OPTION_MESSAGE);
        String input = readString();
        return PairOption.createByString(input);
    }
}
