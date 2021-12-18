package pairmatching.view;
import java.util.List;

import pairmatching.domain.pair.Pair;

public class OutputView {
	private static final String PRINT_PAIRS = "페어 매칭 결과입니다.";

	public static void printError(String errorMessage) {
		System.out.println(errorMessage);
	}

	public static void printPairs(List<Pair> pairs) {
		System.out.println(PRINT_PAIRS);
		pairs.forEach(pair -> System.out.println(pair.toString()));
	}
}
