package pairmatching.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatchingRepository {
	private static final List<Matching> matchings = new ArrayList<>();

	public static List<Matching> matchings() {
		return Collections.unmodifiableList(matchings);
	}

	public static void addMatching(Matching matching) {
		matchings.add(matching);
	}
}
