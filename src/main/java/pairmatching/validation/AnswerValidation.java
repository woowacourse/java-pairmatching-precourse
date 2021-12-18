package pairmatching.validation;

import pairmatching.view.Constant;

public class AnswerValidation {
    public static void validationAnswer(String input) {
        if (!input.equals(Constant.YES) && !input.equals(Constant.NO)) {
            throw new IllegalArgumentException(Constant.ERROR_YES_OR_NO);
        }
    }
}
