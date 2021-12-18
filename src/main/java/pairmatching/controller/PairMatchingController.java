package pairmatching.controller;

import java.util.List;

import pairmatching.view.InputView;

public abstract class PairMatchingController {

    public static void run() {
        String selectFunction = InputView.inputPairMatchingFunction();

        List<String> frontendCrewNames = InputView.readFrontendCrew();
        List<String> backendCrewNames = InputView.readBackendCrew();
        String[] selectCourseInformation = InputView.inputCourseInformation();

    }

}
