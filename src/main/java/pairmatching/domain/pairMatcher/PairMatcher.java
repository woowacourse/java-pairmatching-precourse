package pairmatching.domain.pairMatcher;

import pairmatching.domain.pairMatcher.enums.Course;
import pairmatching.domain.pairMatcher.enums.Level;

import java.util.List;

public class PairMatcher {
    CrewList crewList;
    PairList pairList;

    public void makePair(String info) {
        crewList = new CrewList(info);
        crewList.shuffleCrewList();
        List<String> shuffleCrewList = crewList.getShuffledCrewList();

        if (shuffleCrewList.size() % 2 == 0) {
            for (int i = 0; i < shuffleCrewList.size() - 1; i+=2) {
                pairList.addPair(new Pair(shuffleCrewList.get(i), shuffleCrewList.get(i+1)));
            }
            return;
        }
        for (int i = 0; i < shuffleCrewList.size() - 2; i+=2) {
            if (i == shuffleCrewList.size() - 3) {
                pairList.addPair(new Pair(shuffleCrewList.get(i), shuffleCrewList.get(i+1), shuffleCrewList.get(i+2)));
                return;
            }
            pairList.addPair(new Pair(shuffleCrewList.get(i), shuffleCrewList.get(i+1)));
        }
    }
}
