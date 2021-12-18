package pairmatching.controller;

import java.util.List;

import pairmatching.view.InputView;

public abstract class PairMatchingController {

    public static void run() {
        String selectFunction = InputView.inputPairMatchingFunction();

        List<String> FrontendCrewNames = InputView.readFrontendCrew();
        List<String> BackendCrewNames = InputView.readBackendCrew();
        String[] selectCourseInformation = InputView.inputCourseInformation();

        for (int i = 0; i < selectCourseInformation.length; i++) {
            System.out.println(selectCourseInformation[i]);
        }
    }

}
