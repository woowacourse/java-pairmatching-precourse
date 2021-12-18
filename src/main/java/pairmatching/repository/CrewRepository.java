package pairmatching.repository;

import pairmatching.model.Course;
import pairmatching.model.Crew;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CrewRepository {
    private static final List<Crew> crews = new ArrayList<>();

    public static List<Crew> crews() {
        return Collections.unmodifiableList(crews);
    }

    public static void addCrew(Crew crew) {
        crews.add(crew);
    }

    public static List<String> getCrewNamesByCourse(Course course) {
        return crews.stream()
                .filter(crew -> crew.getCourse().equals(course))
                .map(Crew::getName)
                .collect(Collectors.toList());
    }

    public static Crew findByName(String name) {
        return crews.stream()
                .filter(crew -> crew.getName().equals(name))
                .findAny()
                .orElse(null);
    }
}
