package pairmatching.controller;

import pairmatching.model.Menu;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {

	public static void run() {
		OutputView.printMenu();
		Menu menu = InputView.selectMenu();

		while (isContinuable(menu)) {
			process(menu);

			OutputView.printMenu();
			menu = InputView.selectMenu();
		}

		OutputView.printBasicInfo();
	}

	private static void process(Menu menu) {
		if (menu.isMatchingPair()) {
			String inputInfo = InputView.inputInfoForPairMatching();
		}
	}

	private static boolean isContinuable(Menu menu) {
		return menu.isQuit();
	}
}
