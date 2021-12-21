package pairmatching.domain.crew;

import java.util.HashMap;
import java.util.List;

import pairmatching.domain.ErrorMessage;
import pairmatching.domain.course.Course;

public class CrewRepository {
    public static final String CREWREPO_ERROR_ACCESS_WHEN_EMPTY = "크루의 데이터베이스가 생성되지 않았습니다.";

    private final static HashMap<Course, List<Crew>> crewListPerCourse = new HashMap<>();

    public static List<Crew> getCrewsOfCourse(Course course) {
        return crewListPerCourse.get(course);
    }

    public static void initialize() {
        prepareCrewListPerCourse();
    }

    public static void deleteAll() {
        crewListPerCourse.clear();
    }

    public static void checkCrewRepoIsEmpty() {
        if (crewListPerCourse.size() == 0) {
            throw new IllegalArgumentException(ErrorMessage.makeErrorMessage(
                CREWREPO_ERROR_ACCESS_WHEN_EMPTY));
        }
    }

    private static void prepareCrewListPerCourse() {
        CrewReader crewReader = new CrewReader();
        crewListPerCourse.clear();
        for (Course course : Course.values()) {
            crewListPerCourse.put(course, crewReader.readCrewOfCourse(course));
        }
    }
}
