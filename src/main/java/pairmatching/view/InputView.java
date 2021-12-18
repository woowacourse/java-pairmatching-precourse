package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.model.Mission;

public class InputView {
	private InputView() {
	}

	public static String selectFunction() {
		OutputView.askSelectFunction();
		return Console.readLine();
	}

	public static Mission askSelectOption() {
		try {
			OutputView.askSelectOption();
			return new Mission(Console.readLine().split(","));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return askSelectOption();
		}

	}

}
