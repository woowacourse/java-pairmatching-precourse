package pairmatching.controller;

import pairmatching.domain.Manager;
import pairmatching.domain.MatchInfo;
import pairmatching.domain.Pair;
import pairmatching.view.PairMatchingView;

public class PairMatchingController {
	private static PairMatchingView view = new PairMatchingView();
	private MatchInfo matchInfo;
	private Manager manager = new Manager();

	public void selectMenu() {
		String selection = view.inputMenu();
		if (selection.equals("1")) {
			matching();
		}
		if (selection.equals("2")) {
			search();
		}
	}

	public void matching() {
		view.printInfo();
		while (true) {
			String select = view.selectDetail();
			select.replace(" ", "");
			String[] selects = select.split(",");
			if (manager.isDuplication(selects)) {
				String choice = view.selectRematching();
				if (choice.equals("아니오")) {
					continue;
				}
			}
			if (manager.setDetail(selects)) {
				break;
			}
		}
	}

	public void search() {
		view.printInfo();
		String select = view.selectDetail();
		select.replace(" ", "");
		String[] selects = select.split(",");
		MatchInfo matchInfo = manager.find(selects);
		if (matchInfo == null) {
			return;
		}
		if (matchInfo != null) {
			view.printPair(matchInfo.getPairList());
		}
	}

}
