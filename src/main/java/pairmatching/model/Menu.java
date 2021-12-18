package pairmatching.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Menu {
	MATCHING_PAIR("1"),
	CHECKING_PAIR_RESULT("2"),
	CLEAR_PAIR("3"),
	QUIT("Q");

	private final String category;

	Menu(String category) {
		this.category = category;
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
