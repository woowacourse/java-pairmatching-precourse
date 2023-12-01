package pairmatching.validator;

import static pairmatching.constants.ErrorMessage.INPUT_CHOICE_ERROR;
import static pairmatching.constants.ProgressConstants.PAIR_MATCHING;
import static pairmatching.constants.ProgressConstants.PAIR_RESET;
import static pairmatching.constants.ProgressConstants.PAIR_SEARCH;
import static pairmatching.constants.ProgressConstants.QUIT;

public class InputChoiceValidator {

    public static String validateInputChoice(String choice) {
        if (!choice.equals(PAIR_MATCHING.getConstName()) && !choice.equals(PAIR_SEARCH.getConstName()) && !choice.equals(
                PAIR_RESET.getConstName()) && !choice.equals(QUIT.getConstName())) {
            throw new IllegalArgumentException(INPUT_CHOICE_ERROR.getMessage());
        }
        return choice;
    }
}
