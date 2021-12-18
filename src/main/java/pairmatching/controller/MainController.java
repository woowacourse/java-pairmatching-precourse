package pairmatching.controller;

import pairmatching.view.Input;
import pairmatching.view.Output;

public class MainController {

    public MainController() {
    }

    public void playGame() {
        Output.printFunctionSelection();
        String functionSelection = Input.inputFunctionSelection();

        Output.printMissionAndProcess();
        String inputProcess = Input.inputProcess();
    }
}
