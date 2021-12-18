package pairmatching.view;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputFormatValidator {
	private static final int MAIN_OPTION_COUNT = 3;
	private static final int MATCHING_OPTION_COUNT = 3;
	private static final int COURSE_INDEX = 0;
	private static final int LEVEL_INDEX = 1;

	private static final String DELIMITER = ", ";
	private static final String BACKEND = "백엔드";
	private static final String FRONTEND = "프론트엔드";
	private static final String LEVEL_REGEX = "레벨[1-5]+";
	private static final String NOT_INT_ERROR_MSG = "숫자 또는 Q를 입력해주세요.";
	private static final String INVALID_RANGE_ERROR_MSG = "기능 번호를 확인해주세요.";
	private static final String INVALID_MATCHING_INPUT_ERROR_MSG = "입력이 올바르지 않습니다.";

	public static String validateOptionFormat(String option) throws IllegalArgumentException {
		if (!option.equals("Q")) {
			int optionNum = transferToInt(option);
			validateRange(optionNum);
		}
		return option;
	}

	private static int transferToInt(String option) throws IllegalArgumentException {
		try {
			return Integer.parseInt(option);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(NOT_INT_ERROR_MSG);
		}
	}

	private static void validateRange(int optionNum) throws IllegalArgumentException {
		if (optionNum <= 0 || optionNum > MAIN_OPTION_COUNT) {
			throw new IllegalArgumentException(INVALID_RANGE_ERROR_MSG);
		}
	}

	public static List<String> validateMatchingOptionFormat(String option) throws IllegalArgumentException {
		List<String> matchingOptions = splitOption(option);
		if (matchingOptions.size() != MATCHING_OPTION_COUNT) {
			throw new IllegalArgumentException(INVALID_MATCHING_INPUT_ERROR_MSG);
		}
		validateCourse(matchingOptions.get(COURSE_INDEX));
		validateLevel(matchingOptions.get(LEVEL_INDEX));
		return matchingOptions;
	}

	private static void validateCourse(String course) throws IllegalArgumentException {
		if (!Pattern.matches(BACKEND, course) && !Pattern.matches(FRONTEND, course)) {
			throw new IllegalArgumentException(INVALID_MATCHING_INPUT_ERROR_MSG);
		}
	}

	private static void validateLevel(String level) throws IllegalArgumentException {
		if (!Pattern.matches(LEVEL_REGEX, level)) {
			throw new IllegalArgumentException(INVALID_MATCHING_INPUT_ERROR_MSG);
		}
	}

	private static List<String> splitOption(String option) {
		return Arrays.asList(option.split(DELIMITER));
	}
}
