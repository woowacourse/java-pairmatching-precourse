package pairmatching.service;

import java.util.List;
import java.util.stream.Collectors;

import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.repository.MissionRepository;

public class MissionService {
	private final MissionRepository missionRepository = new MissionRepository();

	public Long save(Mission mission) {
		return missionRepository.save(mission);
	}

	public Mission findById(Long id) {
		return missionRepository.findById(id);
	}

	public List<String> getMissionNamesByLevel(Level level) {
		return missionRepository.findAll().stream()
			.filter(mission -> mission.getLevel() == (level))
			.map(Mission::getName)
			.collect(Collectors.toList());
	}

	public List<String> getMissionNames() {
		return missionRepository.findAll().stream()
			.map(Mission::getName)
			.collect(Collectors.toList());
	}

	public Mission findByName(String name) {
		return missionRepository.findByName(name);
	}
}
