package pairmatching.exception;

import static pairmatching.constant.constant.*;

public class SourceFormatException {

	static final String INCORRECT_SOURCE_FORMAT = "입력 형식이 맞지 않습니다.";
	static final int CORRECT_LENGTH = 3;

	public static void checkSourceFormat(String source) {
		String[] sourceSplitByComma = source.split(COMMA);
		if (sourceSplitByComma.length != CORRECT_LENGTH) {
			throw new IllegalArgumentException(INCORRECT_SOURCE_FORMAT);
		}
	}
}
