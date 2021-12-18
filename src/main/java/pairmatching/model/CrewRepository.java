package pairmatching.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CrewRepository {
	private static final List<Crew> crews = new ArrayList<>();

	public static final List<Crew> crews() {
		return Collections.unmodifiableList(crews);
	}

	public static void addCrew(Crew crew) {
		crews.add(crew);
	}
}
