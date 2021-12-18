package pairmatching.controller;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class InputController {
	public static final int COURSE_INDEX = 0;
	public static final int LEVEL_INDEX = 1;
	public static final int MISSION_INDEX = 2;

	public String scanSelectFunction() {
		while (true) {
			try {
				InputView.askSelectFunction();
				String functionNum = Console.readLine();
				InputValidator.isValidFunctionNum(functionNum);
				return functionNum;
			} catch (IllegalArgumentException e) {
				OutputView.printInputFunctionError();
			}
		}
	}

	public String[] scanCourseLevelMission() {
		while (true) {
			try {
				InputView.askCourseLevelMission();
				String courseLevelMission = Console.readLine();
				String[] eachInform = courseLevelMission.split(",");
				eachInform[COURSE_INDEX] = InputValidator.isValidCourse(eachInform[COURSE_INDEX]);
				eachInform[LEVEL_INDEX] = InputValidator.isValidLevel(eachInform[LEVEL_INDEX]);
				eachInform[MISSION_INDEX] = InputValidator.isValidMission(eachInform[LEVEL_INDEX],
					eachInform[MISSION_INDEX]);
				return eachInform;
			} catch (IllegalArgumentException e) {
				OutputView.printInputCourseLevelMissionError();
			}
		}
	}
}
