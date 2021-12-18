package pairmatching.exception;

public class SourceFormatException {

	static final String INCORRECT_SOURCE_FORMAT = "입력 형식이 맞지 않습니다.";

	public static void checkSourceFormat(String source) {
		String[] sourceSplitByComma = source.split(",");
		if (sourceSplitByComma.length != 3) {
			throw new IllegalArgumentException(INCORRECT_SOURCE_FORMAT);
		}
	}
}
