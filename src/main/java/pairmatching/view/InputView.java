package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.model.ProgramFunction;

public class InputView {

    private static final String INPUT_MESSAGE_CHOOSE_FUNCTION = "기능을 선택하세요.";
    private static final String NEW_LINE = "\n";
    private static final String ERROR_MESSAGE_NOT_CONTAINS_IN_FUNCTION_LIST = "[ERROR] 기능목록에 있는 기능을 선택해 주세요.";

    public String inputPairMatchingFunction() {
        try {
            String inputFunctionSignal = inputValue();
            String printFormatProvidingFunction = createProvidingFunctionPrintFormat();

            validateInputFunctionSignal(inputFunctionSignal);


            return inputFunctionSignal;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());

            return inputPairMatchingFunction();
        }
    }

    private String createProvidingFunctionPrintFormat() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(INPUT_MESSAGE_CHOOSE_FUNCTION + NEW_LINE);

        for (ProgramFunction programFunction : ProgramFunction.values()) {
            stringBuilder.append(programFunction.getSignal()).append(NEW_LINE);
        }

        return stringBuilder.toString();
    }

    private void validateInputFunctionSignal(final String inputFunctionSignal) {
        boolean isInputFunctionSignal = true;

        for (ProgramFunction programFunction : ProgramFunction.values()) {
            if (programFunction.getSignal().contains(inputFunctionSignal)) {
                isInputFunctionSignal = false;
                break;
            }
        }

        if (isInputFunctionSignal) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_CONTAINS_IN_FUNCTION_LIST);
        }
    }

    public String inputValue() {
        return Console.readLine();
    }

}
