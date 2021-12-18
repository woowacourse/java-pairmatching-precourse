package pairmatching.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pairmatching.constant.Level;
import pairmatching.constant.Mission;

public class Matching {
	private static final String SPLIT_REGEX = ",";
	private static final String FRONT_NO_ERROR = "[ERROR] 매칭 이력이 없습니다.\n";

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

	public void setBackResult(List<String> crewNames) {
		for (int i = 0; i < crewNames.size(); i = i + 2) {
			List<String> temp = new ArrayList<>();
			temp.add(crewNames.get(i));
			temp.add(crewNames.get(i + 1));
			backResult.add(temp);
		}
		if (crewNames.size() % 2 != 0) {
			backResult.get(backResult.size() - 1).add(crewNames.get(crewNames.size() - 1));
		}
	}

	public List<List<String>> getBackResult() {
		if (backResult.size() == 0) {
			throw new IllegalArgumentException(FRONT_NO_ERROR);
		}
		return backResult;
	}

	public void setFrontResult(List<String> crewNames) {
		for (int i = 0; i < crewNames.size(); i = i + 2) {
			List<String> temp = new ArrayList<>();
			temp.add(crewNames.get(i));
			temp.add(crewNames.get(i + 1));
			frontResult.add(temp);
		}
		if (crewNames.size() % 2 != 0) {
			frontResult.get(frontResult.size() - 1).add(crewNames.get(crewNames.size() - 1));
		}
	}

	public List<List<String>> getFrontResult() {
		if (frontResult.size() == 0) {
			throw new IllegalArgumentException(FRONT_NO_ERROR);
		}
		return frontResult;
	}

	public void resetResults() {
		backResult.clear();
		frontResult.clear();
	}
}
