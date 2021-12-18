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
}
