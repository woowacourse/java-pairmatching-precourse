package pairmatching.controller;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.view.InputView;

public class MainHandler {
	private static final String COMMAND_SPLIT = ",";
	private static final int COMMAND_SPLIT_LIMIT = -1;
	private static final int COURSE_INDEX = 0;
	private static final int LEVEL_INDEX = 1;
	private static final int MISSION_INDEX = 2;

	public static void matchingManager() {
		try {
			final String[] command = InputView.getInputPairMatching().split(COMMAND_SPLIT, COMMAND_SPLIT_LIMIT);
			Course.findByCourse(command[COURSE_INDEX]);
			Level.findByLevel(command[LEVEL_INDEX]);
			Level.findByMission(command[MISSION_INDEX]);

			// 페어 매칭 결과입니다.
		} catch (IllegalArgumentException e) {
			matchingManager();
		}
	}

	public static void referenceManager() {
	}

	public static void initializationManager() {
	}

	public static void exitManager() {
		return;
	}
}
