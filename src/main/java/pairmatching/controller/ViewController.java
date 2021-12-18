package pairmatching.controller;

import static pairmatching.view.InputView.*;
import static pairmatching.view.OutputView.*;

import pairmatching.domain.Menu;
import pairmatching.domain.Order;
import pairmatching.validator.MenuValidator;

public class ViewController {

	public Order returnOrder() {
		String orderInputString = getOrder();
		Order order = null;
		try {
			order = Order.of(orderInputString);
		} catch (IllegalArgumentException exception) {
			printError(exception);
			return returnOrder();
		}
		return order;
	}

	public Menu returnMenu() {
		String menuInputString = getMenu();
		Menu menu = new Menu();
		try {
			menu = MenuValidator.checkAndCreateMenu(menuInputString);
		} catch (IllegalArgumentException exception) {
			printError(exception);
			return returnMenu();
		}

		return menu;
	}

}
