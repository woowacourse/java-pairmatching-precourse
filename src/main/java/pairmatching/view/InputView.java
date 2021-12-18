package pairmatching.view;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String NEW_LINE = "\n";
	private static final String INPUT_OPTION_GUIDE = "기능을 선택하세요.";
	private static final String INPUT_MATCHING_OPTION_GUIDE
		= "과정, 레벨, 미션을 선택하세요.\n" + "ex) 백엔드, 레벨1, 자동차경주";
	private static final String INPUT_MATCHING_OPTION_AGAIN_GUIDE
		= "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n" + "네 | 아니오";

	public static String inputOption() {
		System.out.println(INPUT_OPTION_GUIDE);
		OutputView.displayMainView();
		String option = Console.readLine();

		try {
			return InputFormatValidator.validateOptionFormat(option);
		} catch (IllegalArgumentException e) {
			OutputView.displayErrorMsg(e.getMessage());
			return inputOption();
		}
	}

	public static List<String> inputMatchingOption() {
		System.out.println(NEW_LINE + INPUT_MATCHING_OPTION_GUIDE);
		String option = Console.readLine();

		try {
			return InputFormatValidator.validateMatchingOptionFormat(option);
		} catch (IllegalArgumentException e) {
			OutputView.displayErrorMsg(e.getMessage());
			return inputMatchingOption();
		}
	}

	public static String inputMatchingOptionAgain() {
		System.out.println(NEW_LINE + INPUT_MATCHING_OPTION_AGAIN_GUIDE);
		return Console.readLine();
	}
}
