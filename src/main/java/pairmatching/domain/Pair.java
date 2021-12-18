package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Pair {
    private final List<Crew> crews;

    public Pair(List<Crew> crews) {
        this.crews = new ArrayList<>(crews);
    }

    public boolean containsCrew(Pair pair) {
        return this.crews.containsAll(pair.crews);
    }

    public List<String> getCrewNames() {
        List<String> crewNames = new ArrayList<>();
        for (Crew crew : crews) {
            crewNames.add(String.valueOf(crew.getName()));
        }

        return crewNames;
    }
}