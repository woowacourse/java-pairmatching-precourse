package pairmatching.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import pairmatching.constant.Notification;

public class Crews {
	private final Map<String, Crew> crews;

	public Crews(Map<String, Crew> crews) {
		this.crews = crews;
	}

	public static Crews of(List<String> crewNames, Course course) {
		validateDuplicate(crewNames);
		Map<String, Crew> crews = crewNames.stream()
			.map(crewName -> Crew.of(course, crewName))
			.collect(Collectors.toMap(Crew::getName, crew -> crew));
		return new Crews(crews);
	}

	private static void validateDuplicate(List<String> crewNameList) {
		Set<String> crewNameSet = new HashSet<>(crewNameList);
		if (crewNameSet.size() != crewNameList.size()) {
			throw new IllegalArgumentException(Notification.CREW_NAME_DUPLICATED.getMessage());
		}
	}

	public List<Crew> getCrews() {
		return new ArrayList<>(crews.values());
	}
}
