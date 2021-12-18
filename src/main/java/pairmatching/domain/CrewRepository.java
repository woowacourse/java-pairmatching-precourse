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

	public static List<Crew> getCrews(Course course) {
		if (course.equals(Course.BACKEND)) {
			return backendCrews;
		}
		return frontendCrews;
	}
}
