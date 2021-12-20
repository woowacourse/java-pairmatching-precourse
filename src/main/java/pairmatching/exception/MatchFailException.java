package pairmatching.exception;

public class MatchFailException extends RuntimeException {
	public MatchFailException(String detailMessage) {
		super(detailMessage);
	}
}
