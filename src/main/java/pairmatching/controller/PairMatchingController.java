package pairmatching.controller;

import pairmatching.domain.command.MainCommand;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {

    public void run() {
        MainCommand mainCommand = getMainCommand();
        if (mainCommand == MainCommand.EXIT) {
            return;
        }
    }

    private MainCommand getMainCommand() {
        try {
            return InputView.mainCommand();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getMainCommand();
        }
    }
}