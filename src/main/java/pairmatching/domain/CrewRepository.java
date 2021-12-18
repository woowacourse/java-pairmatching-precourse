package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class CrewRepository {
	public static final List<Crew> backend = new ArrayList<>();
	public static final List<Crew> frontend = new ArrayList<>();

	public static void addCrew(Course course, String name) {
		Crew crew = new Crew(course, name);
		if (course == Course.BACKEND) {
			backend.add(crew);
		}
		frontend.add(crew);
	}
}
