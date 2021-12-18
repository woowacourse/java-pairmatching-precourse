package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class MatchedPairsRepository {
	private static final List<MatchedPairs> matchedPairsList = new ArrayList<>();

	public static boolean isMatched(Course course, Mission mission) {
		return matchedPairsList.stream()
			.anyMatch(matchedPairs -> matchedPairs.isMission(mission) && matchedPairs.isCourse(course));
	}

	public static MatchedPairs findByCourseAndMission(Course course, Mission mission) {
		return matchedPairsList.stream()
			.filter(matchedPairs -> matchedPairs.isMission(mission) && matchedPairs.isCourse(course))
			.findFirst()
			.orElse(null);
	}

	public static MatchedPairs findByLevel(Level level) {
		return matchedPairsList.stream()
			.filter(matchedPairs -> matchedPairs.isLevel(level))
			.findFirst()
			.orElse(null);
	}

	public static void add(MatchedPairs matchedPairs) {
		matchedPairsList.add(matchedPairs);
	}

	public static void init() {
		matchedPairsList.clear();
	}
}
