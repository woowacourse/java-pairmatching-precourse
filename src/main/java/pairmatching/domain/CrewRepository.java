package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class CrewRepository {
	public static final List<Crew> crews = new ArrayList<>();

	public static void addCrew(Crew crew) {
		crews.add(crew);
	}
}
