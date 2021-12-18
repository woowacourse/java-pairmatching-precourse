package pairmatching.validation;

import pairmatching.view.Constant;

public class CategoryValidation {
    public static void validateCategory(String input) {
        isEmpty(input);
        isContains(input);
    }

    public static void isEmpty(String input) {
        if (input.length() == 0) {
            throw new IllegalArgumentException(Constant.ERROR_IS_EMPTY);
        }
    }

    public static void isContains(String input) {
        if (!input.contains(Constant.INPUT_DELIMITER)) {
            throw new IllegalArgumentException(Constant.ERROR_IS_NO_DELIMITER);
        }
    }
}
