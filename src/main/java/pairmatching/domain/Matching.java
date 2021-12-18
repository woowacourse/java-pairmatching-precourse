package pairmatching.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pairmatching.constant.Level;
import pairmatching.constant.Mission;

public class Matching {
	private static final String SPLIT_REGEX = ",";

	private final Level level;
	private final Mission mission;
	private final List<List<String>> backResult;
	private final List<List<String>> frontResult;

	public Matching(Level level, Mission mission) {
		this.level = level;
		this.mission = mission;
		backResult = new ArrayList<>();
		frontResult = new ArrayList<>();
	}

	public Level getLevel() {
		return level;
	}

	public Mission getMission() {
		return mission;
	}

	public boolean isRight(String inputMatching) {
		String[] matchingInfos = setMatching(inputMatching);
		return (level == Level.nameOf(matchingInfos[1])) &&
			(mission == Mission.nameOf(matchingInfos[2]));
	}

	private String[] setMatching(String inputMatching) {
		return Arrays.stream(inputMatching.split(SPLIT_REGEX))
			.map(String::trim)
			.toArray(String[]::new);
	}

	// public void resetResults() {
	// 	backResult.clear();
	// 	frontResult.clear();
	// }
}
