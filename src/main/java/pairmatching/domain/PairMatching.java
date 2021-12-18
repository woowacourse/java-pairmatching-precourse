package pairmatching.domain;

import java.util.HashMap;
import java.util.List;

import pairmatching.constant.Course;

public class PairMatching {
	private final HashMap<Course, List<String>> crewNameMap;

	public PairMatching() {
		crewNameMap = new HashMap<>();
	}

	public void setCrews(Course course, List<String> crewNames) {
		crewNameMap.put(course, crewNames);
	}

	public List<String> getCrewNames(Course course) {
		return crewNameMap.get(course);
	}
}
