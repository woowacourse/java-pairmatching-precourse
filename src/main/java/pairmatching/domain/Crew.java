package pairmatching.domain;

import pairmatching.constant.Level;

public class Crew {
	private final String name;
	private final PairHistory pairHistory;

	public Crew(String name) {
		this.name = name;
		this.pairHistory = new PairHistory();
	}

	public String getName() {
		return name;
	}

	public void addHistory(Level level, String opponent) {
		pairHistory.add(level, opponent);
	}

	public void clearMeet() {
		pairHistory.clearMeet();
	}

	public boolean didMeet(Level level, String opponent) {
		return pairHistory.didMeet(level, opponent);
	}
}
