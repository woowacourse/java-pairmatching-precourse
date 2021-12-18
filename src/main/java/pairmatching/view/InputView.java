package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.model.enums.Option;
import pairmatching.utils.Validator;

import static pairmatching.model.enums.Option.findNameByValue;
import static pairmatching.utils.constants.InputConstants.*;

public class InputView {
    private final static Validator validator = new Validator();

    public static Option selectOption() {
        try {
            System.out.println(OPTIONS);
            String input = Console.readLine();
            validator.checkValidOption(input);
            return findNameByValue(input);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return selectOption();
        }
    }

    public static String inputDetails() {
        try {
            System.out.println(PRECOURSE_AND_MISSIONS);
            String input = Console.readLine();
            validator.checkValidDetails(input);
            return input;

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputDetails();
        }
    }

    public static String inputReMatch() {
        try {
            System.out.println(RE_MATCHING);
            String input = Console.readLine();
            validator.checkReMatch(input);
            return input;

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputReMatch();
        }
    }
}
