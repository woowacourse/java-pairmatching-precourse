package pairmatching.domain;

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
}
