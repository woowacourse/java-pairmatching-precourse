package pairmatching.controller;

import pairmatching.domain.MatchInfo;
import pairmatching.domain.Pair;
import pairmatching.view.PairMatchingView;

public class PairMatchingController {
	private static PairMatchingView view = new PairMatchingView();
	private MatchInfo matchInfo;

	public void selectMenu() {
		String selection = view.inputMenu();
		if (selection.equals("1")) {
			matching();
		}
	}

	public void matching() {
		String selection = view.selectDetail().replace(" ", "");
		String[] selections = selection.split(",");
		matchInfo = new MatchInfo(selections);
		matchInfo.match();
		view.printPair(matchInfo.getPairList());
	}
}
