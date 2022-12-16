package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.view.validator.Validator;

public class InputView {

    public String readCommand() {
        return readValidInputBy(Validator.COMMAND);
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
