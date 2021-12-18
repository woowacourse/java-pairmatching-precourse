package pairmatching.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

	public static List<String> getNameList(Course course) {
		if (course == Course.BACKEND) {
			return getNameList(backend);
		}
		return getNameList(frontend);
	}

	public static Crew findByName(String name, Course course) {
		if (course == Course.BACKEND) {
			return findByName(name, backend);
		}
		return findByName(name, frontend);

	}

	private static List<String> getNameList(List<Crew> crews) {
		return crews.stream().map(Crew::getName).collect(Collectors.toList());
	}

	private static Crew findByName(String name, List<Crew> crews) {
		return crews.stream()
			.filter(crew -> crew.isName(name))
			.findFirst()
			.get();
	}
}
