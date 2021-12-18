package pairmatching;

import java.util.HashMap;

public class PairStorage {
	// HashMap<Course, HashMap<Level, HashMap<Mission, HashMap<Crew,Crew>>>>
	static final HashMap<Course, HashMap> pairMap = new HashMap<>();

	public PairStorage() {
		setPairMap();
	}

	private void setPairMap() {
		for (Course course : Course.values()) {
			pairMap.put(course, getPairMapLevel());
		}
	}

	private HashMap<Level, HashMap>  getPairMapLevel() {
		HashMap<Level, HashMap> levelMap = new HashMap<>();
		for (Level level : Level.values()) {
			levelMap.put(level,getMissionMap(level));
		}
		return levelMap;
	}

	private HashMap<Mission, HashMap> getMissionMap(Level level) {
		HashMap<Mission, HashMap> missionMap = new HashMap();
		for (Mission mission : Mission.getMissionListByLevel(level)) {
			missionMap.put(mission, new HashMap());
		}
		return missionMap;
	}

	public static HashMap<Course, HashMap> getPairMap() {
		return pairMap;
	}
}
