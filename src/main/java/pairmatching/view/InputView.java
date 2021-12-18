package pairmatching.view;

import pairmatching.Menu;

public class InputView {
	private static final String SELECT_FEATURE = "기능을 선택하세요.";

	public static void printChooseFeature() {
		System.out.println(SELECT_FEATURE);
		printMainMenuView();
	}

	private static void printMainMenuView() {
		for (Menu each : Menu.values()) {
			System.out.println(each.toString());
		}
	}
}
