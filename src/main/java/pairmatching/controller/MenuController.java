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

	public void select() {
		init();
		inputMenu();
	}

	private void init() {
		List<MenuItem> menuList = new ArrayList<>();
		menuList.add(new MenuItem("1", "페어 매칭"));
		menuList.add(new MenuItem("2", "페어 조회"));
		menuList.add(new MenuItem("3", "페어 초기화"));
		menuList.add(new MenuItem("Q", "종료"));
		menu = new Menu(menuList);
	}

	private void inputMenu() {
		String input;
		do {
			input = InputView.inputMenu(menu);
		} while (!validateMenu(input));

	}

	private boolean validateMenu(String input) {
		boolean isValid = menu.validate(input);
		ExceptionHandler.handleInputError(isValid, Constants.ERROR_MESSAGE_INPUT_MENU);
		return isValid;
	}
}
