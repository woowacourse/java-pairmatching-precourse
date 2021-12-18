package pairmatching.domain;

import java.util.Arrays;
import java.util.List;

public class Match {

    private final Crew firstCrew;
    private final Crew secondCrew;

    public Match(Crew firstCrew, Crew secondCrew) {
        this.firstCrew = firstCrew;
        this.secondCrew = secondCrew;
    }

    public boolean isSameMatch(Match match) {
        return match.containCrew(firstCrew) && match.containCrew(secondCrew);
    }

    boolean containCrew(Crew crew) {
        return firstCrew.equals(crew) || secondCrew.equals(crew);
    }

    public List<String> crewNames() {
        return Arrays.asList(firstCrew.name(), secondCrew.name());
    }
}
