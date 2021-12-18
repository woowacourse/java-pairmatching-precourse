package pairmatching.exception;

import pairmatching.view.output.ErrorMessage;

public class CourseNotFoundException extends PairMatchingException {

	public CourseNotFoundException() {
		super(ErrorMessage.COURSE_NOT_FOUND_MESSAGE);
	}

}
