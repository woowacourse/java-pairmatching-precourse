package pairmatching.domain.matcing;

import java.util.LinkedHashSet;
import java.util.Set;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;

public class MatchingRepository {

	private Set<Matching> matchings;

	public MatchingRepository() {
		this.matchings = new LinkedHashSet<>();
	}

	public void addMatching(Matching matching) {
		matchings.add(matching);
	}

	public Matching findMatching(Course course, Level level, Mission mission) {
		return matchings.stream()
			.filter(matching -> matching.isSameCourse(course))
			.filter(matching -> matching.isSameLevel(level))
			.filter(matching -> matching.isSameMission(mission))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("매칭이 존재하지 않습니다."));
	}

	public void init() {
		this.matchings.clear();
	}

}
