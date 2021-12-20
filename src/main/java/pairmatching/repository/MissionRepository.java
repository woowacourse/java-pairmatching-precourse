package pairmatching.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import pairmatching.domain.Mission;

public class MissionRepository {
	private final Map<String, Mission> missionMap;

	public MissionRepository() {
		this.missionMap = new HashMap<>();
	}

	public Optional<Mission> findByName(String name) {
		return Optional.ofNullable(missionMap.get(name));
	}

	public void save(Mission mission) {
		missionMap.put(mission.getName(), mission);
	}

	public void clear() {
		missionMap.clear();
	}
}
