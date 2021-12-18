package pairmatching.exception;

public class NotFoundMatchingException extends IllegalArgumentException {
	public NotFoundMatchingException() {
		super("[ERROR] 조히하려는 해당 매칭이 존재하지 않습니다. ");
	}
}
