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

	public List<String> getMissionsByLevel(Level level) {
		return missionRepository.findAll().stream()
			.filter(x -> x.getLevel() == level)
			.map(Mission::getName)
			.collect(Collectors.toList());
	}
}
