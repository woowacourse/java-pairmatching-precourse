package pairmatching.validator;

import static pairmatching.constants.ErrorMessages.*;
import static pairmatching.constants.ProgramConstants.*;

import java.util.Objects;

public class InputValidator {
	private static final InputValidator inputValidator = new InputValidator();

	private InputValidator() {}

	public static InputValidator getInstance() {
		return inputValidator;
	}

	public boolean checkFunctionSelection(String userSelection) {
		try {
			checkSelectionsInOptions(userSelection);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	public void checkSelectionsInOptions(String userSelection) {
		if (FUNCTION_OPTIONS.stream().noneMatch(option -> Objects.equals(option, userSelection))) {
			throw new IllegalArgumentException(SELECTION_DONT_IN_OPTIONS_ERROR);
		}
	}

	public boolean checkTargetSelection(String userSelection) {
		try {
			checkSelectThreeCategory(userSelection);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	private void checkSelectThreeCategory(String userSelection) {
		if (userSelection.split(",").length != 3) {
			throw new IllegalArgumentException(NOT_SELECT_ALL_ITEM_ERROR);
		}
	}
}
