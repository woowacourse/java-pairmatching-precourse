package pairmatching.controller;

import static pairmatching.Constants.*;

import pairmatching.service.InputService;
import pairmatching.validator.MenuValidator;
import pairmatching.view.InputView;

public class MainController {
	public void inputMenu() {
		String menu;
		do {
			InputView.inputMainMenu();
			menu = InputService.input(new MenuValidator());
			executeMenu(menu);
		} while (!menu.equals(QUIT));
	}

	private void executeMenu(String menu) {
		MatchingController controller = new MatchingController();
		if (menu.equals(MAKE_PAIR)) {
			controller.pairMatching();
		} else if (menu.equals(SEARCH_PAIR)) {
			controller.searchMatch();
		} else if (menu.equals(CLEAR_PAIR)) {
			controller.clearMatch();
		}
	}
}
