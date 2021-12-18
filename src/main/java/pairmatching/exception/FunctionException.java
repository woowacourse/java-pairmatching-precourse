package pairmatching.exception;

import static pairmatching.model.Function.*;

public class FunctionException {

	static final String INCORRECT_MSG = "잘못된 기능을 입력하셨습니다.";

	public static String checkCorrectFunction(String function) {
		if (!isCorrectFunction(function)) {
			throw new IllegalArgumentException(INCORRECT_MSG);
		}
		return function;
	}
}
