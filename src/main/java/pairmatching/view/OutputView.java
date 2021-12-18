package pairmatching.view;

import java.util.List;

import pairmatching.domain.Pair;
import pairmatching.domain.PairMatch;

public class OutputView {

	public static final String OUTPUT_MATCHING_RESULT = "페어 매칭 결과입니다.";

	public static void outputPairMatchingResult(PairMatch pairMatch) {
		System.out.println(OUTPUT_MATCHING_RESULT);
		List<Pair> pairs = pairMatch.getPairs();
		for (Pair pair : pairs) {
			System.out.println(pair);
		}
		System.out.println();
	}
}
