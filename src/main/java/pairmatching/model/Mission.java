package pairmatching.model;

import java.util.Arrays;

import pairmatching.validator.LevelValidator;
import pairmatching.validator.MissionValidator;

public class Mission {
	private String name;
	private MatchingPairs matchingPairs = null;

	public Mission(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public MatchingPairs getMatchingPairs() {
		return matchingPairs;
	}

	public static Mission parse(Level level, String name) {
		Level.isValidMission(level, name);
		Mission mission = new Mission(name);
		return mission;
	}

	public void initializeMatchingPairs() {
		this.matchingPairs = null;
	}

	public void setMatchingPairs(MatchingPairs matchingPairs) {
		this.matchingPairs = matchingPairs;
	}
}
