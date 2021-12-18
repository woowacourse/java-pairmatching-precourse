package pairmatching;

import java.util.Arrays;

public class Validator {
	private static final String NOT_VALID_MENU_ERROR = "[ERROR] 해당하는 기능이 없습니다. 다시 입력해주세요.";
	private static final String NOT_VALID_COURSE_ERROR = "[ERROR] 해당하는 코스가 없습니다. 다시 입력해주세요.";
	private static final String NOT_VALID_LEVEL_ERROR = "[ERROR] 해당하는 레벨이 없습니다. 다시 입력해주세요.";
	// private static final String NOT_VALID_MISSION_ERROR = "[ERROR] 해당하는 미션이 없습니다. 다시 입력해주세요.";

	private static final String INPUT_LIST_LENGTH_ERROR = "[ERROR] 누락된 입력이 있습니다. 다시 입력해주세요.";
	private static String[] menu = {"1", "2", "3", "Q"};



	public static void notValidMenu(String input) {
		if (!Arrays.asList(menu).contains(input)) {
			throw new IllegalArgumentException(NOT_VALID_MENU_ERROR);
		}
	}

	public static void checkinputCourseLevelMission(String[] input) {
		checkInputListLength(input);
		checkCourse(input);
		checkLevel(input);
	}

	public static void checkInputListLength(String[] courseList) {
		if (courseList.length != 3) {
			throw new IllegalArgumentException(INPUT_LIST_LENGTH_ERROR);
		}
	}

	public static void checkCourse(String[] input) {
		Course[] courseList = Course.getCoursesList();
		for (Course course : courseList) {
			if (input[0].equals(course.getName())){
				// System.out.println("발견");
				return;
			}
			throw new IllegalArgumentException(NOT_VALID_COURSE_ERROR);
		}
	}

	public static void checkLevel(String[] input) {
		Level[] levelList = Level.getLevelList();
		for (Level level : levelList) {
			if (input[1].equals(level.getName())){
				System.out.println("발견");
				return;
			}
			throw new IllegalArgumentException(NOT_VALID_LEVEL_ERROR);
		}
	}

	// public static void checkMission(String[] input, Course[] courseList) {
	// 	for (Course course : courseList) {
	// 		if (input[2].equals(course.getName())){
	// 			System.out.println("발견");
	// 		}
	// 		throw new IllegalArgumentException(NOT_VALID_MISSION_ERROR);
	// 	}
	// }
}
