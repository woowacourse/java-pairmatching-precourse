package pairmatching.controller;

import static pairmatching.view.InputView.*;
import static pairmatching.view.OutputView.*;

import pairmatching.domain.Menu;
import pairmatching.validator.MenuValidator;
import pairmatching.validator.OrderValidator;

public class ViewController {

	public String returnOrder() {
		String order = getOrder();
		OrderValidator.checkOrder(order);
		return order;
	}

	public Menu returnMenu() {
		String menuInputString = getMenu();
		Menu menu = new Menu();
		try {
			menu = MenuValidator.checkAndCreateMenu(menuInputString);
		} catch (IllegalArgumentException exception) {
			printError(exception);
		}

		return menu;
	}

}
