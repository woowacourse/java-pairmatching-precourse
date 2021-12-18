package pairmatching.controller;

import pairmatching.domain.mainProgram.MainProgram;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MainProgramController {
    final String OPTION_ONE = "1";

    public void run() {
        MainProgram mainProgram = new MainProgram();
        mainMenu(mainProgram);
        runSelectedFunction(mainProgram);
    }

    private void mainMenu(MainProgram mainProgram) {
        try {
            mainProgram.setOptionNumber(InputView.mainMenu());
        } catch (Exception e) {
            OutputView.printErrorMessage(e);
            mainMenu(mainProgram);
        }
    }

    public void runSelectedFunction(MainProgram mainProgram) {
        if (mainProgram.getOptionNumber().equals(OPTION_ONE)) {
            getCourse(mainProgram);
            return;
        }
    }

    private void getCourse(MainProgram mainProgram) {
        try {
            OutputView.selectMission();
            mainProgram.match(InputView.selectMission());
        } catch (Exception e) {
            OutputView.printErrorMessage(e);
            getCourse(mainProgram);
        }
    }
}
