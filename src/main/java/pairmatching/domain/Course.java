package pairmatching.domain;

import static java.util.stream.Collectors.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.IOUtils;

public enum Course {
    BACKEND("백엔드", "/backend-crew.md"),
    FRONTEND("프론트엔드", "/frontend-crew.md");

    private final String name;
    private final String path;

    Course(final String name, final String path) {
        this.name = name;
        this.path = path;
    }

    public static Course parseCourse(String inputCourse) {
        return Arrays.stream(values())
            .filter(course -> course.getName().equals(inputCourse))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 코스입니다."));
    }

    public List<Crew> getCrewsByCourse(Course inputCourse) throws IOException {
        Course course = findCourse(inputCourse);

        String input = IOUtils.toString(getClass().getResourceAsStream(course.path), "UTF-8");
        List<String> names = getNames(input);

        return names.stream()
            .map(name -> new Crew(course, name))
            .collect(toList());
    }

    private Course findCourse(Course inputCourse) {
       return Arrays.stream(values())
            .filter(c -> c == inputCourse)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 코스입니다."));
    }

    private List<String> getNames(String input) {
        return Arrays.stream(input.split("\n", -1))
            .collect(toList());
    }

    public String getName() {
        return name;
    }
}