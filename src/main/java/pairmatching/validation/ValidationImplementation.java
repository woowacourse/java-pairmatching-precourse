package pairmatching.validation;


import java.util.regex.Pattern;

public class ValidationImplementation implements Validation {

    private static final Pattern FUNCTION_SELECT_VALID_DIGIT_PATTERN = Pattern.compile("^[1-3]*$");
    private static final int FUNCTION_LIST_INPUT_LIMITED_LENGTH = 1;
    private static final char EXIT_NOTATION = 'Q';

    public boolean isValidFunctionListInput(String functionNumberInput) {
        if (functionNumberInput.length() != FUNCTION_LIST_INPUT_LIMITED_LENGTH) {
            throw new IllegalArgumentException();
        }
        if (isValidSignificantFigures(functionNumberInput) || isQuitNotation(functionNumberInput)) {
            return true;
        }
        throw new IllegalArgumentException();
    }

    private boolean isValidSignificantFigures(String functionNumberInput) {
        return FUNCTION_SELECT_VALID_DIGIT_PATTERN.matcher(functionNumberInput).matches();
    }

    public static ValidationImplementation getInstance() {
        return ValidationImplementation.LazyHolder.INSTANCE;
    }

    private static class LazyHolder {

        public static final ValidationImplementation INSTANCE = new ValidationImplementation();
    }

    private boolean isQuitNotation(String functionNumberInput) {
        return functionNumberInput.charAt(0) == EXIT_NOTATION;
    }

}
