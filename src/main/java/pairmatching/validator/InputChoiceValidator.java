package pairmatching.validator;

import static pairmatching.constants.ErrorMessage.*;

import pairmatching.constants.ErrorMessage;

public class InputChoiceValidator {

    public static String validateInputChoice(String choice) {
        if (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("Q")) {
            throw new IllegalArgumentException(INPUT_CHOICE_ERROR.getMessage());
        }
        return choice;
    }
}
