package pairmatching.controller;

import pairmatching.view.Input;
import pairmatching.view.Output;

public class MainController {

    public MainController() {
    }

    public void playGame() {
        Output.printFunctionSelection();
        String FunctionSelection = Input.inputFunctionSelection();
        Output.printMissionAndProcess();
    }
}
