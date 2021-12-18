package pairmatching.domain;

import java.util.Arrays;
import java.util.List;

public class Menu {

	private static final String PAIR_MATCHING = "1";
	private static final String FIND_PAIR = "2";
	private static final String INITIALIZE = "3";
	private static final String FINISH = "Q";
	private static final List<String> MENU = Arrays.asList(PAIR_MATCHING, FIND_PAIR, INITIALIZE, FINISH);
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
		return menu.equals(FINISH);
	}

	public boolean isPairMatching() {
		return menu.equals(PAIR_MATCHING);
	}

	public boolean isFindPair() {
		return menu.equals(FIND_PAIR);
	}

	public boolean isInitialize() {
		return menu.equals(INITIALIZE);
	}
}
