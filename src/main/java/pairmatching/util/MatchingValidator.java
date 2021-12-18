package pairmatching.util;

import java.util.Arrays;

import pairmatching.view.ErrorMessage;

public class MatchingValidator {
	public static void validateInputForm(String inputString) {
		Arrays.asList("네", "아니오").stream()
			.filter(answer -> answer.equals(inputString))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_REMATCH_INPUT));
	}
}
