package pairmatching.validation;

import pairmatching.view.Constant;

public class ChoiceValidation {
    public static void validateChoice(String input) {
        isEmpty(input);
        hasEmpty(input);
        isNotRight(input);
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

    public static void isNotRight(String input) {
        if (!input.equals(Constant.ONE) && !input.equals(Constant.TWO)
                && !input.equals(Constant.THREE) && !input.equals(Constant.Q)) {
            throw new IllegalArgumentException(Constant.ERROR_IS_NOT_RIGHT);
        }
    }
}
