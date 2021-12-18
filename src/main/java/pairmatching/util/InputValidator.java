package pairmatching.util;

import java.util.Arrays;
import java.util.List;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;

public class InputValidator {
	private static final String MATCH_PAIR = "1";
	private static final String LOOKUP_PAIR = "2";
	private static final String RESET_PAIR = "3";
	private static final String TERMINATION = "Q";
	private static final String ERROR = "[ERROR] ";
	private static final String INPUT_ERROR = "유효하지 않은 입력입니다.";
	private static final String COURSE_ERROR = "해당 과정이 존재하지 않습니다.";
	private static final String LEVEL_ERROR = "해당 레벨이 존재하지 않습니다.";
	private static final String MISSION_ERROR = "해당 미션이 존재하지 않습니다.";
	private static final String SPLITTER = ", ";
	private static final String YES = "네";
	private static final String NO = "아니오";
	private static final int COURSE = 0;
	private static final int LEVEL = 1;
	private static final int MISSION = 2;

	public static void mainCommend(String mainCommend) {
		if (!(mainCommend.equals(MATCH_PAIR) || mainCommend.equals(LOOKUP_PAIR) || mainCommend.equals(RESET_PAIR) || mainCommend.equals(TERMINATION))) {
			throw new IllegalArgumentException(ERROR + INPUT_ERROR);
		}
	}

	public static void isValidFormat(String mission) {
		List<String> missionInfo = Arrays.asList(mission.split(SPLITTER));
		isValidCourse(missionInfo.get(COURSE));
		isValidLevel(missionInfo.get(LEVEL));
		isValidMission(missionInfo.get(MISSION));
	}

	private static void isValidCourse(String course) {
		if (!Arrays.asList(Course.values()).contains(Course.nameOf(course))) {
			throw new IllegalArgumentException(ERROR + COURSE_ERROR);
		}
	}

	private static void isValidLevel(String level) {
		if (!Arrays.asList(Level.values()).contains(Level.nameOf(level))) {
			throw new IllegalArgumentException(ERROR + LEVEL_ERROR);
		}
	}

	private static void isValidMission(String mission) {
		if (!Arrays.asList(Mission.values()).contains(Mission.nameOf(mission))) {
			throw new IllegalArgumentException(ERROR + MISSION_ERROR);
		}
	}

	public static void rematch(String rematch) {
		if (!(rematch.equals(YES) || rematch.equals(NO))) {
			throw new IllegalArgumentException(ERROR + INPUT_ERROR);
		}
	}
}
