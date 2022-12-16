package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.util.Validator;

public class InputView {
    private final OutputView outputView = new OutputView();
    private final Validator validator = new Validator();

    public String readFunction() {
        outputView.printFunctionSelectMessage();
        String func = Console.readLine();
        validator.validateSelectFunctionValue(func);

        return func;
    }
}
