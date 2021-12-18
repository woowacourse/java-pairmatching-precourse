package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Crews {

    private final List<Crew> crews;

    public Crews(List<Crew> crews) {
        this.crews = crews;
    }

    public static Crews init() {
        return new Crews(new ArrayList<>());
    }

    public void addCrews(Course course, List<String> names) {
        names.stream()
            .map(name -> new Crew(course, name))
            .forEach(crews::add);
    }

    public List<Crew> crews(Course course) {
        return crews.stream()
            .filter(crew -> crew.isEqualsCourse(course))
            .collect(Collectors.toList());
    }
}
