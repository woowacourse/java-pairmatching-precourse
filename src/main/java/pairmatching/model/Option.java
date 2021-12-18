package pairmatching.model;

public enum Option {

	PAIR_MATCHING("1"),
	PAIR_SELECT("2"),
	PAIR_INITIALIZATION("3"),
	QUIT("Q");

	private final String value;

	Option(String value) {
		this.value = value;
	}

	public static void checkInput(String input) {

	}

	public String getValue() {
		return value;
	}
}
