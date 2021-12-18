package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.System.SystemErrorMessage;
import pairmatching.System.SystemInputMessage;
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
                outputSystem.printConsoleMessage(SystemInputMessage.SELECT_FUNCTION_INPUT.getMessage());
                functionNumber = Console.readLine();
                isValidInput = validation.isValidFunctionListInput(functionNumber);
            } catch (IllegalArgumentException e) {
                outputSystem.printConsoleMessage(SystemErrorMessage.NOT_VALID_INPUT.getMessage());
                isValidInput = false;
            }
        } while (!isValidInput);
        return functionNumber.charAt(0);
    }

    public String inputPropertyInput() {
        boolean isValidInput = false;
        String courseAndLevelAndMission = "";
        do {
            try {
                outputSystem.printConsoleMessage(combinateCustomPropertyMessage());
                courseAndLevelAndMission = Console.readLine();
                isValidInput = validation.isValidPropertySelectionInput(courseAndLevelAndMission);
            } catch (IllegalArgumentException e) {
                outputSystem.printConsoleMessage(SystemErrorMessage.NOT_VALID_INPUT.getMessage());
                isValidInput = false;
            }
        } while (!isValidInput);
        return courseAndLevelAndMission;
    }

    public String inputYesOrNo() {
        boolean isValidInput = false;
        String yesOrNoInput = "";
        do {
            try {
                outputSystem.printConsoleMessage(SystemInputMessage.RETRY_MATCHING.getMessage());
                yesOrNoInput = Console.readLine();
                isValidInput = validation.isValidYesOrNo(yesOrNoInput);
            } catch (IllegalArgumentException e) {
                outputSystem.printConsoleMessage(SystemErrorMessage.NOT_VALID_INPUT.getMessage());
                isValidInput = false;
            }
        } while (!isValidInput);
        return yesOrNoInput;
    }

    private static class LazyHolder {
        public static final InputSystem INSTANCE = new InputSystem();
    }

    private String combinateCustomPropertyMessage() {
        return "#############################################" + SystemInputMessage.SELECT_PROPERTY_INFORMATION.getMessage()
                + "#############################################" + SystemInputMessage.SELECT_PROPERTY_INPUT.getMessage();
    }
}
