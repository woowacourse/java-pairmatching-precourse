package pairmatching.controller;

import pairmatching.domain.Course;
import pairmatching.domain.Crews;
import pairmatching.domain.PairStorage;
import pairmatching.domain.Pairs;
import pairmatching.view.InputView;

public class MatchingController {
	public static final int COURSE_INDEX = 0;
	public static final int LEVEL_INDEX = 1;
	public static final int MISSION_INDEX = 2;

	public void start() {
		InputController inputController = new InputController();
		PairStorage pairStorage = new PairStorage();
		String inputNum = inputController.scanSelectFunction();
		if (inputNum.equals("1")) {
			InputView.askCourseLevelMission();
			String[] eachInform = inputController.scanCourseLevelMission();
			System.out.println(eachInform[COURSE_INDEX]);
			System.out.println(eachInform[LEVEL_INDEX]);
			System.out.println(eachInform[MISSION_INDEX]);
			pairStorage.backEndLevel1 = shuffleCrew(eachInform[COURSE_INDEX]);
		}
		else if (inputNum.equals("2")) {
			InputView.askCourseLevelMission();
			inputController.scanCourseLevelMission();
		}
	}

	public Pairs shuffleCrew(String course) {
		Crews crews = new Crews();
		if (course.equals(Course.BACKEND.getName())) {
			return crews.shuffleBackEndCrew();
		}
		return crews.shuffleFrontEndCrew();
	}
}
