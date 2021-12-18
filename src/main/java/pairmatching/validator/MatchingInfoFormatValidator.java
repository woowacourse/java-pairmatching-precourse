package pairmatching.validator;

import java.util.ArrayList;

import pairmatching.model.Course;
import pairmatching.model.Level;
import pairmatching.model.Mission;
import pairmatching.util.ErrorMessage;

public class MatchingInfoFormatValidator {
	public static String[] isNumberOfInfo3(String[] input) {
		if (input.length != 3) {
			throw new IllegalArgumentException(ErrorMessage.NUMBER_OF_INFO_IS_NOT_3);
		}
		return input;
	}

	public static void isInCourse(String input) {
		int count = 0;
		for (Course course : Course.values()) {
			if (course.getName().equals(input)) {
				count += 1;
				break;
			}
		}
		if (count == 0) {
			throw new IllegalArgumentException(ErrorMessage.IS_NOT_IN_COURSE);
		}
	}

	public static void isInLevel(String input) {
		int count = 0;
		for (Level level : Level.values()) {
			if (level.getName().equals(input)) {
				count += 1;
				break;
			}
		}
		if (count == 0) {
			throw new IllegalArgumentException(ErrorMessage.IS_NOT_IN_LEVEL);
		}
	}

	public static void isInMission(ArrayList<Mission> missions, String input) {
		int count = 0;
		for (Mission mission : missions) {
			if (mission.getName().equals(input)) {
				count += 1;
				break;
			}
		}
		if (count != 1) {
			throw new IllegalArgumentException(ErrorMessage.IS_NOT_IN_MISSION);
		}
	}
}
