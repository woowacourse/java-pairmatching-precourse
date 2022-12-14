package pairmatching.controller;

import pairmatching.domain.program.command.Command;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {

    private final InputView inputView;
    private final OutputView outputView;

    public PairMatchingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void runPairMatchingProgram() {
        outputView.printCommandGuideMessage(Command.values());
        inputView.readCommand();
    }
}
