package pairmatching.util;

import java.util.Arrays;
import java.util.List;

public class MissionInfoValidator {
	private static final Integer COURSE_INDEX = 0;
	private static final Integer LEVEL_INDEX = 1;
	private static final Integer MISSION_INDEX = 0;
	public static List<String> validate(String inputString) {
		inputString = removeBlank(inputString);
		return Arrays.asList(inputString.split(","));
	}

	private static String removeBlank(String str) {
		return str.replaceAll("\\s+", "");
	}
}
