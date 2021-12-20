package pairmatching.domain.crew;

import java.util.HashMap;
import java.util.List;

import pairmatching.domain.course.Course;

public class CrewRepository {
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

    private static void prepareCrewListPerCourse() {
        CrewReader crewReader = new CrewReader();
        crewListPerCourse.clear();
        for(Course course :Course.values()) {
            crewListPerCourse.put(course, crewReader.readCrewOfCourse(course));
        }
    }
}
