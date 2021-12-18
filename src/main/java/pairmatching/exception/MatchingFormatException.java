package pairmatching.exception;

import pairmatching.exception.CustomException;

public class MatchingFormatException extends CustomException {

	static final String MATCHING_TYPE_INPUT_EXCEPTION_MSG = "[ERROR] 매칭 타입 입력 포맷이 올바르지 않습니다.";
	public MatchingFormatException() {
		getMessage(MATCHING_TYPE_INPUT_EXCEPTION_MSG);
	}

	@Override
	public void getMessage(String message) {
		System.out.println(message);
	}
}
