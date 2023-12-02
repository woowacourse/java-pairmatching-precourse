package pairmatching.view;

import pairmatching.global.exception.CustomException;
import pairmatching.global.exception.ErrorMessage;
import pairmatching.view.console.ConsoleReader;
import pairmatching.view.console.ConsoleWriter;

public final class RematchRequestView {
	private static final String NOTICE = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?";
	private static final String EXAMPLE_RESPONSE = "네 | 아니오";
	private static final String YES = "네";
	private static final String NO = "아니오";

	public static boolean request() {
		ConsoleWriter.printlnMessage(NOTICE);
		ConsoleWriter.printlnMessage(EXAMPLE_RESPONSE);
		return validate(ConsoleReader.enterMessage());
	}

	private static boolean validate(String input) {
		if (input == YES) {
			return true;
		}
		if (input == NO) {
			return false;
		}
		throw CustomException.from(ErrorMessage.INVALID_REMATCH_REQUEST);
	}
}
