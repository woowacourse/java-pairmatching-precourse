package pairmatching.domain;

import java.util.Arrays;

public enum Rematching {
	YES("네"),
	NO("아니오");

	private final String selectedMenu;

	Rematching(String selectedMenu) {
		this.selectedMenu = selectedMenu;
	}

	public static Rematching findBySelectedMenu(String selectedMenu) {
		return Arrays.stream(Rematching.values())
			.filter(e -> e.selectedMenu.equals(selectedMenu))
			.findAny()
			.orElseThrow(IllegalArgumentException::new);
	}
}
