package pairmatching.controller;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;

public class InputValidator {
	public static boolean isValidFunctionNum(String num) {
		if (num.equals("1") || num.equals("2") || num.equals("3") || num.equals("Q")) {
			return true;
		}
		throw new IllegalArgumentException();
	}

	public static String isValidCourse(String inputCourse) {
		for (Course course : Course.values()) {
			if (course.getName().equals(inputCourse.trim())) {
				return inputCourse.trim();
			}
		}
		throw new IllegalArgumentException();
	}

	public static String isValidLevel(String inputLevel) {
		for (Level level : Level.values()) {
			if (level.getName().equals(inputLevel.trim())) {
				return inputLevel.trim();
			}
		}
		throw new IllegalArgumentException();
	}

	public static String isValidMission(String inputLevel, String inputMission) {
		if (inputLevel.equals(Level.LEVEL1.getName())) {
			if (Mission.LEVEL1_MISSION.getMissionList().contains(inputMission.trim())) {
				return inputMission.trim();
			}
		}
		if (inputLevel.equals(Level.LEVEL2.getName())) {
			if (Mission.LEVEL2_MISSION.getMissionList().contains(inputMission.trim())) {
				return inputMission.trim();
			}
		}
		if (inputLevel.equals(Level.LEVEL4.getName())) {
			if (Mission.LEVEL4_MISSION.getMissionList().contains(inputMission.trim())) {
				return inputMission.trim();
			}
		}
		throw new IllegalArgumentException();
	}
}
