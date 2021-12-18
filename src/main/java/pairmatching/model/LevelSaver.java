package pairmatching.model;

import java.util.ArrayList;

public class LevelSaver {

	public static final LevelSaver LEVEL_SAVER = new LevelSaver();
	private final int SIZE = 5;
	private ArrayList<ArrayList<CrewPair>> savedResult;

	private LevelSaver() {
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
		for (CrewPair nowPair : matchResult) {
			this.savedResult.get(levelIndex).add(nowPair);
		}
	}

	public ArrayList<CrewPair> getMatch(int levelIndex) {
		return this.savedResult.get(levelIndex);
	}

	public void initPair() {
		for (int index = 0; index < SIZE; index++) {
			this.savedResult.set(index, new ArrayList<>());
		}
	}
}
