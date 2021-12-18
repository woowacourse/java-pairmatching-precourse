package pairmatching.model;

import java.util.List;
import java.util.stream.Collectors;

public class Crews {
	public final List<Crew> crews;

	public Crews(Course course) {
		crews = getCrewsByCourse(course);
	}

	private CrewNames getCrewNamesByCourse(Course course) {
		if (course.isBackend()) {
			return new BackendCrewNames();
		}
		return new FrontendCrewNames();
	}

	private List<Crew> getCrewsByCourse(Course course) {
		List<String> crewNames = getCrewNamesByCourse(course).get();

		return crewNames.stream()
			.map(crewName -> Crew.create(course, crewName))
			.collect(Collectors.toList());
	}
}
