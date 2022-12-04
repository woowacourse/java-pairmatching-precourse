package pairmatching.repository;

import pairmatching.model.Course;
import pairmatching.model.Crew;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CrewRepository {
    private final List<Crew> crews = new ArrayList<>();

    public void saveAll(List<Crew> crews) {
        this.crews.addAll(crews);
    }

    public List<Crew> findByCourse(Course course) {
        return crews.stream()
                .filter(crew -> crew.getCourse() == course)
                .collect(Collectors.toList());
    }
}
