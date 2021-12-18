package pairmatching.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Menu {
	MATCHING_PAIR("1"),
	CHECKING_PAIR_RESULT("2"),
	CLEAR_PAIR("3"),
	QUIT("Q");

	public static final String NOT_MENU_EXIST = "해당하는 메뉴가 존재하지 않습니다.";
	private final String category;

	Menu(String category) {
		this.category = category;
	}

	public static Menu create(String choice) {
		return Arrays.stream(values())
			.filter(menu -> menu.is(choice))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(NOT_MENU_EXIST));
	}

	public boolean isMatchingPair() {
		return this == MATCHING_PAIR;
	}

	public boolean isQuit() {
		return this == QUIT;
	}

	public boolean isClearPair() {
		return this == CLEAR_PAIR;
	}

	public boolean isCheckingPairResult() {
		return this == CHECKING_PAIR_RESULT;
	}

	private boolean is(String choice) {
		return this.category.equals(choice);
	}

	public String getCategory() {
		return category;
	}

	public static boolean contains(String category) {
		return Menu.getCategories().contains(category);
	}

	private static List<String> getCategories() {
		return Arrays.stream(values())
			.map(Menu::getCategory)
			.collect(Collectors.toList());
	}

}
