package pairmatching.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MatchingRepository {
	private static final int FIRST_PAIRS = 0;
	private static final List<Matching> matchings = new ArrayList<>();

	public static List<Matching> matchings() {
		return Collections.unmodifiableList(matchings);
	}

	public static void addMatching(Matching matching) {
		matchings.add(matching);
	}

	public static Pairs selectMatchings(Course course, Level level, MissionType missionType) {
		List<Pairs> pairs = matchings().stream()
			.filter(matching -> matching.equalsCourse(course))
			.filter(matching -> matching.equalsLevel(level))
			.filter(matching -> matching.equalsMissionType(missionType))
			.map(Matching::getPairs)
			.collect(Collectors.toList());

		return pairs.get(FIRST_PAIRS);
	}
}
