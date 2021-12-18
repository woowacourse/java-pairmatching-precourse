package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_MESSAGE_CHOOSE_FUNCTION = "기능을 선택하세요.";

    public String inputPairMatchingFunction() {
        System.out.println(INPUT_MESSAGE_CHOOSE_FUNCTION);
        String inputFunctionSignal = inputValue();

        return inputFunctionSignal;
    }

    public String inputValue() {
        return Console.readLine();
    }

}
