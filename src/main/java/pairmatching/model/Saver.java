package pairmatching.model;

import java.util.ArrayList;

public class Saver {

	public static final Saver saver = new Saver();
	private final int SIZE = 5;
	private ArrayList<ArrayList<CrewPair>> savedResult;

	private Saver() {
		this.savedResult = new ArrayList<>();
		for (int nowSize = 0; nowSize < SIZE; nowSize++) {
			this.savedResult.add(new ArrayList<CrewPair>());
		}
	}

	public boolean isValidMatch(ArrayList<CrewPair> matchResult, int levelIndex) {
		for (CrewPair eachPair : matchResult) {
			int duplicateCount = (int)this.savedResult.get(levelIndex).stream()
				.filter(nowPair -> nowPair.isSame(eachPair.getJoinedName()))
				.count();
			if (duplicateCount > 0) {
				return false;
			}
		}
		return true;
	}

	public void setMatch(ArrayList<CrewPair> matchResult, int levelIndex) {
		this.savedResult.set(levelIndex, matchResult);
	}

	public ArrayList<CrewPair> getMatch(int levelIndex) {
		return this.savedResult.get(levelIndex);
	}
}
