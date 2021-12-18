package pairmatching.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Crews {
	private final List<Crew> crews;

	public Crews(List<Crew> crews) {
		this.crews = crews;
	}

	public List<Crew> getCrews() {
		return crews;
	}

	public List<String> getCourseCrewsNames(Course course) {
		return crews.stream()
			.filter(e -> e.getCourse() == course)
			.map(Crew::getName)
			.collect(Collectors.toList());
	}

	public Crew findCrew(String name) {
		return crews.stream()
			.filter(e -> e.getName().equals(name))
			.findAny()
			.get();
	}
}
