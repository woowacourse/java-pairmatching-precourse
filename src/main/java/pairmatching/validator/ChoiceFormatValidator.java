package pairmatching.validator;

import java.util.Arrays;
import java.util.List;

import pairmatching.util.ErrorMessage;

public class ChoiceFormatValidator {
	public static String isValidChoice(String input) {
		List<String> choices = Arrays.asList("1", "2", "3", "Q");
		if (!(choices.contains(input))) {
			throw new IllegalArgumentException(ErrorMessage.IS_NOT_VALID_CHOICE);
		}
		return input;
	}
}
