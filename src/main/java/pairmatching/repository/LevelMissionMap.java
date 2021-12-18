package pairmatching.repository;

import java.util.HashMap;
import java.util.Map;

import pairmatching.domain.Level;

public class LevelMissionMap {
	private static final Map<Level, String> levelMissionMap = new HashMap<>();

	public static void add(Level level, String mission) {
		levelMissionMap.put(level, mission);
	}
}
