package pairmatching.view;

import java.util.List;

import pairmatching.domain.Pair;
import pairmatching.domain.PairMatch;

public class OutputView {
	public static void outputPairMatchingResult(PairMatch pairMatch) {
		List<Pair> pairs = pairMatch.getPairs();
		for (Pair pair : pairs) {
			System.out.println(pair);
		}
	}
}
