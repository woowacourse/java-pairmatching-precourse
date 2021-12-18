package utils.validator;

import java.util.regex.Pattern;

public class FunctionSelectionNumberValidator {

	private FunctionSelectionNumberValidator() {
	}

	public static String checkValidNumber(String functionSelectionNumber) {
		if (isRightInputLength(functionSelectionNumber) && !hasBlankInInput(functionSelectionNumber) && isRightNumber(
			functionSelectionNumber)) {
			return functionSelectionNumber;
		}
		throw new IllegalArgumentException();
	}

	private static boolean isRightInputLength(String functionSelectionNumber) {
		if (functionSelectionNumber.length() != 1) {
			throw new IllegalArgumentException("[ERROR] 입력한 기능 선택 번호가 한자리가 아니다.");
		}
		return true;
	}

	private static boolean hasBlankInInput(String functionSelectionNumber) {
		if (functionSelectionNumber.contains(" ")) {
			throw new IllegalArgumentException("[ERROR] 입력한 기능 선택 번호에 공백이 있다.");
		}
		return false;
	}

	private static boolean isRightNumber(String functionSelectionNumber) {
		if (Pattern.matches("^[1-3]", functionSelectionNumber)) {
			return true;
		}
		if (Pattern.matches("Q", functionSelectionNumber)) {
			return true;
		}
		throw new IllegalArgumentException("[ERROR] 입력한 기능 선택 번호가 올바른 입력(1, 2, 3, Q)가 아니다.");
	}
}

