package pairmatching.exception;


public class MatchingTypeInputException extends CustomException {

	static final String MATCHING_TYPE_INPUT_EXCEPTION_MSG = "[ERROR] 매칭 타입 입력값이 올바르지 않습니다.";
	public MatchingTypeInputException() {
		getMessage(MATCHING_TYPE_INPUT_EXCEPTION_MSG);
	}

	@Override
	public void getMessage(String message) {
		System.out.println(message);
	}
}
