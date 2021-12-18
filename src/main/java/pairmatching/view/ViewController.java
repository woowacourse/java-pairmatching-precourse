package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.validator.InputValidator;

public class ViewController {
	private static final ViewController inputView = new ViewController();

	private final OutputView outputView;
	private final InputValidator inputValidator;

	private ViewController() {
		outputView = OutputView.getInstance();
		inputValidator = InputValidator.getInstance();
	}

	public static ViewController getInstance() {
		return inputView;
	}

	public String getFunctionSelection() {
		String userSelection;
		do {
			outputView.printFunctionSelectMessage();
			outputView.printFunctionOptions();
			userSelection = Console.readLine();
		} while (!inputValidator.checkFunctionSelection(userSelection));
		return userSelection;
	}
}
