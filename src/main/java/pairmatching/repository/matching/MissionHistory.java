package pairmatching.repository.matching;

import java.util.Set;
import pairmatching.domain.Pair;

public class MissionHistory {
    private Set<Pair> pairs;

    public Pair getPair(String crewName){
        return pairs.stream()
                .filter(pair -> pair.isContains(crewName))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
