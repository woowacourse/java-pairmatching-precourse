package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

	public static List<Crew> getCrews(Course course, List<String> names) {
		List<Crew> crews = new ArrayList<>();
		if (course.equals(Course.BACKEND)) {
			return mapToCrew(names, backendCrews);
		}
		return mapToCrew(names, frontendCrews);
	}

	private static List<Crew> mapToCrew(List<String> names, List<Crew> crewList) {
		return names.stream().map(name -> findCrew(name, crewList)).collect(Collectors.toList());
	}
	private static Crew findCrew(String name, List<Crew> crewList) {
		return crewList.stream().filter(crew -> crew.toString().equals(name)).findFirst().get();
	}

	public static List<String> getCrewNames(Course course) {
		if (course.equals(Course.BACKEND)) {
			return mapCrewName(backendCrews);
		}
		return mapCrewName(frontendCrews);
	}

	private static List<String> mapCrewName(List<Crew> crewList) {
		return crewList.stream().map(crew -> crew.toString()).collect(Collectors.toList());
	}
}
