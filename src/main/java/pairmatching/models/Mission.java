package pairmatching.models;

import java.util.List;

public class Mission {

	final String level;

	final List<String> missions;

	public Mission(final String level, final List<String> missions) {
		this.level = level;
		this.missions = missions;
	}

	public void addMission(final String mission) {
		this.missions.add(mission);
	}

	public List<String> getMissionList() {
		return missions;
	}

	public String getLevel() {
		return level;
	}
}
