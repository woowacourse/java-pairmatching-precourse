package pairmatching.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import pairmatching.domain.Pair;
import pairmatching.domain.Pairs;
import pairmatching.view.console.ConsoleWriter;

public final class PairResponseView {
	private static final String NOTICE = "페어 매칭 결과입니다.";
	private static final String COUPLE_PAIR_RESPONSE = "%s : %s";
	private static final String TRIPLE_PAIR_RESPONSE = "%s : %s : %s";

	public static void response(Pairs pairs) {
		ConsoleWriter.printlnMessage(NOTICE);
		printPairs(pairs);
	}

	private static void printPairs(Pairs pairs) {
		for (Pair pair : pairs.getPairs()) {
			printPair(pair);
		}
	}

	private static void printPair(Pair pair) {
		List<String> names = getNames(pair.getPair());
		if (names.size() == 2) { // 수정
			ConsoleWriter.printlnFormat(
				COUPLE_PAIR_RESPONSE,
				names.get(0),
				names.get(1)
			);
			return;
		}
		if (names.size() == 3) {
			ConsoleWriter.printlnFormat(
				TRIPLE_PAIR_RESPONSE,
				names.get(0),
				names.get(1),
				names.get(2)
			);
		}

		throw new IllegalStateException("페어에 속한 크루의 수가 2 혹은 3이 아닙니다.");
	}

	private static List<String> getNames(Set<String> crews) {
		List<String> names = new ArrayList<>();
		for (String crew : crews) {
			names.add(crew);
		}
		return names;
	}
}
