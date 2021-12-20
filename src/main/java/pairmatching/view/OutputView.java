package pairmatching.view;

import pairmatching.constant.Hint;
import pairmatching.domain.Mission;

public class OutputView {
	public static void printMatchInfo(Mission mission){
		System.out.println(Hint.HINT_PAIR_MATCHING_RESULT.getHint());
		System.out.println(mission.toString());
	}
}
