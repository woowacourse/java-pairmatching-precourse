package pairmatching.utils;

import static pairmatching.utils.Constant.*;
import static pairmatching.view.ErrorMessage.*;

import java.util.regex.Pattern;

public class Validator {
	public static void validateMode(String userInputMode) {
		if (!isExistMode(userInputMode)) {
			throw new IllegalArgumentException(ERROR_NOT_EXISTED_FUNCTION);
		}
	}

	private static boolean isExistMode(String userInputMode) {
		return FUNCTION_SELECT_LIST.stream().anyMatch(f -> f.equals(userInputMode));
	}

	public static void validateInputFormat(String line) {
		if (!isValidFormat(line)) {
			throw new IllegalArgumentException(ERROR_INVALID_FORMAT);
		}
	}

	private static boolean isValidFormat(String line) {
		return Pattern.matches(VALID_FORMAT, line);
	}
}
