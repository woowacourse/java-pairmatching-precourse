package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.utils.FunctionValidator;

public class InputView {

	public static String requestFunction() {
		try {
			OutputView.printMainScreen();
			String inputValue = Console.readLine();
			FunctionValidator.validateFunction(inputValue);
			return inputValue;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return requestFunction();
		}
	}

	public static void requestMission() {
		try {
			OutputView.printPairScreen();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return;
		}
	}

}
