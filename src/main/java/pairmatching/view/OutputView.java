package pairmatching.view;

import static pairmatching.Constants.*;

import java.util.List;

import pairmatching.domain.Match;
import pairmatching.domain.Pair;

public class OutputView {
	public static void errorView(String message) {
		System.out.println(ERROR + message);
	}

	public static void matchView(Match match) {
		System.out.println(MATCH_RESULT_MESSAGE);
		List<Pair> pairList = match.getPairList();
		for (Pair pair : pairList) {
			System.out.println(pair);
		}
	}

	public static void clearMatchView() {
		System.out.println(CLEAR_MESSAGE);
	}
}
