package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import pairmatching.utils.exception.InputException;

public class InputView {

	private InputView() {
	}

	public static String selectFunction(List<String> functions) {
		OutputView.askFunction(functions);
		try {
			String number = Console.readLine();
			InputException.validateFunctionNumber(number, functions);
			return number;
		} catch (IllegalArgumentException IAE) {
			OutputView.printError(IAE);
			return selectFunction(functions);
		}
	}

	public static String selectInformation() {
		OutputView.askInformation();
		try {
			String information = Console.readLine();
			InputException.validateInformation(information);
			return information;
		} catch (IllegalArgumentException IAE) {
			OutputView.printError(IAE);
			return selectInformation();
		}
	}
}
