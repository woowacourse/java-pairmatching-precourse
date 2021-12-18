package pairmatching.util;

import java.util.Arrays;
import java.util.List;

import pairmatching.domain.Course;
import pairmatching.domain.Level;

public class InformationValidator extends Validator {
	private static final int INFORMATION_LENGTH = 3;

	public static void isRightInformation(String input, List<String> missionNames) {
		isEmpty(input);

		String[] infos = input.split(", ");
		if (infos.length != INFORMATION_LENGTH) {
			throw new IllegalArgumentException("정보를 올바르게 입력해주세요.");
		}

		if (!isContainsCourse(infos[0])) {
			throw new IllegalArgumentException("존재하는 코스를 입력해주세요.");
		}

		if (!isContainsLevel(infos[1])) {
			throw new IllegalArgumentException("존재하는 레벨을 입력해주세요.");
		}

		if (!isContainsMissionInput(infos[2], missionNames)) {
			throw new IllegalArgumentException("존재하는 미션을 입력해주세요.");
		}
	}

	private static Boolean isContainsMissionInput(String inputMission, List<String> missionNames) {
		return missionNames.contains(inputMission);
	}

	private static Boolean isContainsLevel(String inputLevel) {
		return Arrays.stream(Level.values())
			.anyMatch(level -> level.getLevel().equals(inputLevel));
	}

	private static Boolean isContainsCourse(String inputCourse) {
		return Arrays.stream(Course.values())
			.anyMatch(course -> course.getCourse().equals(inputCourse));
	}
}
