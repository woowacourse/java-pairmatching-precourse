package pairmatching.model;

import java.util.List;
import java.util.stream.Collectors;

import pairmatching.exception.DuplicatedCrewNameException;

public class CrewRepository {
	private final List<Crew> crews;

	public CrewRepository(List<String> crewNameList) {
		validateDuplicateCrewName(crewNameList);
		this.crews = createCrewRepository(crewNameList);
	}

	private List<Crew> createCrewRepository(List<String> crewNameList) {
		return crewNameList
			.stream().map(crewName -> new Crew(crewName))
			.collect(Collectors.toList());
	}

	private void validateDuplicateCrewName(List<String> crewNameList) {
		if (hasDuplicatedCrewName(crewNameList)) {
			throw new DuplicatedCrewNameException();
		}
	}

	private boolean hasDuplicatedCrewName(List<String> crewNameList) {
		return crewNameList.stream().collect(Collectors.toSet()).size() != crewNameList.size();
	}
}
