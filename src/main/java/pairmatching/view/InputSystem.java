package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.System.SystemErrorMessage;
import pairmatching.validation.Validation;
import pairmatching.validation.ValidationImplementation;

public class InputSystem {

    private final OutputSystem outputSystem;
    private final Validation validation;

    public InputSystem() {
        outputSystem = OutputSystem.getInstance();
        validation = ValidationImplementation.getInstance();
    }

    public static InputSystem getInstance() {
        return InputSystem.LazyHolder.INSTANCE;
    }

    public char inputFunctionList() {
        boolean isValidInput = false;
        String functionNumber = "";
        do {
            try {
                outputSystem.printConsoleMessage(SystemInputMessage.SELECT_FUNCTION.getMessage());
                functionNumber = Console.readLine();
                isValidInput = validation.isValidFunctionListInput(functionNumber);
            } catch (IllegalArgumentException e) {
                outputSystem.printConsoleMessage(SystemErrorMessage.NOT_VALID_INPUT.getMessage());
                isValidInput = false;
            }
        } while (!isValidInput);
        return functionNumber.charAt(0);
    }

    private static class LazyHolder {
        public static final InputSystem INSTANCE = new InputSystem();
    }
}
