package pairmatching.domain.course;

import pairmatching.domain.ErrorMessage;

public class CourseValidator {
    public void checkCourseName(String courseName) {
        for (Course course : Course.values()) {
            if (course.toString().equals(courseName)) {
                return;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.makeErrorMessage(
            "존재하지 않는 과정입니다. 다시 입력해주세요."));
    }
}
