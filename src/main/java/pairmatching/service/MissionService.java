package pairmatching.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import pairmatching.constant.ExceptionMessage;
import pairmatching.constant.Level;
import pairmatching.constant.MissionName;
import pairmatching.domain.Mission;
import pairmatching.repository.MissionRepository;

public class MissionService {

	private final Map<Level, MissionRepository> missionRepositoryMap;

	public MissionService() {
		this.missionRepositoryMap = new HashMap<>();
		Arrays.stream(MissionName.values())
			.forEach(missionAtLevel -> missionAtLevel.getNames()
				.forEach(name -> missionRepositoryMap.put(missionAtLevel.getLevel(), new MissionRepository())));
	}

	private MissionRepository getMissionRepository(Level level) {
		MissionRepository missionRepository = missionRepositoryMap.get(level);
		if (missionRepository == null)
			throw new IllegalArgumentException(ExceptionMessage.INVALID_LEVEL);
		return missionRepository;
	}

	public Mission getMission(Mission mission) {
		return getMissionRepository(mission.getLevel()).findByName(mission.getName())
			.orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.INVALID_MISSION_NAME));
	}

	public void save(Mission mission) {
		getMissionRepository(mission.getLevel()).save(mission);
	}
}
