package pairmatching.controller;

import pairmatching.service.InputService;
import pairmatching.validator.MenuValidator;
import pairmatching.view.InputView;

public class MainController {
	public void inputMenu() {
		InputView.inputMainMenu();
		InputService.input(new MenuValidator());
	}
}
