package pairmatching;

import pairmatching.controller.MainController;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Application {
    public static void main(String[] args) {
        MainController mainController = new MainController(initInputView(),initOutputView());
        mainController.run();
    }

    private static InputView initInputView() {
        return new InputView();
    }

    private static OutputView initOutputView() {
        return new OutputView();
    }
}
