package pairmatching.controller;

import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Controller {

    public void getUserChoice() {
        String userChoice = InputView.getUserChoice();
    }

    public void choicePairMatching() {
        OutputView.printProcess();
    }
}
