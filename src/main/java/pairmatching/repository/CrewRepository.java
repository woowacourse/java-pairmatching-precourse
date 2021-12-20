package pairmatching.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import pairmatching.domain.Crew;

public class CrewRepository {
	private final Map<String, Crew> crewMap;

	public CrewRepository(List<String> crews) {
		this.crewMap = new HashMap<>();
		crews.forEach(name -> crewMap.put(name, new Crew(name)));
	}

	public List<String> getCrewNames() {
		return crewMap.values().stream().map(Crew::getName).collect(Collectors.toList());
	}

	public void clearHistories() {
		crewMap.values().forEach(Crew::clearMeet);
	}

	public Optional<Crew> findByName(String name) {
		return Optional.ofNullable(crewMap.get(name));
	}
}
