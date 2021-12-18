package pairmatching.model;

import java.util.List;
import java.util.stream.Collectors;

public class Crews {
	public final List<Crew> crews;

	public Crews(List<Crew> crews) {
		this.crews = crews;
	}

	public Crews(Course course) {
		crews = getCrewsByCourse(course);
	}

	public List<Crew> get() {
		return crews;
	}

	public Crew getCrew(int index) {
		return crews.get(index);
	}

	public static Crews create(Course course, List<String> crewNames) {
		List<Crew> crews = crewNames.stream()
			.map(name -> Crew.create(course, name))
			.collect(Collectors.toList());

		return new Crews(crews);
	}

	public int size() {
		return crews.size();
	}

	private List<Crew> getCrewsByCourse(Course course) {
		List<String> crewNames = CrewNames.create(course).get();

		return crewNames.stream()
			.map(crewName -> Crew.create(course, crewName))
			.collect(Collectors.toList());
	}


}
