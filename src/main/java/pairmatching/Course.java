package pairmatching;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드"),
    ;

    private String courseName;

    Course(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public static final List<String> CourseNameList = Arrays.stream(Course.values())
            .map(Course::getCourseName)
            .collect(Collectors.toList());

    public static final Map<String, String> COURSE_NAME_MAP = Collections.unmodifiableMap(
            Stream.of(values()).collect(Collectors.toMap(Course::getCourseName, Course::name))
    );

    public static Course of(final String courseName) {
        if (!CourseNameList.contains(courseName)) {
            throw new IllegalArgumentException("해당 이름의 코스가 없습니다.");
        }

        return Course.valueOf(COURSE_NAME_MAP.get(courseName));
    }
}
