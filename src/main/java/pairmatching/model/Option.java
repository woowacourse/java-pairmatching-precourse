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

	public static String checkInput(String input) {

		for (Option option : values()) {

			if (option.value.equals(input)) {
				return input;
			}

		}

		throw new IllegalArgumentException("없는 옵션입니다.");
	}

	public String getValue() {
		return value;
	}
}
