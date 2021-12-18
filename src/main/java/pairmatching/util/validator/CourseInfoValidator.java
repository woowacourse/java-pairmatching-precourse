package pairmatching.util.validator;

import java.util.Arrays;
import java.util.List;

import pairmatching.Model.Course;
import pairmatching.Model.Level;
import pairmatching.util.ErrorMessage;

public class CourseInfoValidator {
	public static final int COURSE_INFO = 0;
	public static final int LEVEL_INFO = 1;
	public static final int MISSION_NAME_INFO = 2;
	public static final String INPUT_FORMAT = "[가-힣]+(,\\s레벨[0-9]{1})(,\\s[가-힣]+)";

	public static void validateInfo(String input) {
		validateFormat(input);
		String[] splitInfo = split(input);
		validateCourse(splitInfo);
		validateMissionName(splitInfo);
	}

	private static void validateFormat(String input) {
		if (!input.matches(INPUT_FORMAT)) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_FORMAT.getMessage());
		}

	}

	private static String[] split(String input) {
		return input.split(", ");
	}

	private static void validateCourse(String[] info) {
		Course.fineCourse(info[COURSE_INFO]);
	}

	private static void validateMissionName(String[] info) {
		Level.fineLevel(info[LEVEL_INFO], info[MISSION_NAME_INFO]);
	}

}
