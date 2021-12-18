package pairmatching.view.input;

public enum Delimiter {

	SQUARE_BRACKET_LEFT("["),
	SQUARE_BRACKET_RIGHT("]"),
	SEMI_COLON(";"),
	COMMA(","),
	EMPTY(""),
	SPACE(" ");

	private final String value;

	Delimiter(String value) {
		this.value = value;
	}

	public static boolean isEmpty(String targetString) {
		return targetString.equals(EMPTY.value);
	}

	public static String[] splitWithSemiColon(String targetString) {
		return targetString.split(SEMI_COLON.value);
	}

	public static String[] splitWithComma(String targetString) {
		return targetString.split(COMMA.value);
	}

	public static String appendSpaceBehind(String targetString) {
		return targetString + SPACE.value;
	}

	public static boolean isEnclosedInSquareBracket(String targetString) {
		return (isStartWithLeftBracket(targetString) && isEndWithRightBracket(targetString));
	}

	public static boolean isNotEnclosedInSquareBracket(String targetString) {
		return !isEnclosedInSquareBracket(targetString);
	}

	private static boolean isStartWithLeftBracket(String targetString) {
		return (targetString.charAt(0) == SQUARE_BRACKET_LEFT.value.charAt(0));
	}

	private static boolean isEndWithRightBracket(String targetString) {
		return (targetString.charAt(targetString.length() - 1) == SQUARE_BRACKET_RIGHT.value.charAt(0));
	}

}
