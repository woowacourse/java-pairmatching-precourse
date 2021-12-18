package pairmatching.controller;

import pairmatching.view.InputView;

public class PairMatchingController {
	public void selectMenu() {
		try {
			String menu = InputView.getMenu();
			System.out.println(menu);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			selectMenu();
		}
	}
}
