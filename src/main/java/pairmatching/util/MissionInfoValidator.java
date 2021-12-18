package pairmatching.util;

import java.util.Arrays;
import java.util.List;

public class MissionInfoValidator {
	private static final Integer COURSE_INDEX = 0;
	private static final Integer LEVEL_INDEX = 1;
	private static final Integer MISSION_INDEX = 0;

	public static List<String> validate(String inputString) {
		inputString = removeBlank(inputString);
		List<String> params = Arrays.asList(inputString.split(","));

		if(!CourseValidator.validate(params.get(COURSE_INDEX)))
			throw new IllegalArgumentException(SystemMessage.ERROR_NOT_COURSE);
		if(!LevelValidator.validate(params.get(LEVEL_INDEX)))
			throw new IllegalArgumentException(SystemMessage.ERROR_NOT_LEVEL);
		if(!MissionValidator.validate(params.get(MISSION_INDEX)))
			throw new IllegalArgumentException(SystemMessage.ERROR_NOT_MISSION);

		return params;
	}

	private static String removeBlank(String str) {
		return str.replaceAll("\\s+", "");
	}
}
