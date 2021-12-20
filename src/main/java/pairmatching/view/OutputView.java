package pairmatching.view;

import pairmatching.constant.Hint;
import pairmatching.domain.Mission;

public class OutputView {
	public static void printMatchInfo(Mission mission, String or) {
		if (mission == null) {
			System.out.println(or);
			return;
		}
		System.out.println(Hint.HINT_PAIR_MATCHING_RESULT.getHint());
		System.out.println(mission.toString());
	}

	public static void printCleared() {
		System.out.println(Hint.HINT_CLEARED.getHint());
	}
}
