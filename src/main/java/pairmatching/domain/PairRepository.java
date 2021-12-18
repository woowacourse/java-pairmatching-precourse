package pairmatching.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pairmatching.enums.Level;

public class PairRepository {
	private Map<Level, List<Pairs>> pairsMap = new HashMap<>();

	public PairRepository() {
		for (Level level : Level.values()) {
			pairsMap.put(level, new ArrayList<>());
		}
	}

	public void setPair(Level level, Pairs pairs) {
		pairsMap.get(level).add(pairs);
	}
}
