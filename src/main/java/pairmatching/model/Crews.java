package pairmatching.model;

import java.util.List;
import java.util.stream.Collectors;

public class Crews {
    private List<Crew> crews;

    private Crews(List<Crew> crews) {
        this.crews = crews;
    }

    public static Crews from(List<Crew> crews) {
        return new Crews(crews);
    }

    public List<Crew> getCrews() {
        return crews;
    }

    public List<String> getCrewNames() {
        return crews.stream().map(Crew::getName).collect(Collectors.toList());
    }
}
