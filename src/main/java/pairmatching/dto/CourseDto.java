package pairmatching.dto;

import pairmatching.domain.Course;

public class CourseDto {
    private final String name;

    public String getName() {
        return name;
    }

    public CourseDto(Course course) {
        this.name = course.toString();
    }
}
