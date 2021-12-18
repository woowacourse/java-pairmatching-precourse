package pairmatching.domain;

import java.util.List;

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

    @Override
    public List<String> crewNames() {
        List<String> names = super.crewNames();
        names.add(thirdCrew.name());
        return names;
    }
}
