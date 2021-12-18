package pairmatching.validator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import pairmatching.constant.LevelAndMission;
import pairmatching.dto.ChoiceDto;

public class InputValidator {

	public static final String ERROR_PREFIX = "[ERROR] ";
	public static final String INVALID_ENTRY_MENU_CHOICE = ERROR_PREFIX + "존재 하지 않는 메뉴 항목입니다";
	public static final String INVALID_SUB_MENU_CHOICE = ERROR_PREFIX + "잘못된 입력입니다. 예: 과정, 레벨, 미션";
	public static final String INVALID_NOT_FOUND_MISSIONS = ERROR_PREFIX + "존재하지 않는 미션입니다";

	public static final List<String> ENTRY_MENU_LIST = Arrays.asList("1", "2", "3", "Q");
	public static final List<String> YES_OR_NO_LIST = Arrays.asList("예", "아니오");

	public static void validateEntryMenu(String input) {
		if (!ENTRY_MENU_LIST.contains(input)) {
			throw new IllegalArgumentException(INVALID_ENTRY_MENU_CHOICE);
		}
	}

	public static void validateSubMenu(String input) {
		String regExp = "^[\\w가-힣]*,\\s*[\\w가-힣]*,\\s*[\\w가-힣]*\\s*$";
		boolean matches = Pattern.matches(regExp, input);
		if (!matches) {
			throw new IllegalArgumentException(INVALID_SUB_MENU_CHOICE);
		}
	}

	public static void validateMatching(String input) {
		ChoiceDto choiceDto = new ChoiceDto(input);
		String levelName = choiceDto.getLevel();
		String missionName = choiceDto.getMission();
		boolean matches =
			LevelAndMission.isExistLevelAndMissions(levelName, missionName);
		if (!matches) {
			throw new IllegalArgumentException(INVALID_NOT_FOUND_MISSIONS);
		}
	}

	public static void validateMatchingAgain(String input) {
		if (!YES_OR_NO_LIST.contains(input)) {
			throw new IllegalArgumentException("'예' 혹은 '아니오' 만 입력 가능합니다.");
		}
	}
}
