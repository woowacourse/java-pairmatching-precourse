package pairmatching.global.exception;

public enum ErrorMessage {
	NO_MATCHING_HISTORY("매칭 이력이 없습니다."),
	BLANK_INPUT_ERROR("빈 문자열이 입력되었습니다."),
	INVALID_PAIR_REQUEST("과정, 레벨, 미션을 다시 입력해주세요."),
	INVALID_REMATCH_REQUEST("네 혹은 아니오를 입력해주세요."),
	CANNOT_MATCHING_ERROR("페어 매칭에 실패하였습니다."),
	INVALID_FUNCTION_REQUEST("잘못된 기능 번호를 입력하였습니다.");
	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}
