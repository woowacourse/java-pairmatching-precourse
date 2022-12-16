package pairmatching;

import pairmatching.controller.PairController;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Application {
    public static void main(String[] args) {
        PairController pairController = new PairController(new InputView(), new OutputView());
        pairController.run();
    }
}
