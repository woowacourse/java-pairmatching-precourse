package pairmatching.view;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	public static final String FUNCTION_MENUS = "123Q";
	public static final String MENU_DELIMITER = "";

	public static String getInput() {
		return Console.readLine();
	}

	public static String getFunctionMenu() {
		try {
			String inputValue = InputView.getInput();
			checkFunctionMenuValidation(inputValue);
			return inputValue.trim();
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return getFunctionMenu();
		}
	}

	private static void checkFunctionMenuValidation(String inputValue) {
		checkNullOrEmpty(inputValue);
		checkValidLengthOfFunctionMenu(inputValue);
		checkIsContainedFunctionMenu(inputValue);
	}

	private static void checkNullOrEmpty(String inputValue) {
		if (inputValue == null || inputValue.trim().isEmpty()) {
			throw new IllegalArgumentException("빈칸 입력은 허용하지 않는다.");
		}
	}

	private static void checkValidLengthOfFunctionMenu(String inputValue) {
		int inputValueLength = inputValue.length();
		if (!(1 == inputValueLength)) {
			throw new IllegalArgumentException(1 + "글자만 입력하세요.");
		}
		;
	}

	private static void checkIsContainedFunctionMenu(String inputValue) {
		if (!(Arrays.asList(FUNCTION_MENUS.split(MENU_DELIMITER)).contains(inputValue))) {
			throw new IllegalArgumentException("포함되지 않는 메뉴입니다.");
		}
	}

}
