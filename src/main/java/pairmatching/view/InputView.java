package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class InputView {
	public static String inputOption(String... validValues) {
		String option = Console.readLine();
		validateOptionValue(option, validValues);
		return option;
	}

	private static void validateOptionValue(String value, String... validValues) {
		if (!Arrays.stream(validValues).anyMatch(v -> v.equals(value))) {
			throw new IllegalArgumentException("잘못된 기능입니다.");
		}
	}
}
