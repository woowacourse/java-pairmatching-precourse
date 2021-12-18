package pairmatching.controller;

import java.util.List;

import pairmatching.Util.FileUtils;
import pairmatching.model.Course;
import pairmatching.model.CourseLevelMission;
import pairmatching.model.Crew;
import pairmatching.model.Mission;
import pairmatching.model.Role;
import pairmatching.service.InitializingService;
import pairmatching.service.InquiringService;
import pairmatching.service.MatchingService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {
	private static final InputView inputView = new InputView();
	private static final OutputView outputView = new OutputView();
	private static final List<Crew> backendCrews = FileUtils.read("src/main/resources/backend-crew.md", Course.BACKEND);
	private static final List<Crew> frontendCrews = FileUtils.read("src/main/resources/frontend-crew.md",
		Course.FRONTEND);

	public void run() {
		String roleNumber = inputView.enterRoleNumber();

		while (!roleNumber.equals("Q")) {
			Role.parse(roleNumber).role();
			roleNumber = inputView.enterRoleNumber();
		}

		// TODO 매칭 기록 체크

	}

	public static void match() {
		MatchingService matchingService = new MatchingService();

		outputView.printCourseAndMission();
		String courseLevelMissionStr = inputView.enterCourseLevelMission();
		CourseLevelMission courseLevelMission = new CourseLevelMission();
		try {
			courseLevelMission.init(courseLevelMissionStr);
			outputView.printPair(
				matchingService.match(courseLevelMission, backendCrews, frontendCrews).getMatchingPairs().toString());
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
		}
	}

	public static void inquire() {
		InquiringService inquiringService = new InquiringService();

		String courseLevelMissionStr = inputView.enterCourseLevelMission();
		CourseLevelMission courseLevelMission = new CourseLevelMission();
		try {
			courseLevelMission.init(courseLevelMissionStr);
			outputView.printPair(inquiringService.inquire(courseLevelMission));
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
		}

		//TODO pair 가 없는 경우
	}

	public static void initialize() {
		InitializingService initializingService = new InitializingService();
		initializingService.initialize();
		outputView.printInitialize();
	}
}
