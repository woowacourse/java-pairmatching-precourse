package pairmatching.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;

public class CrewMembers {

	private static Map<Course, List<Crew>> crewMembers = new HashMap<>();

	public static void add(Course course, List<Crew> crews) {
		crewMembers.put(course, crews);
	}

	public static List<Crew> getCrewsByCourse(Course course){
		return crewMembers.get(course);
	}
}
