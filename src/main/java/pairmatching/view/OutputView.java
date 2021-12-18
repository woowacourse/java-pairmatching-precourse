package pairmatching.view;

import static pairmatching.constant.message.SystemMessage.*;
import static pairmatching.validator.InputValidator.*;

import java.util.List;

import pairmatching.constant.message.SystemMessage;
import pairmatching.domain.Pair;
import pairmatching.domain.PairMatch;

public class OutputView {

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
