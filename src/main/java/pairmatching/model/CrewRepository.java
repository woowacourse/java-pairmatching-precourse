package pairmatching.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CrewRepository {
	private static List<Crew> crews = new ArrayList<>();

	public static void save(Crew crew) {
		crews.add(crew);
	}

	public static void saveAll(List<Crew> crewList) {
		 crews.addAll(crewList);
	}

	public static List<Crew> findAllByCourse(Course course) {
		return crews.stream().filter(c -> c.getCourse().equals(course)).collect(Collectors.toList());
	}

	public static Crew findByName(String name) {
		return crews.stream().filter(c -> c.getName().equals(name)).findFirst().get();
	}
}
