package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Crews {
    private final List<Crew> crews;

    public Crews() {
        crews = new ArrayList<>();
    }

    public void addCrew(Crew crew) {
        crews.add(crew);
    }

    public List<Crew> getCrews() {
        return crews;
    }

    public List<String> getMatchingCrews(MatchingChoice matchingChoice) {
        return crews.stream()
                .filter(crew -> crew.takesSameCourse(matchingChoice.getCourse()))
                .map(Crew::getName)
                .collect(Collectors.toList());
    }
}
