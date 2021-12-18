package pairmatching;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.service.CrewService;
import pairmatching.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
		CrewService crewService = new CrewService();
		System.out.println(crewService.getBackendCrew());
		System.out.println(crewService.getFrontendCrew());
		OutputView.printCourseLevelMission(Course.values(), Level.values());
    }
}
