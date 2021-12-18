package pairmatching.util;

import java.util.List;
import java.util.stream.Collectors;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;

public class CrewParse {

	public static List<Crew> make(Course course, List<String> crew) {
		return crew
			.stream()
			.map(e -> new Crew(course, e))
			.collect(Collectors.toList());
	}
}
