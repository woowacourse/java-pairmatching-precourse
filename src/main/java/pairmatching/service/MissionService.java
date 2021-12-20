package pairmatching.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
			throw new IllegalArgumentException("[ERROR] " + "그런 레벨은 없습니다");
		return missionRepository;
	}

	public Mission getMission(Mission mission) {
		return getMissionRepository(mission.getLevel()).findByName(mission.getName())
			.orElseThrow(() -> new IllegalArgumentException("[ERROR] " + "그런 미션은 없습니다"));
	}

	public void save(Mission mission) {
		getMissionRepository(mission.getLevel()).save(mission);
	}
}
