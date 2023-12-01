package pairmatching.validator;

import static pairmatching.constants.ErrorMessage.INPUT_RETRY_ERROR;
import static pairmatching.constants.ProgressConstants.NO_RETRY;
import static pairmatching.constants.ProgressConstants.RETRY;

public class InputRetryValidator {

    public static String validateInputRetry(String retry) {
        if (!retry.equals(RETRY.getConstName()) && !retry.equals(NO_RETRY.getConstName())) {
            throw new IllegalArgumentException(INPUT_RETRY_ERROR.getMessage());
        }
        return retry;
    }
}
