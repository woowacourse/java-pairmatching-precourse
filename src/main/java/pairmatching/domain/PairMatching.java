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
        do {
            Validator.ValidateMatchable(count);
            pair = new Pair(Course.getCourseByName(course), Mission.existMission(Level.getLevelByName(level), mission));
            count++;
        } while (!totalPairList.get(Integer.parseInt(level)).checkNotMatchedYet(pair));
        totalPairList.get(Integer.parseInt(level)).addPair(pair);
        return pair;
    }
    public boolean checkIfPairResultAlreadyExist(String course, String level, String mission) {
        // 이미 존재하는 경우 true 반환
        return totalPairList.get(Integer.parseInt(level)).getPair(Course.getCourseByName(course),
                Mission.existMission(Level.getLevelByName(level), mission)) != null;
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
