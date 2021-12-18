package pairmatching.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import pairmatching.constant.Course;
import pairmatching.domain.Crew;

public class CrewRepository {
	private Map<Course, List<Crew>> crewMap;

	public CrewRepository(List<String> frontendCrews, List<String> backendCrews) {
		this.crewMap = new HashMap<>();
		crewMap.put(Course.FRONTEND,
			frontendCrews.stream().map(name -> new Crew(Course.FRONTEND, name)).collect(Collectors.toList()));
		crewMap.put(Course.BACKEND,
			frontendCrews.stream().map(name -> new Crew(Course.BACKEND, name)).collect(Collectors.toList()));
	}

	public List<String> getCrews(Course course) {
		return crewMap.get(course).stream().map(Crew::getName).collect(Collectors.toList());
	}
}
