package pairmatching.domain.matcing;

import java.util.LinkedHashSet;
import java.util.Set;

import pairmatching.domain.Menu;

public class MatchingRepository {

	private Set<Matching> matchings;

	public MatchingRepository() {
		this.matchings = new LinkedHashSet<>();
	}

	public void addMatching(Matching matching) {
		matchings.add(matching);
	}

	public Matching findMatching(Menu menu) {
		return matchings.stream()
			.filter(matching -> matching.isSameCourse(menu.getCourse()))
			.filter(matching -> matching.isSameLevel(menu.getLevel()))
			.filter(matching -> matching.isSameMission(menu.getMission()))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("매칭이 존재하지 않습니다."));
	}

	public void init() {
		this.matchings.clear();
	}

}
