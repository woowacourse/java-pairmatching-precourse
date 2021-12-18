package pairmatching.controller;

import pairmatching.domain.MainProgram;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MainProgramController {
    public void run() {
        MainProgram mainProgram = new MainProgram();
        mainMenu(mainProgram);
    }

    private void mainMenu(MainProgram mainProgram) {
        try {
            mainProgram.setOptionNumber(InputView.mainMenu());
        } catch (Exception e) {
            OutputView.printErrorMessage(e);
            mainMenu(mainProgram);
        }
    }
}
