package pairmatching.view.input;

import java.util.List;

public enum Delimiter {

	SEMI_COLON(";"),
	COMMA(","),
	EMPTY(""),
	SPACE(" "),
	COLON(" : "),
	VERTICAL_LINE(" | "),
	NEW_LINE("\n");

	private final String value;

	Delimiter(String value) {
		this.value = value;
	}

	public static String[] splitWithComma(String targetString) {
		return targetString.split(COMMA.value);
	}

	public static String appendSpaceBehind(String targetString) {
		return targetString + SPACE.value;
	}

	public static String joinWithVerticalLine(List<String> values) {
		return String.join(VERTICAL_LINE.value, values);
	}

	public static String joinWithColon(List<String> values) {
		return String.join(COLON.value, values);
	}

	public static String getNewLine() {
		return NEW_LINE.value;
	}

}
