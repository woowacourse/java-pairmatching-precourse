package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

import pairmatching.util.validator.FunctionValidator;
import pairmatching.util.validator.InputValidator;
import pairmatching.view.message.ViewMessage;

public class PairMatchingInputView {
    private InputValidator inputValidator;

    public String inputSelectFunction() {
        inputValidator = FunctionValidator.getInstance();

        while (true) {
            try {
                System.out.println(ViewMessage.INPUT_SELECT_FUNCTION.getMessage());
                String input = readLine();
                inputValidator.validate(input);

                return input;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private String readLine() {
        return Console.readLine();
    }
}
