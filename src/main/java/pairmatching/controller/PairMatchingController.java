package pairmatching.controller;

import java.util.List;

import pairmatching.Util.FileUtils;
import pairmatching.model.Course;
import pairmatching.model.CourseLevelMission;
import pairmatching.model.Crew;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {
	InputView inputView = new InputView();
	OutputView outputView = new OutputView();

	public void run() {
		inputView.enterRoleNumber();
		outputView.printCourseAndMission();
		String courseLevelMissionStr = inputView.enterCourseLevelMission();
		CourseLevelMission courseLevelMission = new CourseLevelMission();
		courseLevelMission.init(courseLevelMissionStr);

		// TODO 매칭 기록 체크
		List<Crew> backendCrews = FileUtils.read("src/main/resources/backend-crew.md", Course.BACKEND);
		List<Crew> frontendCrews = FileUtils.read("src/main/resources/frontend-crew.md", Course.FRONTEND);




	}
}
