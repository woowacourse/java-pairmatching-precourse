package pairmatching;

import pairmatching.controller.PairMatchingController;
import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.service.CrewService;
import pairmatching.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
		CrewService crewService = new CrewService();
		PairMatchingController pairMatchingController = new PairMatchingController();
		OutputView.printCourseLevelMission(Course.values(), Level.values());
		pairMatchingController.pairMatching();
    }
}
