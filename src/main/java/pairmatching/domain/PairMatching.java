package pairmatching.domain;

import pairmatching.utils.Validator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PairMatching {
    List<PairListOfLevel> totalPairList;

    public PairMatching() {
        totalPairList = new ArrayList<>();
        totalPairList.add(new PairListOfLevel(Level.LEVEL1));
        totalPairList.add(new PairListOfLevel(Level.LEVEL2));
        totalPairList.add(new PairListOfLevel(Level.LEVEL3));
        totalPairList.add(new PairListOfLevel(Level.LEVEL4));
        totalPairList.add(new PairListOfLevel(Level.LEVEL5));
    }

    public Pair addPairInPairListOfLevel(String course, String level, String mission) throws IOException {
        Pair pair;
        int count = 0;
        do {
            Validator.ValidateMatchable(count);
            pair = new Pair(Course.getCourseByName(course), Mission.existMission(Level.getLevelByName(level), mission));
            count++;
        } while (!totalPairList.get(Integer.parseInt(level)).checkNotMatchedYet(pair));
        totalPairList.get(Integer.parseInt(level)).addPair(pair);
        return pair;
    }
}
