package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.view.validator.Validator;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String CHOICE_DELIMITER = ", ";
    private final String RE_MATCHING_COMMAND = "네";

    public String readCommand() {
        return readValidInputBy(Validator.COMMAND);
    }

    public List<String> readChoices() {
        String input = readValidInputBy(Validator.CHOICE);
        return Arrays.asList(input.split(CHOICE_DELIMITER));
    }

    public boolean isReMatching() {
        String input = readValidInputBy(Validator.RE_MATCHING);
        return convertReMatchingCommandToBoolean(input);
    }

    private boolean convertReMatchingCommandToBoolean(String input) {
        return input.equals(RE_MATCHING_COMMAND);
    }

    private String readValidInputBy(Validator validator) {
        String input = Console.readLine();
        validateBy(input, validator);
        return input;
    }

    private void validateBy(String input, Validator validator) {
        validator.validate(input);
    }
}
