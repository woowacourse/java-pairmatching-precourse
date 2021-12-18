package pairmatching.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Menu;
import pairmatching.domain.Mission;

public class Validator {

	private static final String BLANK_STRING_ERROR_MESSAGE = "아무것도 입력되지 않았습니다.";
	private static final String INVALID_MENU = "존재하지 않는 메뉴입니다.";
	private static final String INVALID_INPUT = "유효하지 않은 입력 포맷입니다.";
	private static final String PAIR_MATCHING_INPUT_FORMAT = "(.+), (.+), (.+)";
	private static final String INVALID_COURSE_STRING = "해당하는 과정이 존재하지 않습니다.";
	private static final String INVALID_LEVEL_STRING = "해당하는 레벨이 존재하지 않습니다.";
	private static final String INVALID_MISSION_STRING = "해당하는 미션이 존재하지 않습니다.";

	public static void checkEmptyString(String input) {
		if (input.isEmpty()) {
			throw new IllegalArgumentException(BLANK_STRING_ERROR_MESSAGE);
		}
	}

	public static void checkRangeInMenu(String ret) {
		List<Menu> menus = Arrays.asList(Menu.values());
		List<String> menuValidInputs = menus.stream().map(Menu::toString).collect(Collectors.toList());
		if (!menuValidInputs.contains(ret)) {
			throw new IllegalArgumentException(INVALID_MENU);
		}
	}

	public static void validateFormat(String input) {
		if (!input.matches(PAIR_MATCHING_INPUT_FORMAT)) {
			throw new IllegalArgumentException(INVALID_INPUT);
		}
	}

	public static void checkListSize(List<String> input, int i) {
		if (input.size() != i) {
			throw new IllegalArgumentException(INVALID_INPUT);
		}
	}

	public static void checkValidInput(List<String> input) {

		String course = input.get(0);
		String level = input.get(1);
		String mission = input.get(2);

		if(!Course.contains(course)){
			throw new IllegalArgumentException(INVALID_COURSE_STRING);
		}
		if (!Level.contains(level)) {
			throw new IllegalArgumentException(INVALID_LEVEL_STRING);
		}
		if (!Mission.contains(mission)) {
			throw new IllegalArgumentException(INVALID_MISSION_STRING);
		}

	}
}
