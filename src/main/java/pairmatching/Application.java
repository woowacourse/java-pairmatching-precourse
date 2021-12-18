package pairmatching;

import java.util.Arrays;
import java.util.List;

public class Application {
	private static final String ERROR_INVALID_INPUT = "[ERROR] 잘못된 입력입니다.";
	private static boolean end = false;

	public static void main(String[] args) {
		while (!isEnd()) {
			try {
				InputView.printChooseOperation();
				PairMatcher matcher = new PairMatcher();
				chooseOperation(matcher);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private static boolean isEnd() {
		return end;
	}

	public static void chooseOperation(PairMatcher matcher) {
		String input = InputView.getInputToOperate();
		validUserInput(input);
		if (input.equals("1")) {
			matcher.pairMatching();
		}
		if (input.equals("2")) {
			matcher.pairQuery();
		}
		if (input.equals("3")) {
			matcher.pairInitiate();
		}
		if (input.equals("Q") || input.equals("q")) {
			end = true;
		}
	}

	private static void validUserInput(String input) {
		List<String> possibleInputs = Arrays.asList("1", "2", "3", "Q", "q");
		if (!possibleInputs.contains(input)) {
			throw new IllegalArgumentException(ERROR_INVALID_INPUT);
		}
	}
}
