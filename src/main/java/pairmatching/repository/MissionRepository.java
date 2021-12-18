package pairmatching.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pairmatching.domain.Mission;

public class MissionRepository {
	private Long id = 0L;
	private final Map<Long, Mission> missions = new HashMap<>();

	public Long save(Mission mission) {
		missions.put(id, mission);
		return id++;
	}

	public Mission findById(Long id) {
		return missions.get(id);
	}

	public List<Mission> findAll() {
		return new ArrayList<>(missions.values());
	}
}
