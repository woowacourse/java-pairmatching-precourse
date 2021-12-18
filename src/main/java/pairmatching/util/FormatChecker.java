package pairmatching.util;

import java.util.regex.Pattern;

public class FormatChecker {
	private static final String COURSE_LEVEL_MISSION_INPUT_REGEX =
		"[a-zA-Z가-힣ㄱ-ㅎㅏ-ㅣ0-9]+, [a-zA-Z가-힣ㄱ-ㅎㅏ-ㅣ0-9]+, [a-zA-Z가-힣ㄱ-ㅎㅏ-ㅣ0-9]+";

	public static boolean validateCourseLevelMissionInputFormat(String input) {
		return Pattern.matches(COURSE_LEVEL_MISSION_INPUT_REGEX, input);
	}

}
