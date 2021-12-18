package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Crews {
	private final List<Crew> crews;

	public Crews() {
		crews = new ArrayList<>();
	}

	public void addCrewsByNameList(Course course, List<String> nameList) {
		for (String name : nameList) {
			crews.add(new Crew(course, name));
		}
	}
}
