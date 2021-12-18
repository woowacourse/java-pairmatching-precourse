package pairmatching.view;

import static pairmatching.view.ViewConstants.*;

import java.util.List;

import pairmatching.domain.Match;
import pairmatching.domain.Pair;

public class OutputView {
	public static void errorView(String message) {
		System.out.println(ERROR + message);
	}

	public static void matchView(Match match) {
		System.out.println("페어 매칭 결과입니다.");
		List<Pair> pairList = match.getPairList();
		for (Pair pair : pairList) {
			System.out.println(pair);
		}
	}
}
