package pairmatching.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pairmatching.constant.Course;
import pairmatching.domain.Crew;

public class CrewRepository {
	private Map<Course, Crew> crewMap;

	public CrewRepository(List<String> frontendCrews, List<String> backendCrews) {
		this.crewMap = new HashMap<>();
		frontendCrews.forEach(name -> crewMap.put(Course.FRONTEND, new Crew(Course.FRONTEND, name)));
		backendCrews.forEach(name -> crewMap.put(Course.BACKEND, new Crew(Course.BACKEND, name)));
	}
}
