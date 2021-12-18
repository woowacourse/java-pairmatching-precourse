package pairmatching.model;

import java.util.ArrayList;
import java.util.List;

public class CrewRepository {
	private static List<Crew> crews = new ArrayList<>();

	public static void save(Crew crew) {
		crews.add(crew);
	}

	public static void saveAll(List<Crew> crewList) {
		 crews.addAll(crewList);
	}

	public static List<Crew> findAll() {
		return crews;
	}
}
