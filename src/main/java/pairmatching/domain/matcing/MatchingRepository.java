package pairmatching.domain.matcing;

import java.util.LinkedHashSet;
import java.util.Set;

public class MatchingRepository {

	private Set<Matching> matchings;

	public MatchingRepository() {
		this.matchings = new LinkedHashSet<>();
	}

	public void init() {
		this.matchings.clear();
	}

}
