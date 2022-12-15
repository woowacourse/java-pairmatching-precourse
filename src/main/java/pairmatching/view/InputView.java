package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.view.validatetool.ValidateTool;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String DELIMITER = ", ";

    public String readCommand() {
        return readUsing(ValidateTool.COMMAND);
    }

    public List<String> readChoice() {
        String input = readUsing(ValidateTool.CHOICE);
        return Arrays.asList(input.split(DELIMITER));
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
