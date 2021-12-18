package pairmatching.domain.course;

import java.util.Arrays;
import java.util.Objects;

import pairmatching.domain.course.enums.CourseEnum;

public class Course {
    public static final String NON_EXIST_EXCEPTION = "[ERROR] 존재하지 않는 코스입니다";
    private String courseName;

    public Course(String courseName) {
        validateCourseName(courseName);
        this.courseName = courseName;
    }

    private void validateCourseName(String courseName) {
        if (!existCourse(courseName)) {
            throw new IllegalArgumentException(NON_EXIST_EXCEPTION);
        }
    }

    private boolean existCourse(String courseName) {
        return Arrays.stream(CourseEnum.values()).anyMatch(course -> course.getName().equals(courseName));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Course course = (Course)o;
        return Objects.equals(courseName, course.courseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseName);
    }

    @Override
    public String toString() {
        return "Course{" +
            "courseName='" + courseName + '\'' +
            '}';
    }
}
