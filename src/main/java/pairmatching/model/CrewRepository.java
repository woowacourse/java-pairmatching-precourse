package pairmatching.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CrewRepository {
	private static final List<Crew> crews = new ArrayList<>();

	public static final List<Crew> crews() {
		return Collections.unmodifiableList(crews);
	}

	public static void addCrew(Crew crew) {
		crews.add(crew);
	}

	public static List<String> findByCourse(Course course) {
		return crews.stream()
			.filter(crew -> crew.getCourse().equals(course))
			.map(Crew::getName)
			.collect(Collectors.toList());
	}
}
