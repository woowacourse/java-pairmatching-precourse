package pairmatching.utils;

public class Validator {

    private static final String INPUT_FUNCTION_REGEX = "^[1-3Q]$";
    private static final String MATCHING_INFO_REGEX = "\\s*(.+)\\s*,\\s*(.+)\\s*,\\s*(.+)\\s*";
    private static final String INPUT_FUNCTION_ERROR_MESSAGE = "올바른 기능을 입력해 주세요.";
    private static final String INVALID_MATCHING_INFO_ERROR_MESSAGE = "누락된 정보가 있습니다. 과정, 레벨, 미션을 모두 올바르게 입력해 주세요.";

    public static void validateFunctionInput(final String input) {
        if (input.matches(INPUT_FUNCTION_REGEX)) {
            return;
        }
        throw new IllegalArgumentException(INPUT_FUNCTION_ERROR_MESSAGE);
    }

    public static void validateMatchingInfo(final String input) {
        if (!input.matches(MATCHING_INFO_REGEX)) {
            throw new IllegalArgumentException(INVALID_MATCHING_INFO_ERROR_MESSAGE);
        }
    }
}
