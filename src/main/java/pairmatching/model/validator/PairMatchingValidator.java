package pairmatching.model.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.model.Course;
import pairmatching.model.Level;

public class PairMatchingValidator {

	public static final String IS_KEEP_FORMAT_ERROR_MESSAGE = "[ERROR] 포맷에 어긋나는 입력입니다.";
	public static final String IS_PROPER_COURSE_ERROR_MESSAGE = "[ERROR] 존재하지 않는 코스 입니다.";
	public static final String IS_PROPER_LEVEL_ERROR_MESSAGE = "[ERROR] 존재하지 않는 레벨입니다.";
	public static final String IS_PROPER_MISSION_ERROR_MESSAGE = "[ERROR] 존재하지 않는 미션입니다.";

	String[] levelOneMissionArr = {"자동차경주", "로또", "숫자야구게임"};
	String[] levelTwoMissionArr = {"장바구니", "결재", "지하철노선도"};
	String[] levelFourMissionArr = {"성능개선", "배포"};

	List<String> courseNameList = Arrays.stream(Course.values())
		.map(course -> course.getName())
		.collect(Collectors.toList());
	List<String> levelNameList = Arrays.stream(Level.values())
		.map(level -> level.getName())
		.collect(Collectors.toList());

	public boolean validate(String input) {
		try {
			isKeepFormat(input);
			isProperCourse(input);
			isProperLevel(input);
			isProperMission(input);
			return false;
		} catch (IllegalArgumentException illegalArgumentException) {
			return true;
		}

	}

	private void isKeepFormat(String input) throws IllegalArgumentException {
		String[] split = input.split(",");
		if (split.length != 3 && split.length != 2) {
			System.out.println(IS_KEEP_FORMAT_ERROR_MESSAGE);
			throw new IllegalArgumentException();
		}
	}

	private void isProperCourse(String input) throws IllegalArgumentException {
		String[] split = input.split(",");

		if (!courseNameList.contains(split[0])) {
			System.out.println(IS_PROPER_COURSE_ERROR_MESSAGE);
			throw new IllegalArgumentException();
		}
	}

	private void isProperLevel(String input) throws IllegalArgumentException {
		String[] split = input.split(",");

		if (!levelNameList.contains(split[1])) {
			System.out.println(IS_PROPER_LEVEL_ERROR_MESSAGE);
			throw new IllegalArgumentException();
		}
	}

	private void isProperMission(String input) throws IllegalArgumentException {
		String[] split = input.split(",");

		checkLevelOneMission(split);

		checkLevelTwoMission(split);

		checkLevelFourMission(split);
	}

	private void checkLevelFourMission(String[] split) throws IllegalArgumentException {
		if (split[1].equals("레벨4")) {
			ArrayList<String> levelFourMissionList = new ArrayList<>(Arrays.asList(levelFourMissionArr));
			if (!levelFourMissionList.contains(split[2])) {
				System.out.println(IS_PROPER_MISSION_ERROR_MESSAGE);
				throw new IllegalArgumentException();
			}
		}
	}

	private void checkLevelTwoMission(String[] split) throws IllegalArgumentException {
		if (split[1].equals("레벨2")) {
			ArrayList<String> levelTwoMissionList = new ArrayList<>(Arrays.asList(levelTwoMissionArr));
			if (!levelTwoMissionList.contains(split[2])) {
				System.out.println(IS_PROPER_MISSION_ERROR_MESSAGE);
				throw new IllegalArgumentException();
			}
		}
	}

	private void checkLevelOneMission(String[] split) throws IllegalArgumentException {
		if (split[1].equals("레벨1")) {
			ArrayList<String> levelOneMissionList = new ArrayList<>(Arrays.asList(levelOneMissionArr));
			if (!levelOneMissionList.contains(split[2])) {
				System.out.println(IS_PROPER_MISSION_ERROR_MESSAGE);
				throw new IllegalArgumentException();
			}
		}
	}
}
