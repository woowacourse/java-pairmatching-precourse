package pairmatching.controller.subController;

import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController implements Controllable{

    private InputView inputView;
    private OutputView outputView;


    public PairMatchingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void process() {
        
    }
}
