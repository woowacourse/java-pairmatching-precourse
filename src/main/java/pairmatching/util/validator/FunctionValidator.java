package pairmatching.util.validator;

import pairmatching.util.InputSign;
import pairmatching.view.message.ErrorMessage;

public class FunctionValidator implements InputValidator {
    private static final FunctionValidator instance = new FunctionValidator();

    private FunctionValidator() {
    }

    public static FunctionValidator getInstance() {
        return instance;
    }

    @Override
    public void validate(String input) {
        validateFunctionSign(input);
    }

    private void validateFunctionSign(String input) {
        if (!input.matches("[" + InputSign.SIGN_MATCH + InputSign.SIGN_VIEW + InputSign.SIGN_RESET + InputSign.SIGN_QUIT + "]")) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_FUNCTION_INPUT_SIGN.getMessage());
        }
    }
}
