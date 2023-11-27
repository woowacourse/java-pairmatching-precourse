package pairmatching.controller;

import static pairmatching.messages.ErrorMessages.INVALID_FUNCTION;

import pairmatching.domain.entity.Function;
import pairmatching.util.InputUtil;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingController {

    private final InputView inputView;
    private final OutputView outputView;

    public MatchingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        final Function function = inputValidFunction();
    }

    private Function inputValidFunction() {
        return InputUtil.retryOnInvalidInput(this::inputFunction,
                errorMessage -> outputView.outputErrorMessage(errorMessage));
    }

    private Function inputFunction() {
        return inputView.inputFunction();
    }


}
