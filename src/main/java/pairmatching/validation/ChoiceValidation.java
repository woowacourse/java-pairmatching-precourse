package pairmatching.validation;

import pairmatching.view.Constant;

public class ChoiceValidation {
    public static void validateChoice(String input) {
        isEmpty(input);
    }

    public static void isEmpty(String input) {
        if (input.length() == 0) {
            throw new IllegalArgumentException(Constant.ERROR_IS_EMPTY);
        }
    }

    public static void hasEmpty(String input) {
        if (input.contains(Constant.SPACE)) {
            throw new IllegalArgumentException(Constant.ERROR_HAS_EMPTY);
        }
    }
}
