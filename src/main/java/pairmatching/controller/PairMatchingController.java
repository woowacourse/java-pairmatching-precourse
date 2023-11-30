package pairmatching.controller;

import static pairmatching.util.FileIO.backendCrewNamesFromFile;
import static pairmatching.view.input.InputView.inputChooseProcess;
import static pairmatching.view.ouput.OutputView.displayProcessOfPair;

import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.Crew;
import pairmatching.domain.constant.Course;
import pairmatching.domain.constant.Level;
public class PairMatchingController {

    private PairMatchingController() {
    }

    public static void pairMatching() {
        displayProcessOfPair();
        List<String> processInfo = inputChooseProcess();
    }


}