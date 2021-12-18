package pairmatching.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairRepository {
	private final Map<MatchParams, List<Crew>> pairs = new HashMap<>();

	public void addPair(MatchParams params, List<Crew> crews) {
		pairs.put(params, crews);
	}
}
