package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.utils.Validator;

import static pairmatching.utils.InputConstants.OPTIONS;

public class InputView {
    private final static Validator validator = new Validator();

    public static String selectOption() {
        try {
            System.out.println(OPTIONS);
            String input = Console.readLine();
            validator.isValidOption(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return selectOption();
        }
    }
}
