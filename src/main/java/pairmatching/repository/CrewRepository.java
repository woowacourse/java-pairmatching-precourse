package pairmatching.repository;

import pairmatching.domain.Course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CrewRepository {
    private static final Map<Course, List<String>> crews = new HashMap<>();

    static {
        crews.put(Course.BACKEND, new ArrayList<>());
        crews.put(Course.FRONTEND, new ArrayList<>());
    }
    public static void save(Course course, String crewName) {
        List<String> crews = CrewRepository.crews.get(course);
        crews.add(crewName);
    }

    public static List<String> findAllByCourse(Course course) {
        return crews.get(course);
    }
}
