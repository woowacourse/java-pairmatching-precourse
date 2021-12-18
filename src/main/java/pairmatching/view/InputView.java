package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.constant.Menu;

public class InputView {
	private final static String INPUT_FUNCTION_MESSAGE = "기능을 선택하세요.\n";

	public String getInputFunction() {
		printInputFunction();
		return Console.readLine();
	}

	private void printInputFunction() {
		StringBuilder message = new StringBuilder(INPUT_FUNCTION_MESSAGE);
		for (Menu function : Menu.values()) {
			message.append(function.getFunctionNumber())
				.append(". ")
				.append(function.getFunctionName())
				.append("\n");
		}
		System.out.print(message);
	}
}
