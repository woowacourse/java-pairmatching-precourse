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
		while (true) {
			String inputNum = inputController.scanSelectFunction();
			if (inputNum.equals("1")) {
				matchPair(pairStorage, inputController);
			} else if (inputNum.equals("2")) {
				lookUpPair(pairStorage, inputController);
			} else if (inputNum.equals("3")) {
				pairStorage.initPairStorage();
				OutputView.printInit();
			} else if (inputNum.equals("Q")) {
				break;
			}
		}
	}

	public void matchPair(PairStorage pairStorage, InputController inputController) {
		String[] eachInform = inputController.scanCourseLevelMission();
		HashMap<String, Pairs> missionPair = new HashMap<>();
		Pairs pairs = shuffleCrew(eachInform[COURSE_INDEX]);
		missionPair.put(eachInform[MISSION_INDEX], pairs);
		if (eachInform[COURSE_INDEX].equals(Course.BACKEND.getName())) {
			pairStorage.backEndPair.put(Level.getLevelByName(eachInform[LEVEL_INDEX]), missionPair);
		}
		if (eachInform[COURSE_INDEX].equals(Course.FRONTEND.getName())) {
			pairStorage.frontEndPair.put(Level.getLevelByName(eachInform[LEVEL_INDEX]), missionPair);
		}
		OutputView.printPairResult(pairs);
	}

	public void lookUpPair(PairStorage pairStorage, InputController inputController) {
		try {
			String[] eachInform = inputController.scanCourseLevelMission();
			Pairs pairs = pairStorage.getPairs(Level.getLevelByName(eachInform[LEVEL_INDEX]),
				eachInform[MISSION_INDEX], eachInform[COURSE_INDEX]);
			OutputView.printPairResult(pairs);
		} catch (IllegalArgumentException e) {
			OutputView.printNoExistError();
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
