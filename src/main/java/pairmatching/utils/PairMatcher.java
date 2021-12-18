package pairmatching.utils;

import java.util.ArrayList;
import java.util.List;

public class PairMatcher {

    public static List<List<String>> randomMatch(List<String> crewList) {
        List<String> shuffledCrewList = randomShuffle(crewList);
        List<List<String>> pairList = new ArrayList<>();
        int numOfCrews = shuffledCrewList.toArray().length;
        for (int i = 0; i * 2 < numOfCrews; i += 2) {
            List<String> pair = new ArrayList<String>();
            pair.add(shuffledCrewList.get(i));
            pair.add(shuffledCrewList.get(i + 1));
            pairList.add(pair);
        }

        if (numOfCrews % 2 == 1) {
            pairList.get(numOfCrews / 2).add(crewList.get(numOfCrews - 1));
        }

        return pairList;
    }

    public static List<String> randomShuffle(List<String> crewList) {
        camp.nextstep.edu.missionutils.Randoms.shuffle(crewList);
        return crewList;
    }
}
