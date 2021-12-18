package pairmatching.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MatchingHistory {
	Map<Level, List<Pair>> matchingHistory;

	public MatchingHistory() {
		matchingHistory = new LinkedHashMap<>();
	}

	public boolean isExistPair(Level level, List<String> pair) {
		List<Pair> pairList = matchingHistory.get(level);
		if (pairList == null) {
			return false;
		}
		for (Pair currentPair:
			 pairList) {
			if (currentPair.isSamePair(pair)) {
				return true;
			}
		}
		return false;
	}

	public void addHisotry(Level levelByString, List<Pair> pairList) {
		List<Pair> existPair = matchingHistory.get(levelByString);
		if (existPair == null) {
			matchingHistory.put(levelByString, pairList);
			return;
		}
		existPair.addAll(pairList);
		matchingHistory.put(levelByString, existPair);
	}
}
