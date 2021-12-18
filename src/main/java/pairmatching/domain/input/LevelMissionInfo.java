package pairmatching.domain.input;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LevelMissionInfo {

	private final Map<Level, List<String>> levelMissionMap;

	private LevelMissionInfo() {
		this.levelMissionMap = new TreeMap<>();
	}

	public static LevelMissionInfo newInstance() {
		return new LevelMissionInfo();
	}

	public void addInfo(Level level, List<String> missionList) {
		levelMissionMap.put(level, missionList);
	}

	public void addInfo(Level level) {
		levelMissionMap.put(level, null);
	}

	public Map<Level, List<String>> getLevelMissionMap() {
		return levelMissionMap;
	}

}
