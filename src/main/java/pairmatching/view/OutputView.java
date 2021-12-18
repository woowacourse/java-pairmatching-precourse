package pairmatching.view;

import java.util.List;

import pairmatching.domain.Pair;
import pairmatching.domain.PairMatch;

public class OutputView {

	public static final String OUTPUT_MATCHING_RESULT = "페어 매칭 결과입니다.";
	public static final String OUTPUT_NO_MATCH_DATA = "매칭 정보가 존재하지 않습니다.\n";
	public static final String OUTPUT_CLEAR_PAIRS = "초기화 되었습니다. \n";

	public static void outputPairMatchingResult(PairMatch pairMatch) {
		if (pairMatch == null) {
			System.out.println(OUTPUT_NO_MATCH_DATA);
			return;
		}
		System.out.println(OUTPUT_MATCHING_RESULT);
		List<Pair> pairs = pairMatch.getPairs();
		for (Pair pair : pairs) {
			System.out.println(pair);
		}
		System.out.println();
	}

	public static void printClearMessage() {
		System.out.println(OUTPUT_CLEAR_PAIRS);
	}
}
