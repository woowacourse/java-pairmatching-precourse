package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String INPUT_OPTION_GUIDE = "기능을 선택하세요.";

	public static String inputOption() {
		System.out.println(INPUT_OPTION_GUIDE);
		String option = Console.readLine();

		try {
			return InputFormatValidator.validateOptionFormat(option);
		} catch (IllegalArgumentException e) {
			OutputView.displayErrorMsg(e.getMessage());
		}
		return inputOption();
	}
}
