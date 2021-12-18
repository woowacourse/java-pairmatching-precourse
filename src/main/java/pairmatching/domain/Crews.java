package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Crews {
	private final List<Crew> crews = new ArrayList<>();

	public void addByCrewName(List<String> crewNames, Course course) {
		crewNames.forEach(crewName -> {
			crews.add(new Crew(course, crewName));
		});
	}
}
