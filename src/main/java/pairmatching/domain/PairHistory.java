package pairmatching.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import pairmatching.constant.Level;

public class PairHistory {
	private Map<Level, Set<String>> nameAtLevelMap;

	public PairHistory() {
		this.nameAtLevelMap = new HashMap<>();
		Arrays.stream(Level.values()).forEach(level -> nameAtLevelMap.put(level, new HashSet<>()));
	}

	public void add(Level level, String opponent) {
		nameAtLevelMap.get(level).add(opponent);
	}

	public boolean didMeet(Level level, String opponent) {
		return nameAtLevelMap.get(level).contains(opponent);
	}
}
