package view;

import static messages.IOMessages.INPUT_FUNCTION;

import domain.dto.FunctionMapper;
import domain.entity.Function;
import util.InputUtil;

public class InputView {

    public Function inputFunction() {
        System.out.println(INPUT_FUNCTION.getMessage());
        String input = InputUtil.input();

        return FunctionMapper.toFunction(input);
    }
}
