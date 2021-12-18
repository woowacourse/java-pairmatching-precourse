package pairmatching.controller;

import java.util.List;

import pairmatching.model.information.CourseInformation;
import pairmatching.view.InputView;

public abstract class PairMatchingController {

    private static final int COURSE_INDEX = 0;

    public static void run() {
        String selectFunction = InputView.inputPairMatchingFunction();
        String[] selectCourseInformation = InputView.inputCourseInformation();

        List<String> courseInformation = (new CourseInformation(selectCourseInformation).removeTrim());
//        List<String> crewNames = InputView.readBackendCrew(courseInformation.get(COURSE_INDEX));

    }
}
