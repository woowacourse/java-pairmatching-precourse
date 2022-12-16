package pairmatching.repository;

import pairmatching.domain.MissionPair;

import java.util.ArrayList;
import java.util.List;

public class PairRepository {

    private static List<MissionPair> missionPairDB = new ArrayList<>();

    public MissionPair addMissionPair(MissionPair pair) {
        missionPairDB.add(pair);
        return pair;
    }

}
