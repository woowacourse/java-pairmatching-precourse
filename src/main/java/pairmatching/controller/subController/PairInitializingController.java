package pairmatching.controller.subController;

import pairmatching.domain.repository.PairMatchingResults;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairInitializingController implements Controllable {

    private final InputView inputView;
    private final OutputView outputView;

    public PairInitializingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void process() {
        PairMatchingResults.deleteAll();
    }
}
