package pairmatching.domain.matcing;

import java.util.LinkedHashSet;
import java.util.Optional;
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

	public Optional<Matching> findMatching(Menu menu) {
		return matchings.stream()
			.filter(matching -> matching.isSameCourse(menu.getCourse()))
			.filter(matching -> matching.isSameLevel(menu.getLevel()))
			.filter(matching -> matching.isSameMission(menu.getMission()))
			.findFirst();
	}

	public void init() {
		this.matchings.clear();
	}

}
