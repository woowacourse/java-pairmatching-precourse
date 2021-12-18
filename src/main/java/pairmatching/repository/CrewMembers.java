package pairmatching.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pairmatching.domain.Course;

public class CrewMembers {

	private static Map<Course, List<String>> crewMembers = new HashMap<>();

	public static void add(Course course, List<String> names) {
		crewMembers.put(course, names);
	}

	public static List<String> getCrewsByCourse(Course course){
		return crewMembers.get(course);
	}
}
