package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class CrewRepository {
	private static List<Crew> backendCrews = new ArrayList<>();
	private static List<Crew> frontendCrews = new ArrayList<>();

	public static void addCrew(Crew crew) {
		if (crew.getCourse().equals(Course.BACKEND)) {
			backendCrews.add(crew);
			return;
		}
		frontendCrews.add(crew);
	}
}
