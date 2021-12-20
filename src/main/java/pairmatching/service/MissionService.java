package pairmatching.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import pairmatching.constant.ExceptionMessage;
import pairmatching.constant.Level;
import pairmatching.domain.Mission;
import pairmatching.repository.MissionRepository;

public class MissionService {

	private final Map<Level, MissionRepository> missionRepositoryMap;

	public MissionService() {
		this.missionRepositoryMap = new HashMap<>();
		Arrays.stream(Level.values())
			.forEach(level -> missionRepositoryMap.put(level, new MissionRepository()));
	}

	private MissionRepository getMissionRepository(Level level) {
		MissionRepository missionRepository = missionRepositoryMap.get(level);
		if (missionRepository == null)
			throw new IllegalArgumentException(ExceptionMessage.INVALID_LEVEL);
		return missionRepository;
	}

	public Mission getMission(Mission mission) {
		return getMissionRepository(mission.getLevel()).findByName(mission.getName())
			.orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.MATCHING_NOT_FOUND));
	}

	public void clearMissions() {
		missionRepositoryMap.values().forEach(MissionRepository::clear);
	}

	public void save(Mission mission) {
		getMissionRepository(mission.getLevel()).save(mission);
	}
}
