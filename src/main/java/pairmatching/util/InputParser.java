package pairmatching.util;

import java.util.Arrays;
import java.util.List;

public class InputParser {
	private static final String COURSE_LEVEL_MISSION_DELIMITER = ", ";

	public static List<String> parseCourseLevelMission(String input) {
		return Arrays.asList(input.split(COURSE_LEVEL_MISSION_DELIMITER));
	}
}
