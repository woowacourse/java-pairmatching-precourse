package pairmatching.service;

import pairmatching.model.Level;
import pairmatching.model.LevelMissionsMap;
import pairmatching.model.Mission;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseDataService {

	public LevelMissionsMap initLevelAndMissions() {
		HashMap<Level, List<Mission>> levelAndMissions = new HashMap<>();
		levelAndMissions.put(Level.LEVEL1, level1Missions());
		levelAndMissions.put(Level.LEVEL2, level2Missions());
		levelAndMissions.put(Level.LEVEL3, level3Missions());
		levelAndMissions.put(Level.LEVEL4, level4Missions());
		levelAndMissions.put(Level.LEVEL5, level5Missions());
		return new LevelMissionsMap(levelAndMissions);
	}

	private List<Mission> level1Missions() {
		List<Mission> missions = new ArrayList<>();
		missions.add(Mission.CAR_RACING);
		missions.add(Mission.LOTTO);
		missions.add(Mission.BASEBALL);
		return missions;
	}

	private List<Mission> level2Missions() {
		List<Mission> missions = new ArrayList<>();
		missions.add(Mission.CART);
		missions.add(Mission.PAYMENT);
		missions.add(Mission.SUBWAY);
		return missions;
	}

	private List<Mission> level3Missions() {
		List<Mission> missions = new ArrayList<>();
		return missions;
	}

	private List<Mission> level4Missions() {
		List<Mission> missions = new ArrayList<>();
		missions.add(Mission.UPGRADE);
		missions.add(Mission.RELEASE);
		return missions;
	}

	private List<Mission> level5Missions() {
		List<Mission> missions = new ArrayList<>();
		return missions;
	}
}
