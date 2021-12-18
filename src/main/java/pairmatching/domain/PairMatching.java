package pairmatching.domain;

import pairmatching.utils.Validator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PairMatching {
    List<PairListOfLevel> totalPairList;

    public PairMatching() {
        initialize();
    }

    public Pair addPairInPairListOfLevel(String course, String level, String mission) {
        Pair pair;
        int count = 0;
        Level levelValue = Level.getLevelByName(level);
        do {
            Validator.ValidateMatchable(count);
            pair = new Pair(Course.getCourseByName(course), Mission.existMission(Level.getLevelByName(level), mission));
            count++;
        } while (!totalPairList.get(levelValue.ordinal()).checkNotMatchedYet(pair));
        totalPairList.get(levelValue.ordinal()).addPair(pair);
        return pair;
    }
    public Pair getPairResult(String course, String level, String mission) {
        Level levelValue = Level.getLevelByName(level);
        return totalPairList.get(levelValue.ordinal()).getPair(Course.getCourseByName(course),
                Mission.existMission(levelValue, mission));
    }

    public void initialize() {
        totalPairList = new ArrayList<>();
        totalPairList.add(new PairListOfLevel(Level.LEVEL1));
        totalPairList.add(new PairListOfLevel(Level.LEVEL2));
        totalPairList.add(new PairListOfLevel(Level.LEVEL3));
        totalPairList.add(new PairListOfLevel(Level.LEVEL4));
        totalPairList.add(new PairListOfLevel(Level.LEVEL5));
    }
}
