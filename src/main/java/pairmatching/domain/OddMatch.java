package pairmatching.domain;

public class OddMatch extends Match {

    private final Crew thirdCrew;

    public OddMatch(Crew firstCrew, Crew secondCrew, Crew thirdCrew) {
        super(firstCrew, secondCrew);
        this.thirdCrew = thirdCrew;
    }

    @Override
    public boolean isSameMatch(Match match) {
        return super.isSameMatch(match) && match.containCrew(thirdCrew);
    }
}
