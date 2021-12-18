package pairmatching.controller;

import java.util.List;

import pairmatching.model.information.CourseInformation;
import pairmatching.view.InputView;

public abstract class PairMatchingController {

    public static void run() {
        String selectFunction = InputView.inputPairMatchingFunction();
        CourseInformation courseInformation = new CourseInformation(InputView.inputCourseInformation());
        List<String> courseInformationList = courseInformation.createCourseInformationList();

    }
}
