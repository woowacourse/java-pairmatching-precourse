package pairmatching.controller.subController;

import pairmatching.domain.PairMatchingResult;
import pairmatching.domain.option.PairingOption;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController implements Controllable {

    private InputView inputView;
    private OutputView outputView;


    public PairMatchingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void process() {
        PairingOption pairingOption = inputView.readPairingOption();
        PairMatchingResult result = new PairMatchingResult(pairingOption);
    }
}
