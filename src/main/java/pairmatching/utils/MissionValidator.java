package pairmatching.utils;

import java.util.StringTokenizer;

import pairmatching.repository.CourseRepository;
import pairmatching.repository.MissionRepository;

public class MissionValidator {
	public static final String MISSION_DELIMITER = ",";
	public static final int MISSION_INFO_COUNT = 3;

	public static final String ERROR_NO_COURSE = "[ERROR] 입력하신 과정은 존재하지 안습니다.";
	public static final String ERROR_NO_LEVEL = "[ERROR] 입력하신 레벨은 존재하지 않습니다.";
	public static final String ERROR_NO_MISSION_IN_LEVEL = "[ERROR] 입력하신 미션은 입력하신 레벨에 존재하지 않습니다.";
	public static final String ERROR_MISSING_MISSION_INFO = "[ERROR] 과정, 레벨, 미션 항목을 모두 입력해주세요";

	public static void validateMission(String inputValues) {
		StringTokenizer stringTokenizer = new StringTokenizer(inputValues, MISSION_DELIMITER);
		isInfoCountRight(stringTokenizer.countTokens());

		String course = stringTokenizer.nextToken();
		String level = stringTokenizer.nextToken();
		String mission = stringTokenizer.nextToken();

		checkCourse(course);
		checkLevel(level);
		checkMission(level, mission);
	}

	private static void checkCourse(String course) {
		if (!CourseRepository.contains(course)) {
			throw new IllegalArgumentException(ERROR_NO_COURSE);
		}
	}

	private static void checkLevel(String level) {
		if (!MissionRepository.existLevel(level)) {
			throw new IllegalArgumentException(ERROR_NO_LEVEL);
		}
	}

	private static void checkMission(String level, String mission) {
		if (!MissionRepository.existMission(level, mission)) {
			throw new IllegalArgumentException(ERROR_NO_MISSION_IN_LEVEL);
		}
	}

	private static void isInfoCountRight(int infoCount) {
		if (infoCount != MISSION_INFO_COUNT) {
			throw new IllegalArgumentException(ERROR_MISSING_MISSION_INFO);
		}
	}

}
