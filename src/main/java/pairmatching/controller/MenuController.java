package pairmatching.controller;

import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.Menu;
import pairmatching.domain.MenuItem;
import pairmatching.util.Constants;
import pairmatching.util.ExceptionHandler;
import pairmatching.view.InputView;

public class MenuController {
	private Menu menu;
	private String selectedMenu;

	public void select() {
		init();
		selectedMenu = inputMenu();
	}

	private void init() {
		List<MenuItem> menuList = new ArrayList<>();
		menuList.add(new MenuItem(Constants.MENU_PAIR_MATCHING, "페어 매칭"));
		menuList.add(new MenuItem(Constants.MENU_PAIR_RETRIEVE, "페어 조회"));
		menuList.add(new MenuItem(Constants.MENU_PAIR_INITIALIZATION, "페어 초기화"));
		menuList.add(new MenuItem(Constants.MENU_EXIT, "종료"));
		menu = new Menu(menuList);
	}

	private String inputMenu() {
		String input;
		do {
			input = InputView.inputMenu(menu);
		} while (!validate(input));
		return input;
	}

	private boolean validate(String input) {
		boolean isValid = menu.validate(input);
		ExceptionHandler.handleInputError(isValid, Constants.ERROR_MESSAGE_INPUT_MENU);
		return isValid;
	}

	public boolean run() {
		if (selectedMenu.equals(Constants.MENU_PAIR_MATCHING)) {
			PairMatchingController pairMatchingController = new PairMatchingController();
			pairMatchingController.run();
		} else if (selectedMenu.equals(Constants.MENU_PAIR_RETRIEVE)) {
			PairRetrieveController pairRetrieveController = new PairRetrieveController();
			pairRetrieveController.run();
		}
		else if(selectedMenu.equals(Constants.MENU_PAIR_INITIALIZATION)) {
			PairMatchingController pairMatchingController = new PairMatchingController();
			pairMatchingController.removePairs();
		}
		else if (selectedMenu.equals(Constants.MENU_EXIT)) {
			return false;
		}
		return true;
	}
}
