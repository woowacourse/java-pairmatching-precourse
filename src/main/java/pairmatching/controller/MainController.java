package pairmatching.controller;

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
		}while (!menu.equals("Q"));
	}

	private void executeMenu(String menu) {
		MatchingController controller = new MatchingController();
		if (menu.equals("1")) {
			controller.pairMatching();
		} else if (menu.equals("2")) {
			controller.searchMatch();
		} else if (menu.equals("3")) {
			controller.clearMatch();
		}
	}
}
