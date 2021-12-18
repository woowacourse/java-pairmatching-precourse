package pairmatching.view;

import pairmatching.common.MainCategory;

public class OutputView {
	private static final String SELECT_MAIN_OPTION = "기능을 선택하세요.";
	private static final String CONNECTION = " - ";

	public void printError(String error) {
		System.out.println(error);
	}

	public void printMenus() {
		System.out.println(SELECT_MAIN_OPTION);
		for (MainCategory category : MainCategory.values()) {
			System.out.println(category.getCategory() + CONNECTION + category.getDescription());
		}
	}
}
