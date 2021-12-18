package pairmatching;

import java.util.HashMap;

public class PairStorage {
	// HashMap<Course, HashMap<Mission, HashMap<Crew,Crew>>>>
	static final HashMap<Course, HashMap> pairMap = new HashMap<>();

	public PairStorage() {
		setPairMap();
	}

	private void setPairMap() {
		for (Course course : Course.values()) {
			pairMap.put(course, getPairMapOfMissions());
		}
	}

	private HashMap<Mission, HashMap> getPairMapOfMissions() {
		HashMap<Mission, HashMap> missionMap = new HashMap();

		for (Mission mission : Mission.values()) {
			missionMap.put(mission, new HashMap());
		}

		return missionMap;
	}

	public static HashMap<Course, HashMap> getPairMap() {
		return pairMap;
	}
}
