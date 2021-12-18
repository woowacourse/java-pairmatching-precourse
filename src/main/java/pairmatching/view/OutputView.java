package pairmatching.view;

import pairmatching.domain.Pair;
import pairmatching.domain.Pairs;

public class OutputView {
	private static final String ERROR_MESSAGE = "[ERROR] ";
	private static final String COLON = " : ";
	private static final String LINE_SEPARATOR = System.lineSeparator();
	private static final String PAIR_MATCHING_RESULT = "페어 매칭 결과입니다.";
	private static final int FIRST_PAIR_INDEX = 0;

	public static void printMatchingResult(Pairs pairs) {
		System.out.println(PAIR_MATCHING_RESULT);
		StringBuilder builder = new StringBuilder();
		for (Pair pair : pairs.getPairs()) {
			builder.append(pair.getNames().get(FIRST_PAIR_INDEX));
			for (int i = 1; i < pair.getNames().size(); i++) {
				builder.append(COLON + pair.getNames().get(i));
			}
			builder.append(LINE_SEPARATOR);
		}

		System.out.println(builder);
	}

	public static void printErrorMessage(Exception e) {
		System.out.println(ERROR_MESSAGE + e.getMessage());
	}

	public static void printLineSeparator() {
		System.out.print(LINE_SEPARATOR);
	}
}
