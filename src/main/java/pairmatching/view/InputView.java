package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import pairmatching.utils.exception.InputException;

public class InputView {

	private static final String INFORMATION_DELIMITER = ", ";

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

	public static List<String> selectInformation() {
		OutputView.askInformation();
		try {
			String information = Console.readLine();
			List<String> filteredInformation = Arrays.asList(
				information.split(INFORMATION_DELIMITER));
			InputException.validateInformation(filteredInformation);
			return filteredInformation;
		} catch (IllegalArgumentException IAE) {
			OutputView.printError(IAE);
			return selectInformation();
		}
	}
}
