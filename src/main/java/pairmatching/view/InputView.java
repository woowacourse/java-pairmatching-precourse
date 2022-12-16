package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.view.validator.Validator;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String CHOICE_DELIMITER = ", ";

    public String readCommand() {
        return readValidInputBy(Validator.COMMAND);
    }

    public List<String> readChoices() {
        String input = readValidInputBy(Validator.CHOICE);
        return Arrays.asList(input.split(CHOICE_DELIMITER));
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
