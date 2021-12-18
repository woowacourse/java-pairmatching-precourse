package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MatchRepository {
	private static List<Match> matchList = new ArrayList<>();

	public static void enrollMatch(Match match) {
		matchList.add(match);
	}

	public static List<Match> findMatchesByLevel(Level level) {
		return matchList.stream().filter(match -> match.isLevel(level)).collect(Collectors.toList());
	}
}
