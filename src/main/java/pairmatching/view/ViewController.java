package pairmatching.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

	public List<String> getTargetSelection() {
		String userSelection;
		do {
			outputView.printAllCourseOptions();
			outputView.printTargetSelectMessage();
			userSelection = Console.readLine();
		} while (!inputValidator.checkTargetSelection(userSelection));
		return trimAllElement(Arrays.asList(userSelection.split(",")));
	}

	private List<String> trimAllElement(List<String> userSelectionList) {
		return userSelectionList.stream()
				.map(String::trim)
				.collect(Collectors.toList());
	}
}
