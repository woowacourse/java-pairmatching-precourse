package pairmatching;

import pairmatching.controller.PairMatchingController;
import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
		PairMatchingController pairMatchingController = new PairMatchingController();
		OutputView.printCourseLevelMission(Course.values(), Level.values());
		pairMatchingController.pairMatching();
    }
}
