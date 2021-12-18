package pairmatching.domain;

import static pairmatching.Constants.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MatchRepository {
	private static List<Match> matchList = new ArrayList<>();

	public static void enrollMatch(Match match) {
		if (!hasInformationLike(match.getInformation())) {
			matchList.add(match);
			return;
		}
		Match matchByInformation = getMatchByInformation(match.getInformation());
		matchList.set(matchList.indexOf(matchByInformation), match);
	}

	public static List<Match> findMatchesByLevel(Level level) {
		return matchList.stream().filter(match -> match.isLevel(level)).collect(Collectors.toList());
	}

	public static boolean hasInformationLike(MatchingInformation information) {
		return matchList.stream().anyMatch(match -> match.hasInformation(information));
	}

	public static Match getMatchByInformation(MatchingInformation information) {
		if (hasInformationLike(information)) {
			return matchList.stream().filter(match -> match.hasInformation(information)).findFirst().get();
		}
		throw new IllegalArgumentException(NO_EXIST_PAIR);
	}

	public static void clearMatchList() {
		matchList.clear();
	}
}
