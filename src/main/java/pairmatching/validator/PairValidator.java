package pairmatching.validator;

import pairmatching.domain.Course;

public class PairValidator {

	private static final String INPUT_LENGTH_ERROR = "{ERROR] 과정, 레벨, 미션 3가지를 입력해야 합니다.";
	private static final String NO_EXIST_COURSE_ERROR = "{ERROR] 해당 과정이 존재하지 않습니다.";

	public void validateLength(String input) {
		if (input.split(", ").length != 3) {
			throw new IllegalArgumentException(INPUT_LENGTH_ERROR);
		}
	}

	public void validateCourse(Course course) {
		if (course == null) {
			throw new IllegalArgumentException(NO_EXIST_COURSE_ERROR);
		}
	}
}
