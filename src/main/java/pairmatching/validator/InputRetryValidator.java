package pairmatching.validator;

import static pairmatching.constants.ErrorMessage.INPUT_RETRY_ERROR;

public class InputRetryValidator {

    public static String validateInputRetry(String retry) {
        if (!retry.equals("예") && !retry.equals("아니오")) {
            throw new IllegalArgumentException(INPUT_RETRY_ERROR.getMessage());
        }
        return retry;
    }
}
