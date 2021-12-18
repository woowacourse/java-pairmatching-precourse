package pairmatching.utils;

public class Validator {

    private static final String INPUT_FUNCTION_REGEX = "^[1-3Q]$";
    private static final String INPUT_FUNCTION_ERROR_MESSAGE = "올바른 기능을 입력해 주세요.";

    public static void validateFunctionInput(final String input) {
        if (input.matches(INPUT_FUNCTION_REGEX)) {
            return;
        }
        throw new IllegalArgumentException(INPUT_FUNCTION_ERROR_MESSAGE);
    }
}
