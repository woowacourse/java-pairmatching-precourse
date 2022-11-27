package pairmatching;

import pairmatching.controller.MainController;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Application {
    private static final InputView inputview = new InputView();
    private static final OutputView outputview = new OutputView();
    private static final MainController mainController = new MainController();
    public static void main(String[] args) {
        // TODO 구현 진행
        mainController.run();
    }
}
