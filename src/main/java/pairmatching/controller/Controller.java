package pairmatching.controller;

import pairmatching.utils.Validator;
import pairmatching.view.ConsoleInputView;
import pairmatching.view.OutputView;

public class Controller {

    public static void execute() {
        //TODO
    }

    private static String getInputFunction() {
        String inputFunction;
        try {
            inputFunction = ConsoleInputView.inputFunction();
            Validator.validateFunctionInput(inputFunction);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            inputFunction = getInputFunction();
        }
        return inputFunction;
    }

}
