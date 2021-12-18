package pairmatching.utils;

import java.util.HashSet;
import java.lang.IllegalArgumentException;

public class Validator {
	private static final String MATCH_STRING = "1";
	private static final String SEEK_STRING = "2";
	private static final String INIT_STRING = "3";
	private static final String END_STRING = "Q";
	private static final int MATCH_SIZE = 3;
	private static final int COURSE_INDEX = 0;
	private static final int LEVEL_INDEX = 1;
	private static final int MISSION_INDEX = 2;
	private static final String DELIMITER = ", ";
	private static final String YES = "예";
	private static final String NO = "아니오";

	public static void checkName(String name) throws IllegalArgumentException {
		if (!name.matches(MyRegex.ONLY_KOREAN_AND_ENGLISH.getRegexPattern())) {
			throw new IllegalArgumentException(ErrorMessage.ERROR_NAME_PATTERN_MSG.getMessage());
		}
	}

	public static void checkDuplicate(String name, HashSet<String> uniqueNameSet) throws IllegalArgumentException {
		if (uniqueNameSet.contains(name)) {
			throw new IllegalArgumentException(ErrorMessage.ERROR_DUPLICATE_MSG.getMessage());
		}
		uniqueNameSet.add(name);
	}

	public static void checkMenuInput(String input) throws IllegalArgumentException {
		if (!(input.equals(MATCH_STRING) || input.equals(SEEK_STRING) || input.equals(INIT_STRING) || input.equals(END_STRING))) {
			throw new IllegalArgumentException(ErrorMessage.ERROR_MENU_INPUT_MSG.getMessage());
		}
	}

	public static void checkEmpty(String input) throws IllegalArgumentException {
		if (input.isEmpty()) {
			throw new IllegalArgumentException(ErrorMessage.ERROR_EMPTY_INPUT_MSG.getMessage());
		}
	}

	public static void checkMatchInputSize(String input) throws IllegalArgumentException{
		checkEmpty(input);
		String[] parsed = input.split(DELIMITER);
		if (parsed.length < MATCH_SIZE) {
			throw new IllegalArgumentException(ErrorMessage.ERROR_MATCH_INPUT_SIZE_MSG.getMessage());
		}
	}

	public static void checkMatchInputElement(String[] input) throws IllegalArgumentException{
		if (!Course.generateAllCourses().contains(input[COURSE_INDEX])) {
			throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_IN_COURSE_MSG.getMessage());
		}
		if (!Level.generateAllLevels().containsKey(input[LEVEL_INDEX])) {
			throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_IN_LEVEL_MSG.getMessage());
		}
		if (Level.generateAllLevels().get(input[LEVEL_INDEX]).size() != 0 && !Level.generateAllLevels()
			.get(input[LEVEL_INDEX])
			.contains(input[MISSION_INDEX])) {
			throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_IN_MISSION_MSG.getMessage());
		}
	}

	public static void checkMatchInput(String input) throws IllegalArgumentException{
		checkMatchInputSize(input);
		checkMatchInputElement(input.split(DELIMITER));
	}

	public static void checkReMatchInput(String input) {
		checkEmpty(input);
		if (!(input.equals(YES) || input.equals(NO))) {
			throw new IllegalArgumentException(ErrorMessage.ERROR_YES_OR_NO_MSG.getMessage());
		}
	}
}
