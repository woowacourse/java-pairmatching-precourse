package pairmatching.controller;

import pairmatching.domain.Manager;
import pairmatching.domain.MatchInfo;
import pairmatching.domain.Pair;
import pairmatching.validator.InputValidator;
import pairmatching.view.PairMatchingView;

public class PairMatchingController {
	private static PairMatchingView view = new PairMatchingView();
	private MatchInfo matchInfo;
	private Manager manager = new Manager();
	private static InputValidator inputValidator = new InputValidator();

	public void selectMenu() {
		while (true) {
			String selection = view.inputMenu();
			if(!inputValidator.isValidNumber(selection)){
				continue;
			}
			if (selection.equals("1")) {
				matching();
			}
			if (selection.equals("2")) {
				search();
			}
			if (selection.equals("3")) {
				reset();
			}
			if (selection.equals("Q")) {
				break;
			}
		}
	}

	public void matching() {
		view.printInfo();
		while (true) {
			String select = view.selectDetail();
			select.replace(" ", "");
			String[] selects = select.split(",");
			if(validateDetail(selects)){
				continue;
			}
			if (manager.isDuplication(selects)) {
				String choice = view.selectRematching();
				if (choice.equals("아니오")) {
					continue;
				}
				if (choice.equals("네")) {
					MatchInfo matchInfo = manager.find(selects);
					manager.rematch(matchInfo);
					view.printPair(matchInfo.getPairList());
					break;
				}
			}
			if (!manager.isDuplication(selects)) {
				manager.setDetail(selects);
				MatchInfo matchInfo = manager.find(selects);
				view.printPair(matchInfo.getPairList());
				break;
			}
		}
	}

	private boolean validateDetail(String[] selects){
		if(inputValidator.isValidInfo(selects)){
			return true;
		}
		return false;
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

	public void reset() {
		manager.resetAllPair();
	}

}
