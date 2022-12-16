package pairmatching.repository;

import pairmatching.domain.MissionPair;
import pairmatching.domain.match.MatchData;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PairRepository {

    private static List<MissionPair> missionPairDB = new ArrayList<>();

    public MissionPair addMissionPair(MissionPair pair) {
        missionPairDB.add(pair);
        return pair;
    }

    public Optional<MissionPair> findMissionPair(MatchData matchData) {
        return missionPairDB.stream()
                .filter(missionPair -> missionPair.getMatchData().getMission() == matchData.getMission())
                .filter(missionPair -> missionPair.getMatchData().getCourse() == matchData.getCourse())
                .findAny();
    }

}
