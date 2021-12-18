package pairmatching.matching;

import pairmatching.crew.Level;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pair {

    private Level level;
    private String mission;
    private List<String> crewNames;
    private String firstCrewName;
    private String secondCrewName;
    private String thirdCrewName = null;

    private Pair(){}

    public static Pair fromTwoCrewName(Level level, String mission, String firstCrewName, String secondCrewName) {
        Pair pair = new Pair();
        pair.level = level;
        pair.crewNames.add(firstCrewName);
        pair.crewNames.add(secondCrewName);
        return pair;
    }

    public void addThirdCrew(String thirdCrewName) {
        crewNames.add(thirdCrewName);
    }

    public boolean isSameLevel(Level level) {
        return this.level.equals(level);
    }

    public boolean isSameMission(String mission) {
        return this.mission.equals(mission);
    }

    public boolean isExistPair(Pair pair) {
        List<String> comparePairNames = pair.getAllCrewName();
        int count = 0;
        for(String name : comparePairNames) {
            if(crewNames.contains(name))
                count += 1;
        }
        return count > 2;
    }

    public List<String> getAllCrewName(){
        return crewNames;
    }
}
