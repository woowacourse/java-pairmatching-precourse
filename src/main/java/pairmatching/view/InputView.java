package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.model.ProgramFunction;

public class InputView {
    private static final String ERROR_MESSAGE_NOT_CONTAINS_IN_FUNCTION_LIST = "[ERROR] 기능목록에 있는 기능을 선택해 주세요.";

    public String inputPairMatchingFunction() {
        try {

            String inputFunctionSignal = inputValue();
            validateInputFunctionSignal(inputFunctionSignal);

            return inputFunctionSignal;
        }catch (IllegalArgumentException illegalArgumentException){
            System.out.println(illegalArgumentException.getMessage());

            return inputPairMatchingFunction();
        }
    }

    private void validateInputFunctionSignal(final String inputFunctionSignal) {
        boolean isInputFunctionSignal = true;

        for (ProgramFunction programFunction:ProgramFunction.values()) {
            if (programFunction.getSignal().contains(inputFunctionSignal)) {
                isInputFunctionSignal = false;
                break;
            }
        }

        if(isInputFunctionSignal){
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_CONTAINS_IN_FUNCTION_LIST);
        }
    }

    public String inputValue() {
        return Console.readLine();
    }

}
