package pairmatching.domain;

public enum Menu {
	PAIR_MATCHING("1"),
	PAIR_SHOW("2"),
	PAIR_INIT("3"),
	QUIT("Q");

	private final String menu;

	Menu(final String menu) {
		this.menu = menu;
	}

	@Override
	public String toString() {
		return menu;
	}
}
