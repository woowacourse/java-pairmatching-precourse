package pairmatching.exception;

public class CourseNotFoundException extends IllegalArgumentException {

    private static final String COURSE_NOT_FOUND_ERROR_MESSAGE = "[ERROR] 존재하지 않는 과정입니다.";

    public CourseNotFoundException() {
        super(COURSE_NOT_FOUND_ERROR_MESSAGE);
    }
}
