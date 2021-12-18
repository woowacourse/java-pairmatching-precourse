package pairmatching.controller;


import java.util.List;

import pairmatching.view.InputView;

public abstract class PairMatchingController {

    public static void run() {
        String selectFunction = InputView.inputPairMatchingFunction();
        String[] courseInformation = InputView.inputCourseInformation();
        List<String> FrontendCrewNames = InputView.readFrontendCrew();
    }

}
