package pairmatching.domain;

import pairmatching.domain.match.MatchData;

import java.util.ArrayList;
import java.util.List;

public class MissionPair {

    private MatchData matchData;
    private List<List<Crew>> missionPair;

    public MissionPair(MatchData matchData) {
        this.matchData = matchData;
        missionPair = new ArrayList<>();
    }

    public void addPair(List<Crew> pair) {
        missionPair.add(pair);
    }

    public List<List<Crew>> getMissionPair() {
        return missionPair;
    }
}
