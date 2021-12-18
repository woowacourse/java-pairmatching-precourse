package pairmatching.model;

import java.util.ArrayList;
import java.util.HashMap;
import pairmatching.type.Mission;
import pairmatching.type.Level;

public class Missions {
	public static HashMap<Level, ArrayList<String>> missions = new HashMap<>();

	static {
		missions.put(Level.LEVEL1, setMission1());
		missions.put(Level.LEVEL2, setMission2());
		missions.put(Level.LEVEL3, setMission3());
		missions.put(Level.LEVEL4, setMission4());
		missions.put(Level.LEVEL5, setMission5());
	}

	private static ArrayList<String> setMission1() {
		ArrayList<String> mission = new ArrayList<>();
		mission.add(Mission.RACING_CAR.getMission());
		mission.add(Mission.LOTTO.getMission());
		mission.add(Mission.BASEBALL.getMission());
		return mission;
	}

	private static ArrayList<String> setMission2() {
		ArrayList<String> mission = new ArrayList<>();
		mission.add(Mission.BASKET.getMission());
		mission.add(Mission.PURCHASE.getMission());
		mission.add(Mission.SUBWAY.getMission());
		return mission;
	}

	private static ArrayList<String> setMission3() {
		ArrayList<String> mission = new ArrayList<>();
		return mission;
	}

	private static ArrayList<String> setMission4() {
		ArrayList<String> mission = new ArrayList<>();
		mission.add(Mission.IMPROVEMENT.getMission());
		mission.add(Mission.DISTRIBUTE.getMission());
		return mission;
	}

	private static ArrayList<String> setMission5() {
		ArrayList<String> mission = new ArrayList<>();
		return mission;
	}
}
