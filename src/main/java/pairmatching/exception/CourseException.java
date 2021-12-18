package pairmatching.exception;

public class CourseException extends IllegalArgumentException {

	static final String NOT_FIND_COURSE = "입력하신 코스가 존재하지 않습니다.";

	public CourseException() {
		super(NOT_FIND_COURSE);
	}
}
