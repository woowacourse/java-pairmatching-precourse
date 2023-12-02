package pairmatching.view;

import java.util.Arrays;
import java.util.List;

import pairmatching.global.exception.CustomException;
import pairmatching.global.exception.ErrorMessage;
import pairmatching.view.console.ConsoleReader;
import pairmatching.view.console.ConsoleWriter;

public final class FunctionRequestView {
	private static final String NOTICE = "기능을 선택하세요.";
	private static final String RESPONSE_TYPE =
		"1. 페어 매칭\n"
			+ "2. 페어 조회\n"
			+ "3. 페어 초기화\n"
			+ "Q. 종료";
	private static final List<String> RESPONSES =
		Arrays.asList("1", "2", "3", "Q");

	public static String request() {
		ConsoleWriter.printlnMessage(NOTICE);
		ConsoleWriter.printlnMessage(RESPONSE_TYPE);
		return validate(ConsoleReader.enterMessage());
	}

	private static String validate(String enterMessage) {
		for (String response : RESPONSES) {
			if (response.equals(enterMessage)) {
				return enterMessage;
			}
		}
		throw CustomException.from(ErrorMessage.INVALID_FUNCTION_REQUEST);
	}
}
