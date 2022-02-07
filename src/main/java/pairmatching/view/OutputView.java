package pairmatching.view;

import pairmatching.domain.Pairs;

public class OutputView {
	public static final String RESULT_PAIRS = "페어 매칭 결과입니다.";
	public static final String RESET = "초기화 되었습니다.";

	public static void printPairs(Pairs pairs) {
		System.out.println(RESULT_PAIRS);
		System.out.println(pairs);
		printBreak();
	}

	public static void printReset() {
		System.out.println(RESET);
		printBreak();
	}

	public static void printError(String message) {
		System.out.println("[ERROR] " + message);
		printBreak();
	}

	public static void printBreak() {
		System.out.println();
	}
}
