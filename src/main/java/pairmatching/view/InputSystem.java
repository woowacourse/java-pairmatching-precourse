package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.Configuration.DependencyInjection;
import pairmatching.message.SystemErrorMessage;
import pairmatching.message.SystemInputMessage;
import pairmatching.validation.Validation;

public class InputSystem {

    private final OutputSystem outputSystem;
    private final Validation validation;
    private InputSystem() {
        DependencyInjection dependencyInjection = new DependencyInjection();
        outputSystem = dependencyInjection.outputSystem();
        validation = dependencyInjection.validation();
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
        return "\n#############################################\n" + SystemInputMessage.SELECT_PROPERTY_INFORMATION.getMessage()
                + "#############################################" + SystemInputMessage.SELECT_PROPERTY_INPUT.getMessage();
    }
}
