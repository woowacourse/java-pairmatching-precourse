package pairmatching.controller;

import pairmatching.view.InputView;

public class MenuController {
	private static final String MATCHING = "1";
	private static final String VIEW = "2";
	private static final String CLEAR = "3";
	private static final String QUIT = "Q";

	private static final PairController pairController = new PairController();

	public void inputMainMenu() {
		String input = InputView.inputMainMenu();
		if (input.equals(MATCHING)) {
			pairController.startMatching();
		} else if (input.equals(VIEW)) {
			pairController.startView();
		} else if (input.equals(CLEAR)) {
			pairController.startClear();
		} else if (input.equals(QUIT)) {
			return;
		}

		// TODO: 해당하는 입력이 없으면 오류 출력
		inputMainMenu();
	}
}
