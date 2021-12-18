package pairmatching.controller;

import java.util.List;

import pairmatching.model.Shuffler;
import pairmatching.model.information.CourseInformation;
import pairmatching.view.InputView;

public abstract class PairMatchingController {

    public static void run() {
        String selectFunction = InputView.inputPairMatchingFunction();
        CourseInformation courseInformation = new CourseInformation(InputView.inputCourseInformation());
        List<String> courseInformationList = courseInformation.createCourseInformationList();
        List<String> crewNames = InputView.readCrewNames(courseInformationList);

        Shuffler shuffler = new Shuffler(crewNames);
        List<String> shuffledCrew = shuffler.shuffleCrewNames();
    }
}
