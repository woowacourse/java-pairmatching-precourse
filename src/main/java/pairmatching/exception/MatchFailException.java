package pairmatching.exception;

public class MatchFailException extends RuntimeException {
	public MatchFailException() {
		super("[ERROR] 크루를 가져오는 중 오류가 발생했습니다");
	}

	public MatchFailException(String detailMessage) {
		super("[ERROR] " + detailMessage);
	}
}
