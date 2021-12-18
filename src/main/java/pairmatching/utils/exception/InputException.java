package pairmatching.utils.exception;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.model.Course;
import pairmatching.model.Level;
import pairmatching.model.Mission;

public class InputException {

	private static final String SPACE = " ";
	private static final String CONTAIN_SPACE = "공백이 입력되었습니다.";
	private static final String INVALID_NUMBER = "번호가 잘못 입력되었습니다.";
	private static final String INFORMATION_DELIMITER = ", ";
	private static final String INVALID_COURSE = "과정이 잘못 입력되었습니다.";
	private static final String INVALID_LEVEL = "레벨이 잘못 입력되었습니다.";
	private static final String INVALID_MISSION = "미션이 잘못 입력되었습니다.";

	private InputException() {
	}

	public static void validateFunctionNumber(String number, List<String> functions) {
		if (containSpace(number)) {
			throw new IllegalArgumentException(CONTAIN_SPACE);
		}
		for (String function : functions) {
			if (function.startsWith(number)) {
				return;
			}
		}
		throw new IllegalArgumentException(INVALID_NUMBER);
	}

	public static void validateInformation(List<String> filteredInformation) {
		if (!checkCourse(filteredInformation)) {
			throw new IllegalArgumentException(INVALID_COURSE);
		}
		if (!checkLevel(filteredInformation)) {
			throw new IllegalArgumentException(INVALID_LEVEL);
		}
		if (!checkMission(filteredInformation)) {
			throw new IllegalArgumentException(INVALID_MISSION);
		}
	}

	private static boolean containSpace(String input) {
		return input.isEmpty() || input.contains(SPACE);
	}

	private static boolean checkCourse(List<String> information) {
		String course = information.get(0);
		return Arrays.stream(Course.values()).map(Course::getName).collect(Collectors.toList())
			.contains(course);
	}

	private static boolean checkLevel(List<String> information) {
		String level = information.get(1);
		return Arrays.stream(Level.values()).map(Level::getName).collect(Collectors.toList())
			.contains(level);
	}

	private static boolean checkMission(List<String> information) {
		String mission = information.get(2);
		return Arrays.stream(Mission.values()).map(Mission::getName).collect(Collectors.toList())
			.contains(mission);
	}
}
