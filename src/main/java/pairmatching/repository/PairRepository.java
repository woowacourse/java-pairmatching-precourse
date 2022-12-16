package pairmatching.repository;

import pairmatching.domain.MissionPair;

import java.util.ArrayList;
import java.util.List;

public class PairRepository {

    private static List<MissionPair> missionPairDB = new ArrayList<>();

    public void addMissionPair(MissionPair pair) {
        missionPairDB.add(pair);
        printMissionPairs();
    }
    
    public void printMissionPairs() {
        missionPairDB.forEach(missionPair -> {
            missionPair.getMissionPair().forEach(crew -> {
                System.out.println("crew.toString() = " + crew.toString());
            });
        });
    }

}
