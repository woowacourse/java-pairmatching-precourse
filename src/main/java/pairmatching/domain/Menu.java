package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	private final List<MenuItem> menuList;

	public Menu(List<MenuItem> menuList) {
		this.menuList = menuList;
	}

	@Override
	public String toString() {
		List<String> result = new ArrayList<>();
		menuList.forEach(item -> result.add(item.toString()));
		return String.join("\n", result);
	}

	public boolean validate(String input) {
		return menuList
			.stream()
			.anyMatch(menuItem -> menuItem.isSameNumber(input));
	}
}
