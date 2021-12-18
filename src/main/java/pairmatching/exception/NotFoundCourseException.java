package pairmatching.exception;

public class NotFoundCourseException extends IllegalArgumentException {
	public NotFoundCourseException() {
		super("[ERROR] 해당하는 코스를 찾을 수 없습니다.");
	}
}
