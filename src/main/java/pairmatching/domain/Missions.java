package pairmatching.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Missions {
	private static Map<Level, List<Mission>> levelListMap = new HashMap<>();
	private List<Mission> level1Missions = new ArrayList<>();
	private List<Mission> level2Missions = new ArrayList<>();
	private List<Mission> level4Missions = new ArrayList<>();

	public void addLevel1Mission(List<String> missionNames) {
		for (String missionName : missionNames) {
			level1Missions.add(new Mission(Level.LEVEL1, missionName));
		}
	}

	public void addLevel2Mission(List<String> missionNames) {
		for (String missionName : missionNames) {
			level1Missions.add(new Mission(Level.LEVEL2, missionName));
		}
	}

	public void addLevel4Mission(List<String> missionNames) {
		for (String missionName : missionNames) {
			level1Missions.add(new Mission(Level.LEVEL4, missionName));
		}
	}

	public void addMapCrewList() {
		levelListMap.put(Level.LEVEL1, level1Missions);
		levelListMap.put(Level.LEVEL2, level2Missions);
		levelListMap.put(Level.LEVEL4, level4Missions);
	}

	public static List<Mission> getMissionList(Level level) {
		return levelListMap.get(level);
	}

	public static Mission getMission(Level level, String missionName) {
		return getMissionList(level).stream()
			.filter(mission -> mission.getName().equals(missionName))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("[ERROR] 해당 레벨에 입력하신 미션이 존재하지 않습니다."));
	}

}
