package pairmatching.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Crews {
	private static Map<Course, List<Crew>> crewListMap = new HashMap<>();
	private List<Crew> backEndList = new ArrayList<>();
	private List<Crew> frontEndList = new ArrayList<>();

	public void addBackEndCrews(List<String> crewNames) {
		for (String crewName : crewNames) {
			backEndList.add(new Crew(Course.BACKEND, crewName));
		}
	}

	public void addFrontEndCrews(List<String> crewNames) {
		for (String crewName : crewNames) {
			frontEndList.add(new Crew(Course.FRONTEND, crewName));
		}
	}

	public void addMapCrewList() {
		crewListMap.put(Course.FRONTEND, frontEndList);
		crewListMap.put(Course.BACKEND, backEndList);
	}

	public static List<Crew> getCrewList(Course course) {
		return crewListMap.get(course);
	}

	public static List<String> getCrewNames(List<Crew> crewList) {
		return crewList.stream()
			.map(Crew::getName)
			.collect(Collectors.toList());
	}

}
