package pairmatching.model;

import java.util.List;
import java.util.stream.Collectors;

public class Crews {
	public final List<Crew> crews;

	public Crews(Course course) {
		crews = getCrewsByCourse(course);
	}

	public static Crews create(Course course) {
		return new Crews(course);
	}

	private List<Crew> getCrewsByCourse(Course course) {
		List<String> crewNames = CrewNames.create(course).get();

		return crewNames.stream()
			.map(crewName -> Crew.create(course, crewName))
			.collect(Collectors.toList());
	}
}
