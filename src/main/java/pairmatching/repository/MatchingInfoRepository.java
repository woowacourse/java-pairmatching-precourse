package pairmatching.repository;

import java.util.HashMap;
import java.util.Map;
import pairmatching.domain.MatchingInfo;
import pairmatching.domain.pair.Pairs;

public class MatchingInfoRepository {

    private static final Map<MatchingInfo, Pairs> matchingRepository = new HashMap<>();

    public boolean nonexistentPutMatchingInfo(MatchingInfo matchingInfo, Pairs pairs) {
        if (hasSamePairByLevel(matchingInfo, pairs)) {
            return false;
        }
        putMatchingInfo(matchingInfo, pairs);
        return true;
    }

    private void putMatchingInfo(MatchingInfo matchingInfo, Pairs pairs) {
        matchingRepository.put(matchingInfo, pairs);
    }

    private boolean hasSamePairByLevel(MatchingInfo matchingInfo, Pairs pairs) {
        return matchingRepository.entrySet()
                .stream()
                .filter(entry -> entry.getKey().equalsLevel(matchingInfo))
                .anyMatch(entry -> entry.getValue().contains(pairs));
    }

    public boolean hasInfo(MatchingInfo matchingInfo) {
        return matchingRepository.entrySet()
                .stream()
                .anyMatch(entry -> entry.getKey().equals(matchingInfo));
    }

    public Pairs getPairs(MatchingInfo matchingInfo) {
        return matchingRepository.get(matchingInfo);
    }

    public void clearRepository() {
        matchingRepository.clear();
    }
}
