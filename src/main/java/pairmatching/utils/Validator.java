package pairmatching.utils;

import java.util.Arrays;
import java.util.List;

public class Validator {
	public static void validateSelection(String userSelection) {
		List<String> validSelections = Arrays.asList("1", "2", "3", "Q");
		if (!validSelections.contains(userSelection)) {
			throw new IllegalArgumentException("[ERROR] 지정된 입력만 입력가능합니다.");
		}
	}
}
