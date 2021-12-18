package pairmatching.validation;

import static pairmatching.constants.Constants.*;
import static pairmatching.constants.ErrorMessage.*;

import pairmatching.model.Course;
import pairmatching.model.Level;

public class PairMatchingValidation {
	public static void isFunctionNumber(String input) {
		int functionNumber = Integer.parseInt(input);
		if (!(functionNumber > 0 && functionNumber < 4)) {
			throw new IllegalArgumentException(NOT_INTO_RANGE);
		}
	}

	public static void isExistCourse(String[] course) {
		if (!course[COURSE_IDX].equals(Course.BACKEND.getName()) && !course[COURSE_IDX].equals(
			Course.FRONTEND.getName())) {
			throw (new IllegalArgumentException(NOT_EXIST_COURSE));
		}
		Level levelByString = Level.findLevelByString(course[LEVEL_IDX]);
		if (levelByString == null) {
			throw (new IllegalArgumentException(NOT_EXIST_LEVEL));
		}
		for (String mission:
			levelByString.getMissions()) {
			if (mission.equals(course[MISSION_IDX])) {
				return;
			}
		}
		throw (new IllegalArgumentException(NOT_EXIST_MISSION));
	}
}
