package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Missions {
	private List<Mission> missions;

	public Missions(List<Mission> missions) {
		this.missions = missions;
	}

	public void add(Mission mission) {
		missions.add(mission);
	}

	public Missions getByLevel(Level level) {
		return new Missions(missions.stream()
			.filter(mission -> mission.isLevel(level))
			.collect(Collectors.toList()));
	}

	public Mission getByMissionName(String missionName) {
		return missions.stream()
			.filter(mission -> mission.getName().equals(missionName))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("[ERROR] 입력한 미션은 존재하지 않습니다."));
	}

	public boolean haveName(String missionName) {
		return getNames().contains(missionName);
	}

	public List<String> getNames() {
		return missions.stream().map(Mission::getName).collect(Collectors.toList());
	}

	public boolean isEmpty() {
		return missions.isEmpty();
	}
}
