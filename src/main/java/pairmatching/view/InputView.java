package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.view.validatetool.ValidateTool;

public class InputView {

    public String readCommand() {
        return readUsing(ValidateTool.COMMAND);
    }

    public String readChoice() {
        return readUsing(ValidateTool.CHOICE);
    }

    private String readUsing(ValidateTool validateTool) {
        String input = Console.readLine();
        validateBy(input, validateTool);
        return input;
    }

    private void validateBy(String input, ValidateTool validateTool) {
        if (isInvalidFormat(input, validateTool)) {
            throw new IllegalArgumentException(validateTool.getErrorMessage());
        }
    }

    private boolean isInvalidFormat(String input, ValidateTool validateTool) {
        return !input.matches(validateTool.getValidFormat());
    }
}
