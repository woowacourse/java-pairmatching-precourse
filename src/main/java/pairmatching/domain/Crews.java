package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.exception.CrewNotFoundException;

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

    public void addBackEndCrews(List<String> names) {
        addCrews(Course.BACKEND, names);
    }

    public void addFrontEndCrews(List<String> names) {
        addCrews(Course.FRONTEND, names);
    }

    public List<Crew> crews(Course course) {
        return crews.stream()
            .filter(crew -> crew.isEqualsCourse(course))
            .collect(Collectors.toList());
    }

    public Crew findCrew(String name, Course course) {
        Crew findCrew = new Crew(course, name);
        return crews.stream()
            .filter(crew -> crew.equals(findCrew))
            .findFirst()
            .orElseThrow(CrewNotFoundException::new);
    }

    public List<String> courseNames() {
        return crews.stream()
            .map(Crew::course)
            .map(Enum::name)
            .distinct()
            .collect(Collectors.toList());
    }
}
