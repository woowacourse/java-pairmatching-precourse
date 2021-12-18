package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.constant.Hint;

public class InputView {
	public static String inputFunctionNumber() {
		System.out.println(Hint.HINT_FUNCTION_SELECTION.getHint());
		return Console.readLine();
	}

	public static String inputMatchInfo() {
		System.out.println(Hint.HINT_MATCH_INFO_INPUT.getHint());
		return Console.readLine();
	}
}
