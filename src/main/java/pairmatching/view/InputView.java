package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class InputView {
	public static String inputOption(String... validValues) {
		String option = Console.readLine();
		validateOptionValue(option, validValues);
		return option;
	}

	public static String inputMatchingInformation() {
		String information = Console.readLine();
		validateInformation(information);
		return information;
	}

	private static void validateOptionValue(String value, String... validValues) {
		if (!Arrays.stream(validValues).anyMatch(v -> v.equals(value))) {
			throw new IllegalArgumentException("잘못된 기능입니다.");
		}
	}

	private static void validateInformation(String information) {
		if (!information.matches("[a-zA-Z0-9가-힣]+,\\s[a-zA-Z0-9가-힣]+,\\s[a-zA-Z0-9가-힣]+")) {
			throw new IllegalArgumentException("잘못된 매칭 정보입니다.");
		}
	}
}
