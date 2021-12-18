package pairmatching.domain.course;

import java.util.Arrays;

import pairmatching.domain.course.enums.CourseEnum;

public class Course {
    private String courseName;

    public Course(String courseName) {
        validateCourseName(courseName);
        this.courseName = courseName;
    }

    private void validateCourseName(String courseName) {
        if (!existCourse()) {
            throw new IllegalArgumentException("존재하지 않는 코스입니다");
        }
    }

    private boolean existCourse() {
        return Arrays.stream(CourseEnum.values()).anyMatch(course -> course.getName().equals(courseName));
    }
}
