package pairmatching.view;

import java.util.List;

import pairmatching.domain.Pair;

public class OutputView {

	private static final String ERROR_FORM = "[ERROR] ";

	public static void printError(IllegalArgumentException exception) {
		System.out.println(ERROR_FORM + exception.getMessage() + "\n");
	}

	public static void printInitMessage() {
		System.out.println("\n초기화 되었습니다.\n");
	}

	public static void printMatching(List<Pair> pairs) {
		StringBuilder builder = new StringBuilder();
		builder.append("페어 매칭 결과입니다.");
		for (Pair pair : pairs) {
			builder.append(pair.toString())
				.append("\n");
		}

		System.out.println(builder.toString());
	}

}
