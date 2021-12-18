package pairmatching.utils;

import java.util.Arrays;

import pairmatching.domain.level.Levels;

public class Validator {
	private static final String INVALID_FUNCTION = "[ERROR] 잘못된 기능 입력입니다.";
	private static final String INVALID_COURSE_LEVEL_MISSION = "[ERROR] 과정, 레벨, 미션 모두를 입력해 주세요.";
	private static final String INVALID_COURSE = "[ERROR] 올바르지 않은 과정 입력입니다.";
	private static final String INVALID_LEVEL = "[ERROR] 올바르지 않은 레벨 입력입니다.";
	private static final String INVALID_MISSION = "[ERROR] 올바르지 않은 미션 입력입니다.";
	private static final String BACKEND = "백엔드";
	private static final String FRONTEND = "프론트엔드";

	private static final String[] LEVELS = {"레벨1", "레벨2", "레벨3", "레벨4", "레벨5"};

	private static final int MAX_FUNCTION_NUMBER = 3;
	private static final int INFORMATION_COUNTS = 3;

	public static void validateFunctionNumber(String input) {
		try {
			int number = Integer.parseInt(input);
			if (number > MAX_FUNCTION_NUMBER) {
				throw new IllegalArgumentException(INVALID_FUNCTION);
			}
		} catch (NumberFormatException e) {
			if (input.equals("Q")) {
				return;
			}
			throw new IllegalArgumentException(INVALID_FUNCTION);
		}
	}

	public static void validateCourseLevelMission(String[] information) {
		validateInfoCounts(information);
		String course = information[0].trim();
		String level = information[1].trim();
		String mission = information[2].trim();

		validateCourse(course);
		validateLevel(level);
		validateMission(mission, level);
	}

	private static void validateInfoCounts(String[] information) {
		if (information.length != INFORMATION_COUNTS) {
			throw new IllegalArgumentException(INVALID_COURSE_LEVEL_MISSION);
		}
	}

	private static void validateCourse(String course) {
		if (course.equals("") || (!course.equals(BACKEND) && !course.equals(FRONTEND))) {
			throw new IllegalArgumentException(INVALID_COURSE);
		}
	}

	private static void validateLevel(String level) {
		if (level.equals("") || Arrays.stream(LEVELS).noneMatch(level::equals)) {
			throw new IllegalArgumentException(INVALID_LEVEL);
		}
	}

	private static void validateMission(String mission, String level) {
		if (mission.equals("") || !Levels.getInstance().getLevel(level).contains(mission)) {
			throw new IllegalArgumentException(INVALID_MISSION);
		}
	}
}
