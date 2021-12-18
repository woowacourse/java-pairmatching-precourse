package pairmatching.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import pairmatching.constant.Course;
import pairmatching.constant.Level;
import pairmatching.domain.Crew;

public class CrewRepository {
	private Map<Course, Map<String, Crew>> crewMap;

	public CrewRepository(List<String> frontendCrews, List<String> backendCrews) {
		this.crewMap = new HashMap<>();
		crewMap.put(Course.FRONTEND, new HashMap<>());
		crewMap.put(Course.BACKEND, new HashMap<>());
		frontendCrews.forEach(name -> crewMap.get(Course.FRONTEND).put(name, new Crew(Course.FRONTEND, name)));
		backendCrews.forEach(name -> crewMap.get(Course.BACKEND).put(name, new Crew(Course.BACKEND, name)));
	}

	public List<String> getCrews(Course course) {
		return crewMap.get(course).values().stream().map(Crew::getName).collect(Collectors.toList());
	}

	public Crew findByName(Course course, String name) {
		return crewMap.get(course).get(name);
	}

	public void addToHistory(Course course, String crew, Level level, String opponent) {
		findByName(course, crew).addHistory(level, opponent);
	}
}
