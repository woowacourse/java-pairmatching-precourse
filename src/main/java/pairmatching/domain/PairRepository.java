package pairmatching.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PairRepository {
	private final Map<MatchParams, List<List<String>>> pairs = new HashMap<>();

	public void addPair(MatchParams params, List<List<String>> crews) {
		pairs.put(params, crews);
	}

	public String getMatchResultString(MatchParams params) {
		List<List<String>> pairList = new ArrayList<>();
		for (MatchParams matchParams : pairs.keySet()) {
			if (matchParams.equals(params)) {
				pairList = pairs.get(matchParams);
				break;
			}
		}

		return pairList.stream()
			.map(item -> String.join(" : ", item))
			.collect(Collectors.joining("\n"));
	}

	public boolean isExistParam(MatchParams params) {
		for (MatchParams matchParams : pairs.keySet()) {
			if (matchParams.equals(params))
				return true;
		}

		return false;
	}

	public void resetPairs() {
		pairs.clear();
	}
}
