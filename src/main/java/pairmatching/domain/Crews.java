package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Crews {
	private final List<Crew> crews = new ArrayList<>();

	public void addByCrewName(List<String> crewNames, Course course) {
		crewNames.forEach(crewName -> {
			crews.add(new Crew(course, crewName));
		});
	}

	public List<Crew> getCrewsByCourse(Course course) {
		return crews.stream().filter(crew -> crew.isCourse(course)).collect(Collectors.toList());
	}
}
