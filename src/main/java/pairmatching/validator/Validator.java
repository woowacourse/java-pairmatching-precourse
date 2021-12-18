package pairmatching.validator;

import java.util.ArrayList;
import pairmatching.type.PairMatchingType;
import pairmatching.error.FunctionError;

import static pairmatching.view.Print.*;

public class Validator {
	private static void throwError(String errorMessage) {
		throw new IllegalArgumentException(errorMessage);
	}

	public static boolean isValidatedFunction(String input) {
		try {
			validateFunction(input, FunctionError.NOT_PROPER_VALUE.getError());
		} catch (IllegalArgumentException error) {
			printErrorMessage(error);
			return false;
		}
		return true;
	}

	private static void validateFunction(String input, String errorMessage) {
		ArrayList<String> properNumberValue = new ArrayList<>();
		properNumberValue.add(String.valueOf(PairMatchingType.MATCH.getNumber()));
		properNumberValue.add(String.valueOf(PairMatchingType.VIEW.getNumber()));
		properNumberValue.add(String.valueOf(PairMatchingType.RESET.getNumber()));
		properNumberValue.add(String.valueOf(PairMatchingType.QUIT.getString()));

		if (!properNumberValue.contains(input)) {
			throwError(errorMessage);
		}
	}
}
