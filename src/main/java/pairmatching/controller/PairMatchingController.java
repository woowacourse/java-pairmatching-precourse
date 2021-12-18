package pairmatching.controller;

import java.util.List;

import pairmatching.Util.FileUtils;
import pairmatching.model.Course;
import pairmatching.model.CourseLevelMission;
import pairmatching.model.Crew;
import pairmatching.model.Role;
import pairmatching.service.MatchingService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {
	InputView inputView = new InputView();
	OutputView outputView = new OutputView();
	private static final List<Crew> backendCrews = FileUtils.read("src/main/resources/backend-crew.md", Course.BACKEND);
	private static final List<Crew> frontendCrews = FileUtils.read("src/main/resources/frontend-crew.md", Course.FRONTEND);

	public void run() {
		String roleNumber = inputView.enterRoleNumber();

		Role.parse(roleNumber).role();

		// TODO 매칭 기록 체크


	}

	public static void match() {
		InputView inputView = new InputView();
		OutputView outputView = new OutputView();
		MatchingService matchingService = new MatchingService();
		outputView.printCourseAndMission();
		String courseLevelMissionStr = inputView.enterCourseLevelMission();
		CourseLevelMission courseLevelMission = new CourseLevelMission();
		courseLevelMission.init(courseLevelMissionStr);
		matchingService.match(courseLevelMission, backendCrews, frontendCrews);
	}

	public void inquire() {

	}

	public void initialize() {

	}

	public void finish() {

	}
}
