package pairmatching.domain;

import java.util.Arrays;
import java.util.List;

public class Menu {

	private static final List<String> MENU = Arrays.asList("1", "2", "3", "Q");
	private static final String ERROR_MESSAGE_INVALID_INPUT_MENU = "선택하신 기능은 없는 기능입니다.";

	private String menu;

	public Menu(String inputMenu) {
		validateInputMenu(inputMenu);
		this.menu = inputMenu;
	}

	private void validateInputMenu(String inputMenu) {
		if (!MENU.contains(inputMenu)) {
			throw new IllegalArgumentException(ERROR_MESSAGE_INVALID_INPUT_MENU);
		}
	}

	public boolean isFinish() {
		return menu.equals("Q");
	}
}
