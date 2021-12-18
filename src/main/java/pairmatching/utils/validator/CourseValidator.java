package pairmatching.utils.validator;

import static pairmatching.utils.Error.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.domain.Course;

public class CourseValidator {

    public static void validate(String course) {
        List<String> courseList = Arrays.stream(Course.values())
            .map(Course::getName)
            .collect(Collectors.toList());
        if (!courseList.contains(course)) {
            throw new IllegalArgumentException(COURSE_NOT_EXIST);
        }
    }
}
