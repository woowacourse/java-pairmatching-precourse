package pairmatching.controller;

import java.util.HashMap;

import pairmatching.domain.Course;
import pairmatching.domain.Crews;
import pairmatching.domain.Level;
import pairmatching.domain.PairStorage;
import pairmatching.domain.Pairs;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

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
			HashMap<String, Pairs> missionPair = new HashMap<>();
			Pairs pairs = shuffleCrew(eachInform[COURSE_INDEX]);
			missionPair.put(eachInform[MISSION_INDEX], pairs);
			pairStorage.backEndPair.put(Level.getLevelByName(eachInform[LEVEL_INDEX]), missionPair);
			OutputView.printPairResult(pairs);
		} else if (inputNum.equals("2")) {
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
