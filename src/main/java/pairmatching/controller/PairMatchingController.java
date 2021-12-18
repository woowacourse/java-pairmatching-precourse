package pairmatching.controller;

import pairmatching.view.InputView;

public class PairMatchingController {
    public static void run() {
        String inputStart = InputView.startFunction();
        String programInformation = InputView.chooseWhat(inputStart);
        InputView.FindProgramList(programInformation);

    }
}
