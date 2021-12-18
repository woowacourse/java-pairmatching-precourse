package pairmatching.controller;

import pairmatching.domain.Pairmatching;
import pairmatching.view.Input;
import pairmatching.view.Output;

import java.util.Arrays;

public class MainController {
    Pairmatching pairmatching;

    public MainController() {
        pairmatching = new Pairmatching();
    }

    public void playGame() {
//        Output.printFunctionSelection();
//        String functionSelection = Input.inputFunctionSelection();
//
//        Output.printMissionAndProcess();
//        String inputProcess = Input.inputProcess();

        CrewInformationController.readCrews(pairmatching);
        System.out.println(pairmatching.getCrewBackendNames());
        System.out.println(pairmatching.getCrewFrontendNames());
    }
}
