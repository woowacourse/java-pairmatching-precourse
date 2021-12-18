package pairmatching.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pairmatching.domain.unit.Course;
import pairmatching.domain.unit.Level;
import pairmatching.domain.unit.Mission;

public class MatchingSystem {

	private List<Crew> matchingList;

	public MatchingSystem() {
		this.matchingList = new ArrayList<>();
	}

	public void saveMatchingResult(List<String> names, String course, String level, String mission) {
		matchingList.add(new Crew(Course.mapToCourse(course), Level.mapToLevel(level), Mission.mapToLevel(mission), names));
	}
}
