package pairmatching.utils;

import java.util.Arrays;
import java.util.List;

public class FunctionValidator {
	public static final String ERROR_NO_FUNCTION = "[ERROR] 해당하는 기능은 존재하지 않습니다.";

	private static List<String> functionList = Arrays.asList("1", "2", "3", "Q");

	public static void validateFunction(String inputValue) {
		isInFunction(inputValue);
	}

	private static void isInFunction(String inputValue) {
		if (!functionList.contains(inputValue)) {
			throw new IllegalArgumentException(ERROR_NO_FUNCTION);
		}
	}

}
